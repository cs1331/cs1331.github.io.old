---
layout: homework
title: Homework 1
---

# CS1331 Homework 01 - Grade Histogram

Welcome to your first full-fledged programming assignment for CS1331! In this homework, you will be tasked with reading data files and using what you've learned so far to create a visualization of the data in your terminal.

## Introduction

This assignment will have you working with 1-D arrays, console/file IO,
and command-line args.

## Problem Description

You are a Georgia Tech professor teaching a class. It is the end of the
semester and you wish to see how your students performed, so you write a
Java program that will create a histogram of the grade distribution. You
want this histogram program to be able to give you a very detailed view
or a very broad view of the grade distribution. To accomplish this, it
asks the user how many bins the grades should be split into.

## Solution Description

Put your code in a file named `GradeHistogram.java`.

We have provided you with a [sample CSV](grades.csv) file that has a list of students
and their grades with which you may test your code. A CSV file is just a
text file with data partitioned by commas and (in this case) newlines.

These grades are not sorted but they are bound between 0 and 100
(inclusive). For example, the file may look like:

    Glenn, 91
    Chris,     100
    Thomas,  89
    Bob, 55
    Alice, 95
    Eve,     87

> **Note:** There may be extra whitespace around the grade. Your program must account for this.

The name of the file containing the grades must be passed in via a
command-line argument - see the example below for how to pass the file
name in while running the program.

Using an array, you must count the frequency of each grade value in the
file and print it to the standard output as a horizontal histogram. For
every grade in a particular range, print a pair of brackets.

**You may only read through the file once**.

You must also label the range of each histogram bar and allow the user
to indicate what size interval they would like the histogram to be made
with. You must allow the user to specify this size interval in one of
two ways:

1.  Firstly, the size interval may be specified as an additional command
    line arg, e.g `java GradeHistogram grades.csv 5`

2.  If the second command line arg is not present, your program must ask
    the user for the bucket size.

Running the program should look like this:

> **Note:** `$` is the command prompt on Unix. On Windows it
> will look like `C:\`

    $ java GradeHistogram grades.csv
    Grades loaded!
    What bucket size would you like?
    >>> 10
    
    100 - 91 | [][][][][][][][][][][][]
     90 - 81 | [][][][][][][][][][][][][][][][][][][][][][][][][][]
     80 - 71 | [][][][][][][][][][][][][][]
     70 - 61 | [][][][][][][][][][][][][][][][][]
     60 - 51 | [][][][][][][]
     50 - 41 | [][][][]
     40 - 31 | [][][][][][]
     30 - 21 | [][]
     20 - 11 | 
     10 -  1 | []
      0 -  0 | []
    
    $ java GradeHistogram grades.csv 5
    Grades loaded!
    
    100 - 96 | [][][][][][]
     95 - 91 | [][][][][][]
     90 - 86 | [][][][][][][][][][][][][][][][][]
     85 - 81 | [][][][][][][][][]
     80 - 76 | [][][][][][][][][][][][]
     75 - 71 | [][]
     70 - 66 | [][][][][][][][][][]
     65 - 61 | [][][][][][][]
     60 - 56 | [][][][][]
     55 - 51 | [][]
     50 - 46 | [][][]
     45 - 41 | []
     40 - 36 | [][][]
     35 - 31 | [][][]
     30 - 26 | []
     25 - 21 | []
     20 - 16 | 
     15 - 11 | 
     10 -  6 | []
      5 -  1 | 
      0 -  0 | []

> **Note:** The pipe characters should be aligned and your program must
> not exclude any subrange between 0 and 100.

## Tips

-   You may assume that you always get valid input.

-   You may assume the text file has valid numbers.

-   101 is a prime number.

-   An array is a fixed size data structure; you need to know ahead of
    time how big it needs to be. How do we do this?

-   Creating a `Scanner` object with a file will throw a
    checked exception. Don’t worry about what this means — for now, just
    append `throws Exception` to the end of the
    `main` method signature wherein the file is opened.

## Checkstyle
You must run checkstyle on your submission. The checkstyle cap for this submission is 0 points. In future homeworks we will be increasing this cap, so get into the habit of fixing these style errors early!

A guide for setting up and running checkstyle can be found on [this page on the course website](http://cs1331.gatech.edu/cs1331-style-guide.html). Make sure you click "Save" when downloading the jar file, and not "Run". It is useful to copy the jar file to your homework directory or set up an alias for it. Run checkstyle for this assignment with `java -jar checkstyle-6.2.2.jar GradeHistogram.java`.


## Collaboration with other students
When completing homeworks for CS1331 you may talk with other students about:

- what general strategies or algorithms you used to solve problems in the homeworks
- parts of the homework you are unsure of and need more explanation
- online resources that helped you find a solution
- Key course concepts and Java language features used in your solution

You may **not** discuss, show, or share by other means the specifics of your code, including screenshots, file sharing, or showing someone else the code on your computer, or use code shared by others.

Examples of approved/disapproved collaboration:

- **approved**: "Hey, I'm really confused on how we are supposed to implement this part of the homework. What strategies/resources did you use to solve it?"
- **disapproved**: "Yo it's 10:40 on Thursday... can I see your code? I won't copy it directly I promise"

Collaborating with others in a way that violates the approved means is a Georgia Tech Honor Code violation, and you will also break your TAs hearts :broken_heart:

## Turn-in Procedure

Submit your `GradeHistogram.java` file on T-Square as an attachment.  When you're ready, double-check that you have submitted and not just saved a draft.

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




