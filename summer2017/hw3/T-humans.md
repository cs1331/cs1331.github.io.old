---
layout: homework
title: Homework 3
---

# CS1331 Homework 03 - T-humans

## Introduction

This homework will cover basic inheritance.

## Problem Description

Georgia Tech is coming out with a new T-square called T-humans just for keeping track of the humans here at Tech. You will be responsible for implementing and organizing multiple classes in a coherent manner. You will need to familiarize yourself with super/subclasses and constructor chaining.

You will need to create and organize `Person.java`, `Student.java`, `Undergrad.java`, `Grad.java`, `Professor.java`,  and `University.java`. Person should be at the top of the hierarchy with Professor and Student as direct subclasses. Student then has Undergrad and Grad as subclasses.

## Solution Description

### The Person Class
This class has the following instance variables:

- `private String name`: name of person
- `private int age`: age of person
- `private String homeTown`: hometown of person

This class has the following methods:

- `public String getName()`: returns name
- `public int getAge()`: returns age
- `public String getHometown()`: returns homeTown
- `public String toString()`: returns a string with following format:
   - `name` is `age` years old from `homeTown`
- properly overridden equals method that checks `name`, `age`, and `hometown`.

The constructors for this class should be able to accept one, two, or all three arguments (instance variable values).

- The name must be provided to the constructor when making a new Person but the other arguments are optional with "default" values as follows:
  - Pass in one argument(`name`): defaults age to 18 and homeTown to "Atlanta"
  - Pass in two arguments(`name` and `age`): defaults homeTown to "Atlanta"
  - Pass in three arguments(`name`, `age`, and `homeTown`): no defaults needed for this one.

> **NOTE:** Use constructor chaining for this. Order matters!

### The Student Class
Subclass of Person. This class has the following instance variables:

- `private double avgGPA`: average gpa of the student
- `private int gtID`: gtID of student
- `private String[] classes`: String array of classes that the student is currently taking

This class requires an explicit constructor that must take in and set `avgGPA`, `gtID`, and `classes` along with any other instance data required by the superclass.

This class should have the following methods:

- `public double getAvgGPA()`: returns avgGPA
- `public String[] getClasses()`: returns an array of classes
- `public String toString()`: returns a string with the following format:
- `public int getGTID()`: returns gtID
  - `name` is `age` years old from `homeTown` with gtid `gtID`
  - You should write this toString method in the way that maximizes code reuse.
- properly overridden equals method that checks `name`, `age`, `hometown`, and `gtID`
	- You should write this equals method in the way that maximizes code reuse.

### The Undergrad Class
Subclass of Student. This class has the following instance variables:

- `private int sleepHours`: int representing the hours of sleep they get

This class requires an explicit constructor that must take in and set `sleepHours` along with any other instance data required by the superclass.

This class has the following methods:

- `public int getSleepHours()`: returns the hours of sleep they get
- `public String toString()`: returns a string with following format:
  - undergrad `name` is `age` years old from `homeTown` with gtid `gtID`is only sleeping `sleepHours` hours per night
  - You should write this toString method in the way that maximizes code reuse.
- properly overridden equals method that checks `name`, `age`, `hometown`, `gtID`, and `sleepHours`
	- You should write this equals method in the way that maximizes code reuse.

### The Grad Class
Subclass of Student. This class has the following instance variables:

- `private String thesisTitle`: title of defense thesis

This class requires an explicit constructor that must take in and set `thesisTitle` along with any other instance data required by the superclass.

This class has the following methods:

- `public String getThesisTitle()`: returns defense thesis title
- `public String toString()`: returns a string with following format:
  - grad `name` is `age` years old from `homeTown` with gtid `gtID`
  - You should write this toString method in the way that maximizes code reuse.
- properly overridden equals method that checks `name`, `age`, `hometown`, `gtID`, and `thesisTitle`
	- You should write this equals method in the way that maximizes code reuse.

### The Professor Class
Subclass of Person. This class has the following instance variables:

- `private int classSize`: int that represent their class size
- `private String[] classes`: String array of the classes that they teach

This class requires an explicit constructor that must take in and set `classSize` and `classes` along with any other instance data required by the superclass.

This class should have the following methods:

- `public String[] getClasses()`: returns an array of classes
- `public String toString()`: returns a string with following format:
  - Professor `name` has a class of `classSize` students
- properly overridden equals method that checks `name`, `age`, `hometown`, and `classSize`
	- You should write this equals method in the way that maximizes code reuse.

### The University Class
This class has the following instance variables:

- `private String name`: the name of the university
- `private Student[] students`: stores an array of Students
- `private Professor[] professors`: stores an array of Professors

This class requires an explicit constructor that must take in and set `name` as well as instantiate `students` and `professors`.

This class should have the following methods:

- `public void addStudent(Student student)`: checks that the student does not already exist in `students` before adding student to the `students` array. If the array is full it must be re-sized before adding the student.
- `public void addProfessor(Professor professor)`: checks that the professor does not already exist in `professors` before adding professor to its corresponding array. If the array is full it must be re-sized before adding the professor.
- `public boolean removeStudent(Student student)`: returns true if it successfully finds and removes the student from `students`, otherwise returns false. This method should make sure that there are no "null gaps" between the students and if there is a null, it is at the end of the array.
- `public String toString()`: returns a String representation of all of the professors and students in the University along with its `name`. The format of this is up to you, but make sure it's legible.

## Clarifications and Tips
You should not import any libraries or packages that trivialize the assignment. This includes data structures other than arrays (so no `List`, `Map`, `Set`, etc). If you are unsure of whether something is allowed, ask on Piazza. In general, if something does a large part of the assignment for you, it is probably not allowed. **Important:** `java.util.Arrays` is not allowed. However, that is different from a Java array (e.g `int[] nums = new int[10]`), which is necessary for this assignment.

- Order matters for constructor chaining.

We recommend you test your code by doing the following:

- Instantiate an instance of a University.
- Add an instance of each class to the University.
- Print out the String representation of the University.
- Remove a student or multiple students.
- Add new students.
- Print out the String representation of the University again.

## Javadocs

- You will need to write Javadoc comments along with checkstyling your submission.

    - Every class should have a class level Javadoc that includes `@author <GT Username>` and `@version <version #>`.

    - Every method should have a Javadoc explaining what the method does and includes any of the following tags if applicable.

        - `@param <parameter name> <brief description of parameter>`

        - `@returns <brief description of what is returned>`

        - `@throws <Exception> <brief explanation of when the given exception is thrown>`

- See the [CS 1331 Style Guide](http://cs1331.gatech.edu/cs1331-style-guide.html) section on Javadoc comments for examples.

## Checkstyle
You must run checkstyle on your submission. The checkstyle cap for this submission is 30 points.
All hashcode() checkstyle will NOT be counted against you for this assignment.

A guide for setting up and running checkstyle can be found on [this page on the course website](http://cs1331.gatech.edu/cs1331-style-guide.html). Make sure you click "Save" when downloading the jar file, and not "Run". It is useful to copy the jar file to your homework directory or set up an alias for it. Run checkstyle for this assignment with `java -jar checkstyle-6.2.2.jar -a *.java`. This will check for both checkstyle errors and javadoc errors.

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
Export the hw3 folder to a .zip file and submit that on T-square. Make sure the zip file contains `Grad.java`, `Person.java`, `Professor.java`, `Student.java`, `Undergrad.java`, and `University.java`.

## Verify the Success of Your Submission to T-Square

Practice safe submission! Verify that your HW files were truly submitted correctly, the upload was successful, and that your program runs with no syntax or runtime errors. It is solely your responsibility to turn in your homework and practice this safe submission safeguard.

- After uploading the files to T-Square you should receive an email from T-Square listing the names of the files that were uploaded and received. If you do not get the confirmation email almost immediately, something is wrong with your HW submission and/or your email. Even receiving the email does not guarantee that you turned in exactly what you intended.
- After submitting the files to T-Square, return to the Assignment menu option and this homework. It should show the submitted files.
- Download copies of your submitted files from the T-Square Assignment page placing them in a new folder.
- Re-run and test the files you downloaded from T-Square to make sure it`s what you expect.
- This procedure helps guard against a few things.

    - It helps insure that you turn in the correct files.
    - It helps you realize if you omit a file or files. Missing files will not be given any credit, and non-compiling/non-running homework solutions will receive few to zero points. Also recall that late homework will not be accepted regardless of excuse. Treat the due date with respect.  Do not wait until the last minute!
(If you do discover that you omitted a file, submit all of your files again, not just the missing one.)
    - Helps find syntax errors or runtime errors that you may have added after you last tested your code.
