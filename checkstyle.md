---
layout: default
title: CS 1331 - Running Checkstyle
---

# How To Run Checkstyle on Java Source Files

One runs checkstyle on Java source code using the `java` command:

```bash
java -jar checkstyle-6.2.1.jar MyJavaFile.java
```
This command is not altogether different from the command that we use to run
compiled Java classes we have written. The command creates an instance of the
Java Virtual Machine, and runs a `main(String[])` method defined in some class.
But rather than invoking the `main(String[])` method of a class we have
written, it instead runs that of a class packaged inside of the provided Java
archive (or `.jar`) file.

It is important to note that checkstyle will only give reliable output on
*compiling* Java source code. Source code which contains syntax errors may not
yield meaningful output when run through checkstyle.

One can pass more than one Java source file to Checkstyle. It is recommended
that you always use the command

```bash
java -jar checkstyle-6.2.1.jar *.java
```
to invoke checkstyle on each file in the current working directory with a name
ending in `.java`. This helps to ensure that you do not accidentally submit
`.java` files containing style violations.

## Point Deductions

For assignments submitted in this class, style counts in a very real sense.
Grades on assignments will be reduced by up to one point per error reported. It
is very important to correct style errors as you encounter them. As such, it is
recommended that you run checkstyle on your code several times as you are
writing it.

## Advanced Options

Checkstyle can also be used to check formatting of Javadoc comments written
alongside your source code. 
