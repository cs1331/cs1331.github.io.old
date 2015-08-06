---
layout: default
title: CS 1331 - Running Checkstyle
---

# How To Run Checkstyle on Java Source Files

One runs Checkstyle on Java source code using the `java` command:

```bash
java -jar checkstyle-6.2.1.jar MyJavaFile.java
```
This command is not altogether different from the command that we use to run
compiled Java classes we have written. The command creates an instance of the
Java Virtual Machine, and runs a `main(String[])` method defined in some class.
But rather than invoking the `main(String[])` method of a class we have
written, it instead runs that of a class packaged inside of the provided Java
archive (or `.jar`) file.

It is important to note that Checkstyle will only give reliable output on
*compiling* Java source code. Source code which contains syntax errors may not
yield meaningful output when run through Checkstyle.

One can pass more than one Java source file to Checkstyle. It is recommended
that you always use the command with a [glob pattern][]:
[glob pattern]: <https://en.wikipedia.org/wiki/Glob_(programming)>

```bash
java -jar checkstyle-6.2.1.jar *.java
```
to invoke Checkstyle on each file in the current working directory with a name
ending in `.java`. This helps to ensure that you do not accidentally submit
`.java` files containing style violations.

## Point Deductions

For assignments submitted in this class, style counts in a very real sense.
Grades on assignments will be reduced by up to one point per error reported. It
is very important to correct style errors as you encounter them. As such, it is
recommended that you run Checkstyle on your code several times as you are
writing it.

Some tips for running Checkstyle more easily:

- Use [tab completion][]. This feature is available for most shells (even
  `cmd.exe`), and makes it unnecessary to laboriously type out the entire name
  of the Checkstyle `.jar` file. Simply type `java -jar che` and hit the
  `<TAB>` key, and chances are it will complete to the full name of the
  appropriate file.
[tab completion]: <https://en.wikipedia.org/wiki/Command-line_completion>
- Use [command history][]. This feature allows you to re-run previously entered
  commands without re-typing them. It can be used in most shells using the
  `<UP>` arrow key. Hit `<UP>` multiple times to recall older commands.
[command history]: <https://en.wikipedia.org/wiki/Command_history>

Using these tips, it is very easy to run Checkstyle on your code many times in
the process of development. A recommended practice is to keep a shell open
alongside your text editor and re-run Checkstyle whenever you save a change to
your source code. Doing this will save you many hours of hardship!

## Advanced Options

Checkstyle can also be used to check formatting of Javadoc comments in your
source code. In this course, Javadoc comments (if they are required in an
assignment) will be checked using Checkstyle. Javadoc commenting is usually
introduced several weeks into the course, and required for all assignments
thereafter.

There are several command-line options available for the Checkstyle `.jar`
distributed for this course. The first of these is:

```bash
java -jar checkstyle-6.2.1.jar -j *.java
```
The addition of the `-j` flag tells Checkstyle to check the formatting of
Javadoc comments, rather than running its normal suite of style checks. Errors
reported by this command will also count against you on a one-point-per-error
basis.

Please note that this command checks *only Javadoc comments*. It does
not report errors of coding style not related to Javadocs.

For your convenience, we have also provided another flag, which causes
Checkstyle to report errors related to both general style and Javadoc comments:

```bash
java -jar checkstyle-6.2.1.jar -a *.java
```
Since this command reports all errors for which you may lose points, it is
recommended that you always run this command before you submit, and when
double-checking that your submission has been successfully uploaded.

