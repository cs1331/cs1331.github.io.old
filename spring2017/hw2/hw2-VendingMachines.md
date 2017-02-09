---
layout: homework
title: Homework 2
---

# CS1331 Homework 02 - Vending Machines

[Download zip](hw2-VendingMachines.zip)

## Introduction

It's the year 2021, and you have graduated from Georgia Tech. Your first real job is with Coca-Cola, who is trying to corner the vending machine market by developing specialized vending machines for college campuses. The first models will be placed in the CULC and CoC, and are catered specifically to Tech students. Since you have experience with the student body, you have been tasked with writing the software. However, Coke wants to make sure that their product will be an overwhelming success. For that reason, you will first write a simulator for the machine to test the functionality.

## Problem Description

You will be writing classes that represent various parts of a vending machine. You will need to write two files: `VendingMachine.java` and `VendingItem.java`. A simple driver class (`Driver.java`) has been provided, and it will allow you to interact with your simulation. Specific instructions for each file are given in later sections.

## Background

This section contains some helpful information about material that appears on this homework. If you are more experienced with Java, you may already know everything here. However, we still suggest reading this section to make sure all the techniques are clear.

### Enums

An enum is a special class that has a set of predefined instances. An enum is an enumerated type, and each possible value has an associated numeric value. Enums are used when you have a small set of possible values that you want to represent with a convenient syntax. For example, instead of having an `int` (or `String`) representing colors where some value stands for red, some value for green, and some value for blue, you could have the following enum type:

```
public enum Color {
    RED, GREEN, BLUE;
}

// in other parts of the code...

if (color == Color.RED || color == Color.BLUE) {...}

```

Another feature of enums is the ability to given them properties. For this assignment, you will need to use an enum of vending items that also records each item's price. If you don't remember how to give an enum properties, take a look at [the oracle tutorials.](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html) For our situation, we are using an enum in almost exactly the same way you would use a class.

### Random

The Random class is used to generate numbers in a certain range. After importing `java.util.Random`, you must create a new Random object. For example, `Random rand = new Random()`. In order to generate random integers in a certain range, take note of [the nextInt() method](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#nextInt-int-). Remember that the argument is exclusive, which means that it is 1 larger than the maximum value the method will generate. This might seem counter intuitive, but it gives us a useful rule. Given a call like `rand.nextInt(5)`, we know that exactly 5 values (that is , `0, 1, 2, 3, and 4`) can be generated.

There are two very common techniques involving random numbers that you will need to use in this homework. The first is generating random integers in a range that does not start at 0. Imagine you want to generate numbers ranging from 5 to 10, inclusive on both ends (i.e, the numbers `5, 6, 7, 8, 9, 10`). Since there are six possible values, we need the parameter of `nextInt()` to be 6. However, we also want the smallest number to be 5 (instead of 0). To accomplish this, we can simply add 5 to the random value. This suggests the following formula for generating random integers between `a` and `b`, inclusive: `int n = rand.nextInt(b - a + 1) + a`.

The second technique is using random numbers to generate a percent chance for an event. For example, you might want something to have a 25% chance of happening on each iteration through a loop. In that case, you could do something like:

```
if (rand.nextInt(4) == 0) {
    // do something...
}
```

For more complicated percentages, like 30%, you can think of the percent as a fraction where the numerator and denominator are both whole numbers (for example `30 / 100`). Then, you can generate numbers in the range of the denominator, and compare them against the numerator. To have an event with a 30% chance of happening, you could write:

```
if (rand.nextInt(100) < 30) {
    // event happens
} else {
    // event doesn't happen
}
```

## Solution Description

### VendingItem.java (enum)

Instances of this enum will represent items in your vending machine. Your boss at Coke has done extensive analysis and determined that the following items and prices are ideal for Georgia Tech students:

| Item               | Price     |
|:-------------------|----------:|
|Lays                |$1.50      |
|Doritos             |$1.50      |
|Coke                |$2.50      |
|Ramblin_Reck_Toy    |$180.75    |
|Rubiks_Cube         |$30.00     |
|Rat_Cap             |$15.00     |
|FASET_Lanyard       |$10.00     |
|Graphing_Calculator |$120.00    |
|UGA_Diploma         |$0.10      |
|Pie                 |$3.14      |
|Clicker             |$55.55     |
|Cheetos             |$1.25      |
|Sprite              |$2.50      |
|Red_Bull            |$4.75      |
|Ramen               |$3.15      |

The names of the elements in your enum should be exactly as they appear here, and the price should be a parameter to the enum constructor. Your `VendingItem` enum should have the following fields, methods, and constructors:

- `private final double price`. This field is the price of an item, and should be set in the constructor.

- `VendingItem(double price)`. This is the constructor for the enum type, and it takes the price as its single parameter. Review the links and details in the [Background](#background) section if this confuses you.

- `public double getPrice()`. This method is just a simple getter method for the price. `price` is `final` and has no setter because it does not make sense for an object's price to change at runtime.

- `public String toString()`. This method returns a `String` representation of a `VendingItem` for use in your simulation. The `String` should look like: "(name): $xx.xx" where *(name)* is the name of the `VendingItem` and *xx.xx* is its price.

### VendingMachine.java

This class represents the vending machine itself and is the bulk of the assignment. It has the following fields, methods, and constructors:

- `private static double totalSales`. Your boss wants a way to measure the success of this venture, so this field will keep track of the total sales across vending machines. It should be initialized to 0 and properly updated every time a sale *that makes money* is made. More on this later.

- `private VendingItem[][][] grid`. This 3D array of `VendingItem`s represents how the items are arranged in the vending machine. `grid[i][j][k]` represents the `VendingItem` located in the *ith* row, *jth* column, and *kth* position where position 0 (`grid[i][j][0]`) is the item at the front of the "stack" and each subsequent position represents the item *behind* it. The grid should be initialized to have 6 rows, 3 columns, and 5 positions per location.

- `private int freeChance`. To give Tech students an incentive to use the machines, you have incorpoated the chance to win a free item into the machine. This field represents the percent chance that a user has to win on the current `vend()` and should be initialized to 0. More details below.

- `private Random rand`. This is an instance of the [Random](#random) class you will be using to generate the random numbers needed in this implementation.

- `public VendingMachine()`. This is the single no-arg constructor for `VendingMachine`s. You should initialize your fields and call `restock()` here so that your vending machine is ready to use as soon as someone initializes it.

- `public VendingItem vend(String code)`. This method is used to dispense an item from the vending machine. It takes in a parameter `code` representing the user's input. This code will be formatted as a letter followed by a number (A6), which represents the the row and column of the selected item. The rows start with the letter A and the columns start with the number 1, so grid[0][0] would correspond to A1 and so on. You must dispense the item from the proper row and column and move the items behind it so that there is always (if possible) an item in the 0 position. This method should also take care of checking the `code` for validity before dispensing anything and should print an error statement and return `null` if something goes wrong. It should also print an error statement and return `null` if there is no item in the position that the user selected. If it is determined by the `free()` method that the item being dispensed is free for the user, this method should print a statement notifying the user as such. Finally, this method should  update the `totalSales` field as needed. Be careful not to update `totalSales` if the item was free or if something went wrong.

- `private boolean free()`. This private helper method should be used in conjuntion with `vend()` to determine if the current user should recieve their item for free. This method should have a percent chance equal to `freeChance` of returning `true` (use `rand`). If the method returns true, `freeChance` should be reset to 0. However, if the method returns false, `freeChance` should be incremented by 1, giving the next user a 1% higher probability of winning a free item.

- `public void restock()`. This method should fill each spot in the vending machine with a randomly chosen item every time it is called. **HINT:** Make use of `rand` and the `values()` method of `Enum` to achieve this functionality. More info [here.](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)

- `public static double getTotalSales()`. This method is a getter for the `totalSales` field. It is `static` because `totalSales` is a `static` variable and keeps track of sales across all vending machines.

- `public int getNumberOfItems()`. This method should return the total number of `VendingItem`s in the vending machine. **NOTE:** Although the method is named `get...()`, it is not a getter method and requires some logic.

- `public double getTotalValue()`. This method should return the combined total value of all the `VendingItem`s in the vending machine. **NOTE:** Although the method is named `get...()`, it is not a getter method and requires some logic.

- `public String toString()`. To make it easier, this method has been provided for you below and returns a `String` representation of the `VendingMachine` for use in your simulation.

```
public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("----------------------------------------------------------"
        + "------------\n");
    s.append("                            VendaTron 9000                "
        + "            \n");
    for (int i = 0; i < grid.length; i++) {
        s.append("------------------------------------------------------"
            + "----------------\n");
        for (int j = 0; j < grid[0].length; j++) {
            VendingItem item = grid[i][j][0];
            String str = String.format("| %-20s ",
                (item == null ? "(empty)" : item.name()));
            s.append(str);
        }
        s.append("|\n");
    }
    s.append("----------------------------------------------------------"
        + "------------\n");
    s.append(String.format("There are %d items with a total "
        + "value of $%.2f.%n", getNumberOfItems(), getTotalValue()));
    s.append(String.format("Total sales across vending machines "
        + "is now: $%.2f.%n", getTotalSales()));
    return s.toString();
}
```

## Running and Testing

`Driver.java` has been provided for you. It creates several instances of `VendingMachine`, and allows the user to interact with them. You can run the `main` method to start a simulation, and test from there. The tester may not cover all cases, so be sure to write your own code to test your simulation.

## Javadocs

- Starting from this homework, you will need to write Javadoc comments along with checkstyling your submission.

    - Every class should have a class level Javadoc that includes `@author <GT Username>`.

    - Every method should have a Javadoc explaining what the method does and includes any of the following tags if applicable.

        - `@param <parameter name> <brief description of parameter>`

        - `@returns <brief description of what is returned>`

        - `@throws <Exception> <brief explanation of when the given exception is thrown>`

- See the [CS 1331 Style Guide](http://cs1331.gatech.edu/cs1331-style-guide.html) section on Javadoc comments for examples as well as the provided `Driver.java` file.

## Checkstyle

As mentioned in the previous homework, you will be running a style checking program on your code. For each violation the tool finds, you will lose one point on your total grade for this assignment.

To make things easier for you in the beginning of the semester, the first few homeworks will have a checkstyle cap, or a maximum amount of points that can be lost to checkstyle. For *this homework*, the **checkstyle cap is 25**, meaning you can lose up to **25** points on this assignment due to style errors. As the semester goes on, this cap will increase with each homework and eventually go away. **Run checkstyle early, and get in the habit of writing style compliant code the first time**. Don't wait until 5 minutes before the deadline to find out that you have 100+ violations.

- If you encounter trouble running checkstyle, check Piazza for a solution and/or ask a TA as soon as you can!

- You can run checkstyle on your code by using the jar file found [on the course website](http://cs1331.gatech.edu/cs1331-style-guide.html) and the included xml file like so: `java -jar checkstyle-6.2.2.jar *.java`.

- To check for proper Javadocs you can run the following command: `java -jar checkstyle-6.2.2.jar -j *.java`.

- **Note that the above is different from the normal method for running checkstyle.** This command will only check for Javadoc errors so *you will have to run both commands to fully test for style errors*.

- Javadoc errors are the same as checkstyle errors, as in each one is worth a single point and they are counted towards the checkstyle cap.

- ** You will be responsible for running checkstyle on *ALL* of your code. **

- Depending on your editor, you might be able to change some settings to make it easier to write style-compliant code. See [the customization tips page](http://cs1331.gatech.edu/customization-tips.html) (at the bottom) for more information.

## Hints and Tips

As part of your extensive training, you have been given the secret formula ~~for Coke~~ for success at CS 1331. If you've read this far, you're well on your way. If anything seems confusing, read through the entire description and instructions again. As always, feel free to contact your TAs, post on Piazza, or come in for office hours. In addition, here are some tips specific to this homework:

- You can assume input will be of the correct type (i.e, we will not break your code by giving you a `String` instead of an `int`), but not necessarily the correct values (i.e, if you ask for an `int` between 1 and 5 we might enter 9). Your code should handle these cases gracefully.

- Remember that `char` is actually a numeric primitive type. That means you can mix arithmetic involving `char`s and `int`s. For example:

```
int i = 'a' - 32;
System.out.println(i);
System.out.println((char) i);

// ...outputs...
65
A
```

This [ascii table](https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html) gives you the numeric values corresponding to each `char`. You can use this to very easily convert between user input and array indices for the vending machine.

## Collaboration

When completing homeworks for CS1331 you may talk with other students about:

- What general strategies or algorithms you used to solve problems in the homeworks
- Parts of the homework you are unsure of and need more explanation
- Online resources that helped you find a solution
- Key course concepts and Java language features used in your solution

You may **not** discuss, show, or share by other means the specifics of your code, including screenshots, file sharing, or showing someone else the code on your computer, or use code shared by others.

Examples of approved/disapproved collaboration:

- **approved**: "Hey, I'm really confused on how we are supposed to implement this part of the homework. What strategies/resources did you use to solve it?"
- **disapproved**: "Yo it's 10:40 on Thursday... Can I see your code? I won't copy it directly I promise"

In addition to the above rules, note that it is not allowed to upload your code to any sort of public repository. This could be considered an Honor Code violation, even if it is after the homework is due.

## Submitting

You should not import any libraries or packages that trivialize the assignment. This includes data structures other than arrays (so no `List`, `Map`, `Set`, etc). If you are unsure of whether something is allowed, ask on Piazza. In general, if something does a large part of the assignment for you, it is probably not allowed. **Important:** `java.util.Arrays` is not allowed. However, that is different from a Java array (e.g `int[] nums = new int[10]`), which is necessary for this assignment.

- The submission tool is included with the HW files. Run it by typing `java -jar hw2-submit.jar`. You can submit as many times as you want so feel free to submit as you make substantial progress on the homework.

- As always, late submissions will not be accepted and non-compiling code will be given a score of 0. For this reason, we recommend submitting early and then confirming that you submitted *ALL* of the necessary files by navigating to the link that the submission tool gives you.
