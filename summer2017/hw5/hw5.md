# CS1331 Homework 5 - Collections

[HW5 Files](hw5.zip)

## Introduction

This assignment will involve Collections, generics, iterators, and the Comparable interface.

## Description

Winter is here. The Long Night has arrived. The cold winds blow from the north. Westeros is faced with the impending invasion of the sinister White Walkers. You are trying to build a team to take north of the Wall in order to fight them. However, in order to save Westeros, you have to know about Collections. After all, how can you keep track of your team without Collections?

This assignment will have you implement a generic `ComparableCollection` that can only take in Comparable objects. We have provided a generic interface `CollectionInterface` that contains the methods you must implement in your `ComparableCollection`. It is your job to build a concrete implementation that allows for your `ComparableCollection` to only handle objects that are Comparable. Additionally, your `ComparableCollection` must be `Iterable`. You will then have to implement a `TeamWrapper` class. This will use your `ComparableCollection` to allow you to build your team and manipulate it. You will also have to implement a `Character` class that represents the people you might add to your team. `Character` must be `Comparable`.

## Provided Files and Solution Description

You will have to modify the files `Character.java`, `ComparableCollection.java`, and `TeamWrapper.java`.

### CollectionInterface.java

**DO NOT MODIFY THIS FILE.** This interface contains the following methods. Refer to the javadocs for a more detailed description of each method.

- `void add(T elem)`
- `void addAll(T[] elems)`
- `boolean remove(T elem)`
- `boolean removeAll(T[] elem)`
- `boolean contains(T elem)`
- `T get(int index)`
- `int size()`
- `int capacity()`
- `void clear()`
- `boolean isEmpty()`
- `String toString()`

### ComparableCollection.java

- **YOU MAY NOT USE ARRAYLIST IN THIS CLASS.**
- Implements `CollectionInterface` and `Iterable`.
- Your collection must be backed by an array. This array should be a private instance field.
- You will also have to use generics to modify the class header in order to allow the Collection to only take in objects that are Comparable. Your `ComparableCollection` **MUST BE GENERIC**. Do not have it only accept Characters.
- You do not need to implement the remove method when creating your iterator.

### Character.java

A class representing the people you will attempt to recruit. This class **MUST BE COMPARABLE**. Characters can only be compared to other Characters. Characters should be compared by the sum of `combatSkill` and `intelligenceLevel`. `Character` has the following instance fields:

-	`private String name`: name of person
-	`private int combatSkill`: combat ability of person
-	`private int intelligenceLevel`: intelligence level of person
-	`private boolean hasSpecialPower`: boolean representing whether character has unusual powers
-	`private int numDragons`: int representing the number of dragons that character has
-	`private String message`: a message that will appear when you find the character

You only need to implement one constructor that takes in and sets all the instance fields. You will need to implement getters and setters for all of the instance fields. In addition to getters and setters, you must implement the following:

-	`public String toString()`: A method header for your toString method is provided. You must fill out the body. Details are in the javadocs inside the Character class.
-	Properly overridden `equals` method. Two Characters are equal if their `name`s are equal.

### TeamWrapper.java

This is a Wrapper that will be used to build your team. You will have a main team and a reserve team. This class has two private instance fields that have been provided. They have been instantiated for you in a constructor. One is a `ComparableCollection` that represents your main team. You will also have a reserve team represented by another `ComparableCollection`. Your main team is what you will bring to the fight, and your reserve team has your backup fighters if any of your main team die prematurely, which knowing George R.R. Martin is a real possibility. Your main team can have no more than 10 fighters, and your reserve can have no more than 5. You should be able to move fighters from your reserve to your main team and vice versa. You will have to implement the following methods.

-	`public boolean checkTeamCapacity()`: returns true if there is space left on your main team
-	`public boolean checkReserveCapacity()`: returns true if there is space left on your reserve team
-	`public void addToTeam(Character c)`: adds a Character that is passed in to the team
-	`public void addToReserve(Character c)`: adds a Character that is passed in to the reserve team
-	`public boolean removeFromTeam(Character c)`: attempts to remove a Character that is passed in from the team. Returns true if successful, false otherwise.
-	`public boolean removeFromReserve(Character c)`: attempts to remove a Character that is passed in from the reserve team. Returns true if successful, false otherwise.
-	`public boolean moveToReserve(Character c)`: removes a Character that is passed in from the team, and adds it to the reserve if it was sucessfully removed
-	`public boolean promoteToTeam(Character c)`: removes a Character that is passed in from the reserve team, and adds it to the team if it was successfully removed
-	`public int teamSize()`: return the number of members currently on your team
-	`public int reserveSize()`: return the number of members currently on your reserve
-	`public Character getFromTeam(int index)`: returns the Character at a specified index on your team
-	`public Character getFromReserve(int index)`: returns the Character at a specified index on your reserve team

See the provided javadocs for more details on these methods.

>Note: You should not be able to add the same Character to both your team and reserve team.

The following methods are provided, **DO NOT MODIFY THEM**.

-	`public String teamToString()`
-	`public String reserveToString()`

### BuildTeam.java

**DO NOT MODIFY THIS.** This will take you through a simulation of traveling Westeros looking for Characters to add to your team. Simply follow the on screen instructions. If your `TestWrapper.java` is working as it should, `BuildTeam.java` should run smoothly.


## Tips

-	If you’re having trouble with generics, try implementing the collection methods without generics just to make sure your logic is sound, then add generics.
-	You can create arrays of Comparable type.
-	A size instance field can be useful when implementing your collection.
-	You cannot convert from an Object array to a Comparable array.
-	You can call methods you have written from other methods when implementing your collection.
-	All of the methods in `TeamWrapper` should be very simple if you use your collections properly.
-	If you can't get your `ComparableCollection` to work, you can use the `ArrayList` (provided in the Java util package) in `TeamWrapper` instead and still get the points for `TeamWrapper`.

## Compiling and Testing Your Code
You should not use any methods, libraries or packages that trivialize the assignment. If you are unsure of whether something is allowed, ask on Piazza. In general, if something does a large part of the assignment for you, it is probably not allowed. **Important:** `java.util.Arrays` is not allowed. However, that is different from a Java array (e.g `int[] nums = new int[10]`), which is necessary for this assignment.

To compile your code simply run `javac *.java` from the directory in which your files are located. We have provided a file called `BuildTeam.java`. **DO NOT MODIFY THIS.** If your `TestWrapper` class functions as it should, running java `BuildTeam` will take you through a simulation of Westeros where you travel and attempt to build your team. Follow the on screen instructions when you run it. Keep in mind that even it runs properly, this **DOES NOT GUARANTEE** that your code is 100% correct. The following is a list, not exhaustive, of things you need to make sure you've done.

-	`ComparableCollection` is `Iterable` (hint, if you can run a for each loop on your `ComparableCollection` you have done this properly)
-	`ComparableCollection` can only take in objects of `Comparable` type
-	Make sure all your `ComparableCollection` methods work properly.

Refer to the method descriptions to make sure that you have implemented all then necessary functionality.

## Javadocs

- You will need to write Javadoc comments along with checkstyling your submission. Some javadocs have already been provided for you. You also do not need to worry about writing javadocs for BuildTeam.java. However, you will need to modify the javadoc for the ComparableCollection class after modifying the class header appropriately.

    - Every class should have a class level Javadoc that includes `@author <GT Username>` and `@version <version #>`.

    - Every method should have a Javadoc explaining what the method does and includes any of the following tags if applicable.

        - `@param <parameter name> <brief description of parameter>`

        - `@returns <brief description of what is returned>`

        - `@throws <Exception> <brief explanation of when the given exception is thrown>`

- See the [CS 1331 Style Guide](http://cs1331.gatech.edu/cs1331-style-guide.html) section on Javadoc comments for examples.

## Checkstyle

You must run checkstyle on your submission. The checkstyle cap for this submission is **70** points. **YOU DO NOT NEED TO RUN CHECKSTYLE ON `BuildTeam.java`**. Simply move the file to another directory and run checkstyle on the files that you had to modify.

A guide for setting up and running checkstyle can be found on [this page on the course website](http://cs1331.gatech.edu/cs1331-style-guide.html). Make sure you click "Save" when downloading the jar file, and not "Run". It is useful to copy the jar file to your homework directory or set up an alias for it. **Run checkstyle for this assignment with `java -jar checkstyle-6.2.2.jar -a *.java`. This will check for both checkstyle errors and javadoc errors.**

Collaboration with other students
When completing homeworks for CS1331 you may talk with other students about:

- what general strategies or algorithms you used to solve problems in the homeworks
- parts of the homework you are unsure of and need more explanation
- online resources that helped you find a solution
- Key course concepts and Java language features used in your solution

You may **not** discuss, show, or share by other means the specifics of your code, including screenshots, file sharing, or showing someone else the code on your computer, or use code shared by others.

Examples of approved/disapproved collaboration:

- **approved**: "Hey, I`m really confused on how we are supposed to implement this part of the homework. What strategies/resources did you use to solve it?"
- **disapproved**: "Yo it`s 10:40 on Thursday... can I see your code? I won`t copy it directly I promise"

Collaborating with others in a way that violates the approved means is a Georgia Tech Honor Code violation.

## Turn-in Procedure

**YOUR SUBMISSION SHOULD ONLY CONTAIN .JAVA FILES!**

Compress the Hw5 files into a .zip file and submit that on T-square. Make sure the zip file contains `CollectionInterface.java`, `ComparableCollection.java`, `Character.java`, `TeamWrapper.java`, and `BuildTeam.java`. **Do NOT submit your .class files.**

## Verify the Success of Your Submission to T-Square

Practice safe submission! Verify that your HW files were truly submitted correctly, the upload was successful, and that your program runs with no syntax or runtime errors. It is solely your responsibility to turn in your homework and practice this safe submission safeguard.

- After uploading the files to T-Square you should receive an email from T-Square listing the names of the files that were uploaded and received. If you do not get the confirmation email almost immediately, something is wrong with your HW submission and/or your email. Even receiving the email does not guarantee that you turned in exactly what you intended.
- After submitting the files to T-Square, return to the Assignment menu option and this homework. It should show the submitted files.
- Download copies of your submitted files from the T-Square Assignment page placing them in a new folder.
- Re-run and test the files you downloaded from T-Square to make sure it`s what you expect.
- This procedure helps guard against a few things.

    - It helps ensure that you turn in the correct files.
    - It helps you realize if you omit a file or files. Missing files will not be given any credit, and non-compiling/non-running homework solutions will receive few to zero points. Also recall that late homework will not be accepted regardless of excuse. Treat the due date with respect.  Do not wait until the last minute!
(If you do discover that you omitted a file, submit all of your files again, not just the missing one.)
    - Helps find syntax errors or runtime errors that you may have added after you last tested your code.





