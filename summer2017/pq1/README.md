# CS 1331 Programming Quiz 1 - Pie Shop

### June 8, 2017

## Problem description
You just opened a pie shop and you're looking to increase the amount of customers served, so you decide to write a PieShop program that will allow customers to place their order at computers in your shop.

You have been provided with a few files [here](PQ1.zip) that are incomplete. Let's review them:

### Pie.java
- `private String flavor`: variable, represents the flavor of pie.
- `private boolean isSlice`: variable, true if it is one slice of pie, false if it is a whole pie.
- `public Pie(String flavor, boolean isSlice)`: constructor for Pie, should take in a String and a boolean to set the instance data.
- `public double price()`: method, should return the price of the pie. All slices should be $2.50. A whole "Banana cream" flavor pie should be $14.00, a whole "Pumpkin" flavor pie should be $11.00, a whole "Apple" flavor pie should be $13.50, and all other whole pies should be $12.25.

- `public String toString()`: method, is provided for you, do NOT edit this method.

### PieShop.java
- `private static Pie[] cart`: variable, represents all the pies that the customer wants to buy. Starting size should be 3.
- `private static int numPies`: variable, represents the number of pies in the cart, should start at 0.
- `public static void addToCart(Pie p)`: method, should add the Pie to the cart. If the cart is not large enough it should be resized (length should be doubled) and then the pie should be added. Hint: remember you have a variable to keep track of the number of pies in the cart.
- `public static double sum()`: method, should return the total price of all pies in the cart.

- The rest of the file is provided for you, you should NOT edit any other method. You may use the main method to test your code, simply run `java PieShop` after compilation.


### **Points will not be taken off for checkstyle and you do not need to write javadocs for your code.**

## Clarifications
You should not import any libraries or packages that trivialize the assignment. This includes data structures other than arrays (so no `ArrayList`, `List`, `Map`, `Set`, etc). If you are unsure of whether something is allowed, raise your hand and ask a TA. In general, if something does a large part of the assignment for you, it is probably not allowed. **Important:** `java.util.Arrays` is not allowed. However, that is different from a Java array (e.g `int[] nums = new int[10]`), which is necessary for this assignment.

The only websites we should see you using are the class site (cs1331.gatech.edu), T-Square (https://t-square.gatech.edu), and the Oracle Java API (https://docs.oracle.com/javase/8/docs/api/).

## Compiling and Testing your code
Compile your code from the `PQ1` directory with the command `javac *.java`. Test your code with the command `java PieShop`.

## Turn-in Procedure

Submit your `Pie.java` and `PieShop.java` files on T-Square as attachments.  When you're ready, double-check that you have submitted and not just saved a draft.

## Verify the Success of Your Submission to T-Square

Practice safe submission! Verify that your HW files were truly submitted correctly, the upload was successful, and that your program runs with no syntax or runtime errors. It is solely your responsibility to turn in your homework and practice this safe submission safeguard.

- After uploading the files to T-Square you should receive an email from T-Square listing the names of the files that were uploaded and received. If you do not get the confirmation email almost immediately, something is wrong with your HW submission and/or your email. Even receiving the email does not guarantee that you turned in exactly what you intended.
- After submitting the files to T-Square, return to the Assignment menu option and this homework. It should show the submitted files.
- Download copies of your submitted files from the T-Square Assignment page placing them in a new folder.
- Re-run and test the files you downloaded from T-Square to make sure it's what you expect.
- This procedure helps guard against a few things.

    - It helps insure that you turn in the correct files.
    - It helps you realize if you omit a file or files. Missing files will not be given any credit, and non-compiling/non-running solutions will receive few to zero points. Also recall that late quizzes will not be accepted regardless of excuse.
(If you do discover that you omitted a file, submit all of your files again, not just the missing one.)
    - Helps find syntax errors or runtime errors that you may have added after you last tested your code.


