---
layout: homework
title: Homework 1
---

# CS1331 Homework 01 - Straight As

Welcome to your first full-fledged programming assignment for CS1331! In this homework, you will be tasked with reading data files and using what you've learned so far to create a visualization of the data in your terminal.

[Download zip](hw1-straightAs.zip)
[Submit Tool](hw1-submit.jar)

## Things to know

This homework has several files contained within it. Here are some notes about them:

  - `StraightAs.java`: This is where you will be writing your solution.
  - `StraightAsStudentTests.class`: This is compiled java code that will test your solution against our expected values. We did not release the source code with the homework.
  - `build.gradle`: This file controls the gradle commands. *Do not move or modify this file!*
  - `sample_data.csv`: This file contains your first sample input. More on CSV files below *Do not modify this file*
  - `intercepted_data1.csv` through `intercepted_data3.csv`: more input for your histogram *Do not modify these files*
  - `sample_out/`: This directory contains the sample output for each of the csv files provided. *Do not modify these files*


You should also understand the term "*project root*". This phrase refers to the "top level" directory of the homework project, which contains `build.gradle`, `StraightAs.java`, etc. You will be running all your commands for this homework in the project root.

It is important you understand how to compile and run your code.

1. **Compiling**: `javac` (for example `javac StraightAs.java`).
2. **Running**: `java` (for example `java StraightAs`). When running your code, you can also pass arguments to the program from the command line. The StraightAs program parses three arguments from the command line, in order: `<filename to parse>``<file's data separator>` and `<display mode>`. So running the command on `sample_data.csv` would look like `java StraightAs sample_data.csv ', ' table` on mac/linux or `java StraightAs sample_data.csv ", " table` on windows cmd.

### Checkstyle:
In this course, you will be running a style checking program on your code. For each violation the checkstyle tool finds, you will lose one point on your total homework grade.

To make things easier for you in the beginning of the semester, the first few homeworks will have a checkstyle cap, or a maximum amount of points that can be lost to checkstyle. For homework 1, the checkstyle cap is zero, meaning that checkstyle errors will not affect your homework 1 grade. As the semester goes on, this cap will increase with each homework and eventually go away. Despite the cap being zero for this homework, **you should attempt to fix all your checkstyle errors**, as it is good practice for future homeworks when checkstyle violations will drastically affect your grade.

In the provided homework 1 code, there are already a few checkstyle violations you will need to fix. A guide for setting up and running checkstyle can be found on [this page on the course website](http://cs1331.gatech.edu/cs1331-style-guide.html). Make sure you click "Save" when downloading the jar file, and not "Run". It is useful to copy the jar file to your homework directory or set up an alias for it. Run checkstyle for this assignment with `java -jar checkstyle-6.2.2.jar StraightAs.java`. You will only be responsible for checkstyle in StraightAs.java and not any other file.

## Setting the scene
Michael Weston needs your help. In the process of thwarting an international conspiracy to undermine America's education system, he has intercepted communications between high level targets in the conspiracy. In these communications, he discovered three data files containing information on the grades various students received on a certain test. We're not really sure why this information is at all important to his investigation, but he's asked us to process it nonetheless.

![nmap haker](https://nmap.org/movies/matrix/trinity-nmapscreen-hd-crop-1200x728.jpg)

## Problem Description
You have been tasked with creating a program that will read a file in `CSV` format and generate a histogram of the grade distribution.

### What is CSV format?
CSV stands for "comma separated values", and these files can contain any sort of data you might find in a spreadsheet or a database. A file might look something like:

    burn notice, action, 2013
    super troopers, comedy, 2002
    futurama, comedy, 2013

which, if you opened it in excel or another spreadsheet program, would be displayed as:
![spreadsheet](http://i.imgur.com/S4GFCR1.png)

However, the "comma" in "comma separated values" is misleading; the values in a CSV can be separated by things other than commas. For example, if we wanted to use pipes (the `|` character) instead of commas in the above example, our file would end up looking like:

    burn notice|action|2013
    super troopers|comedy|2002
    futurama|comedy|2013

Notice that the data in the file is exactly the same as before, and only the formatting of the file has changed. If we opened this file in excel and set the `|` character as the data separator, it would display exactly the same as the excel screenshot above.

## Provided Data
We've provided four csv files to you:
To get you started, we've first provided a `sample_data.csv` file containing nicely formatted name and grade pairs.

Then we have the three intercepted data files, `intercepted_data1.csv` through `intercepted_data3.csv`. Unfortunately, these are garbled, because they were intercepted from an encrypted communication. Luckily for us, the grades are still correct, even though the names are unreadable. The CSV separator is different for each file, so your code will have to account for this.

**Each piece of data may be surrounded by an arbitrary number of spaces, so your code should account for this.**

## Running your submission
After you've compiled, you'll need to understand how to run your code.

|Command|Result|
| ------------- |-----------|
|`java StraightAs`|Prints the welcome message and usage help|
|`java StraightAs filename.csv separator displaymode`| Parses `filename.csv`, using `separator` as the separator and `displaymode` as the display mode|

## The arguments for your program

### The `filename` argument
This argument contains the filename of the CSV file to parse. You have been provided with four CSV files to run your code against, although we may test against additional files. To make things interesting, you may only make one pass through the file when reading the CSV data. That is, for each piece of data in the file, you may only extract that piece from the file once.

### The `separator` argument
This argument contains the separator string that is used to denote a new piece of data in the CSV file. See the "What is CSV format" heading above for more information on what a separator is and how it is used with our data.

Each file that has been provided to you uses a different separator string. Thus, you should not hardcode the separator string in your solution.

|Filename|Separator|
| ------------- |-----------|
|sample_data.csv|`,`|
|intercepted_data1.csv|`SEPARATOR`|
|intercepted_data2.csv|`THIS_IS_NOT_A_COMMA`|
|intercepted_data3.csv|`0x0`|

Ensure you are using the correct separator with the given filename, otherwise your program will not be able to understand the CSV format.

### The `displayMode` argument
This argument determines how your program should display the data. In this assignment we will have three different modes of displaying the data. The modes are as follows:

|displayMode|What your program shows|
| ------------- |-----------|
|TABLE|shows the **formatted data table** of the parsed CSV|
|HIST|shows the **histogram** of the parsed CSV|
|BOTH|shows both the **formatted data table** and the **histogram**|

See the next headings for information on the **formatted data table** and **histogram** outputs.
Note, for the `BOTH` display mode, you still may not extract the same data from the file multiple times. Come up with a way to implement `BOTH` without doing this.

## Submission code and output
You will be writing *almost* all your code in the `processGradesFromFile()` method. There is one exception: a checkstyle error has been left in the `main()` method, which you will need to fix as well.

### Formatted Data Table output
In this output mode, you will be outputting the data you read from the CSV, but displayed nicely for the user of your program. Here is an example, from sample_data.csv (this table can be found in `sample_out/sample_data.txt` as well):

```
Rick        99
Philip      57
Turanga     89
Morty       47
       ...
(truncated)
       ...
Eugene      77
Sandy       84
Pearl       71
```

Notice how the names and grades are all aligned nicely in the terminal. This is done by adding spaces to "pad" the output in order to ensure a consistent width of each field. You will be expected to match this padding in your output. To make things easier, you may assume that the longest name you will get in a data file is 10 characters, and that the grades in the file will be between 1 and 100 inclusive. If you have a name that is 10 characters and a grade of 100 (i.e. the widest your input data could possibly be), there should still be one space between the name and the grade:

```
S            1
MEDIUM      89
LONGLONGST 100
```

You do not need to worry about changing the spacing depending on the input data to match the longest name or anything like that. Your name field must be padded to 10 characters wide.

You may find a printf reference [such as this one](http://web.cerritos.edu/jwilson/SitePages/java_language_resources/Java_printf_method_quick_reference.pdf) helpful for figuring out how to pad the data.

A tester to ensure your data table output is correct has been provided to you.

### Histogram output
In this output mode, you will be outputting the data you read from the CSV in histogram format. Here is a sample of histogram your program might output (more examples can be found in the provided `sample_out/` directory):

```
91-100 | [][][][][][][][][]
81- 90 | [][][][][]
71- 80 | [][][][][][][][][][]
61- 70 | [][]
51- 60 | []
41- 50 | [][]
31- 40 |
21- 30 |
11- 20 |
 1- 10 | [][][]
```

In order to do this, you will need some way to keep track of how many grades fall into each interval shown above. To do this, you should create an array and have each value in the array correspond to the number of grades falling into a certain bucket (1-10, 11-20, ..., 91-100)

Notice that like the `TABLE` display mode, the histogram also has padding on the numbers to make them line up. You can use the same padding methods used in the table to pad the histogram.

### Note on file reading
You may only read each piece of data from the csv file **once** in the code you write. If your solution makes multiple passes, you *will* lose points. Thus, you need to be careful when adding functionality for the `BOTH` argument. Although you print both the table and the histogram, the **file must still only be read once**.

## Collaboration with other students
When completing homeworks for CS1331 you may talk with other students about:

- what general strategies or algorithms you used to solve problems in the homeworks
- parts of the homework you are unsure of and need more explanation
- online resources that helped you find a solution
- Key course concepts and Java language features used in your solution

You may **not** discus, show, or share by other means the specifics of your code, including screenshots, file sharing, or showing someone else the code on your computer, or use code shared by others.

Examples of approved/disapproved collaboration:

- **approved**: "Hey, I'm really confused on how we are supposed to implement this part of the homework. What strategies/resources did you use to solve it?"
- **disapproved**: "Yo it's 10:40 on Thursday... can I see your code? I won't copy it directly I promise"

Collaborating with others in a way that violates the approved means is a Georgia Tech Honor Code violation, and you will also break your TAs hearts :broken_heart:

## Testing your code

We have also provided a small number of tests which will find some of the issues with your program's output. These tests are not complete and we will be testing against additional data files when grading, so make sure you double check your code and test your output manually as well.

We have only provided the `.class` file for our tester, so you do not need to run `javac`. Run the tester with `java StraightAsStudentTests` (no additional command line arguments).

When writing your code, you may assume that your code will only ever be run with valid input, and that all CSV files your code will read are valid within the constraints given in this problem description.

## Submitting
You should not import any libraries or packages that trivialize the assignment. This means no downloading CSV parsers from the internet, no using data structures other than arrays (so no `List`, `Map`, `Set`, etc), and anything else that seems beyond the scope of what we are expecting from you. If you are unsure of whether something is allowed, ask on Piazza.

<del>
We are putting the finishing touches on the gradle submission tool, so we haven't included it yet. It is a single gradle file so it will be easy to drop into your homework directory once it is released without losing any of your work. You will run `gradle submit` to submit your homework for grading. Late submissions will not be accepted.
</del>

You can now download the submit tool using the link at the top of the page. After you download it, put it in the same directory as `StraightAs.java`. This is the only file that will be submitted. You can run the submitter by typing `java -jar hw1-submit.jar`. If you encounter any errors, make sure you have the most up to date version of java and if you are on Windows, make sure you are using cmd and not git bash. The submitter will give you a link to the submission it creates. Make sure to navigate to the link and check that the file it submitted is the one that you intended.
