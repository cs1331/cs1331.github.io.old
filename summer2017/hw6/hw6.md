---
layout: homework
title: Homework 6
---

# CS1331 Homework 6 - EXTRA CREDIT - Exceptions

[HW6 Files](hw6.zip)

## Introduction

### This is an extra credit homework worth up to 30 points. The points you earn will be added to your Homework 3 grade. This assignment is *optional* and you will NOT be penalized for not completing it. It is due Sunday, July 2 at 11:55 pm and late submissions will NOT be accepted.

This assignment will involve Exceptions.

## Description

You are charged with helping a restaurant implement electronic ordering. You have access to a food database, as represented by the file `Food.txt`. You also have access to a drink database, as represented by the file `Drink.txt`. You will prompt the customer to enter their food item, and then their drink item. If the user enters a food item that does not exist, but their drink exists, you must generate a `FoodNotFoundException`, a custom exception that you will build. If the user enters a drink item that does not exist, but their food exists, you must generate a custom `DrinkNotFoundException`. If both their food and drink selections do not exist, you must generate a custom `FoodAndDrinkNotFoundException`. All of your exceptions must be **CHECKED EXCEPTIONS**. If the user generates any of these exceptions, your program should not crash, but rather it should ask them again to enter their food and drink selections.


## Provided Files and Solution Description

You will have to create the files `Restaurant.java`, `FoodNotFoundException.java`, `DrinkNotFoundException.java`, and `FoodAndDrinkNotFoundException.java`.

### Restaurant.java

This class contains the following methods.

- `public static void main(String args[])`: prompts the customer to enter their food selection and their drink selection, then calls `checkOrder`, passing in the food, drink, and the file names. The file names must be entered as command line arguments. **DO NOT** hard code the file names or prompt the user to enter them.
	- If any of your custom exceptions are generated, catch them and print out the error messages, then prompt the customer to enter their food and drink again.
	- Any other exceptions should be handled (i.e. `FileNotFoundException`), but do not prompt the customer to enter their food or drink again.
- `public static void checkOrder(String food, String drink, String foodfile, String drinkFile)`: calls checkFood and checkDrink.
	- If `checkFood` and `checkDrink` return false, throw a `FoodAndDrinkNotFoundException` with the message "Our food menu doesn't have `food` and our drink menu doesn't have `drink`!"
	- If only `checkFood` returns false, throw a `FoodNotFoundException` with the message "Our food menu doesn't have `food`!"
	- If only `checkDrink` returns false, throw a `DrinkNotFoundException` with the message "Our drink menu doesn't have `drink`!"
	- If both `checkFood` and `checkDrink` return true, simply print out "Order successful!" and the program should end.
	- **DO NOT** handle any exceptions in this method, only declare them as thrown.
- `public static boolean checkFood(String food, String foodFile)`: reads through the file with name provided by the parameter `foodfile` and determine if the food parameter that was passed in exists in the file. If it does, return true. If not, return false. **DO NOT** handle `FileNotFoundException` in this method, only declare it as thrown.
- `public static boolean checkDrink(String drink, String drinkFile)`: reads through the file with the name provided by the parameter `drinkFile`, and determines if the drink parameter that was passed in exists in the file. If it does, return true. If not, return false. **DO NOT** handle `FileNotFoundException` in this method, only declare it as thrown.

### FoodNotFoundException.java, DrinkNotFoundException.java, FoodAndDrinkNotFoundException.java

These are **CHECKED** exceptions. For each Exception, implement a one argument constructor that takes in an error message as a String and properly sets the message. Hint: When the `getMessage` method is called on any of these exceptions it should return the error message.

### Food.txt, Drinks.txt

These files have been provided for you. They contain foods and drinks that the restaurant offers. The format will be as follows, where each line contains a separate item:

fajita  
burrito  
quesadilla


## Tips

- Each of your custom Exception classes can be completed in under 10 lines.
- You are allowed to use ArrayLists for this homework.


## Compiling and Testing Your Code

To compile your code simply run `javac *.java` from the directory in which your java and text files are located. Run `java Restaurant Food.txt Drinks.txt` in order to test your code. You can look through the text files to see which foods and drinks exist. Try entering various combinations of correct and incorrect foods and drinks, and see if the appropriate error messages print out.

## Javadocs

- You will need to write Javadoc comments along with checkstyling your submission. Some javadocs have already been provided for you. You also do not need to worry about writing javadocs for BuildTeam.java. However, you will need to modify the javadoc for the ComparableCollection class after modifying the class header appropriately.

    - Every class should have a class level Javadoc that includes `@author <GT Username>` and `@version <version #>`.

    - Every method should have a Javadoc explaining what the method does and includes any of the following tags if applicable.

        - `@param <parameter name> <brief description of parameter>`

        - `@returns <brief description of what is returned>`

        - `@throws <Exception> <brief explanation of when the given exception is thrown>`

- See the [CS 1331 Style Guide](http://cs1331.gatech.edu/cs1331-style-guide.html) section on Javadoc comments for examples.

## Checkstyle

You must run checkstyle on your submission. The checkstyle cap for this submission is **30** points.

**Run checkstyle for this assignment with `java -jar checkstyle-6.2.2.jar -a *.java`. This will check for both checkstyle errors and javadoc errors.**

## Collaboration with other students
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

Compress the hw6 files into a .zip file and submit that on T-square. Make sure the zip file contains `Restaurant.java`, `FoodNotFoundException.java`, `DrinkNotFoundException.java`, and `FoodAndDrinkNotFoundException.java`. **Do NOT submit your .class files.**

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





