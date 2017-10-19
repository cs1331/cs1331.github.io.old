---
layout: homework
title: Homework 3 - Exceptions
---

# Homework 3 - Exceptions

## Introduction

In this assignment you will practice

- writing exceptions,
- using exceptions, and
- simple code testing.

## Problem Description

You need to to add invalid square checking to your square class and ensure that it works properly before continuing to rewrite your PGN reader.

## Solution Description

Write the following classes and enums:

- Write an exception named `InvalidSquareException`. The message returned by `getMessage` should be the square that's invalid, e.g. `a9` or `i1` -- a square that doesn't exist on the chess board.

  - Decide whether your `InvalidSquareException` should be a checked or unchecked exception and implement it appropriately.
  - In the JavaDoc comment for your `InvalidSquare` class write a sentence or two justifying your choice of checked or unchecked exception.

- Modify your `Square` class from HW2 to make the following changes:

  - The constructors should should throw an `InvalidSquare` exception if the file is not in the range [`'a'`, `'h'`] or the rank is not in the range [`'1'`, `'8'`].
  - Add public getter methods for the file and rank fields

For each class include Javadoc comments as described in the [CS 1331 style guide](../../cs1331-style-guide.html).

We will test your classes with code similar to the following (assume `fail(String)` and `assertEquals(boolean)` are implemented appropriately). You should too.

```Java
try {
    new Square("a1");
} catch (InvalidSquareException e) {
    fail("InvalidSquareexception for valid square: " + e.getMessage());
}
try {
    String invalidSquare = "a9";
    new Square(invalidSquare);
    fail("No InvalidSquareexception for invalid square: " + invalidSquare);
} catch (InvalidSquareException e) {
    // Success
}
Square s = new Square("f7");
assertEquals('f', s.getFile());
assertEquals('7', s.getRank());
Square s2 = new Square('e', '4');
assertEquals("e4", s2.toString());
```

## Grading

- 10 points: `InvalidSquareException` *is-a* appropriate `Throwable`
- 10 points:  Justification for `InvalidSquareException` beign checked or unchecked
- 10 points: `Square` throws `InvalidSquareException` for square with invalid file
- 10 points: `Square` throws `InvalidSquareException` for square with invalid rank
- 10 points: `Square` does not throw `InvalidSquareException` for square with valid file
- 10 points: `Square` does not throw `InvalidSquareException` for square with valid rank
- 5 points `Square` getter for file has correct visibility
- 5 points `Square` getter for file has correct return type
- 5 points `Square` getter for file has correct name
- 5 points `Square` getter for file has correct parameter list
- 5 points `Square` getter for rank has correct visibility
- 5 points `Square` getter for rank has correct return type
- 5 points `Square` getter for rank has correct name
- 5 points `Square` getter for rank has correct parameter list

Checkstyle deduction will be capped at 30 points for this homework.

## Turn-in Procedure

Submit each of your Java source files on T-Square as separate attachments.  When you're ready, double-check that you have submitted and not just saved a draft.

## Verify the Success of Your Submission to T-Square

Practice safe submission! Verify that your HW files were truly submitted correctly, the upload was successful, and that your program runs with no syntax or runtime errors. It is solely your responsibility to turn in your homework and practice this safe submission safeguard.

- After uploading the files to T-Square you should receive an email from T-Square listing the names of the files that were uploaded and received. If you do not get the confirmation email almost immediately, something is wrong with your HW submission and/or your email. Even receiving the email does not guarantee that you turned in exactly what you intended.
- After submitting the files to T-Square, return to the Assignment menu option and this homework. It should show the submitted files.
- Download copies of your submitted files from the T-Square Assignment page placing them in a new folder.
- Re-run and test the files you downloaded from T-Square to make sure it's what you expect.
- This procedure helps guard against a few things.

    - It helps insure that you turn in the correct files.
    - It helps you realize if you omit a file or files. Missing files will not be given any credit, and non-compiling/non-running homework solutions will receive few to zero points. Also recall that late homework will not be accepted regardless of excuse. Treat the due date with respect.  Do not wait until the last minute!
(If you do discover that you omitted a file, submit all of your files again, not just the missing one.)
    - Helps find syntax errors or runtime errors that you may have added after you last tested your code.
