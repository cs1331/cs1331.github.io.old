---
layout: homework
title: Homework 4 - Collections
---

# Homework 4 - Square Set

## Introduction

In this assignment you will practice

- implementing interfaces,
- using generics,
- using exceptions, and
- implementing simple data structures.

## Problem Description

You want a convenient collection class for `Square`s.

## Solution Description

Write a `SquareSet` class that implements `Set<Square>`.

- Implement all required methods as well as the `add` method. For all other optional methods follow the instructions in the [`Set` API documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Set.html) (what happens when a user calls an optional method that has not been implemented?).
- Implement the two constructors specified in the `Collections` interface documentation.
- If an invalid square is added, throw the `InvalidSquareException` you created in the previous homework. You may need to modify your `InvalidSquareException` class.
- If a `null` is added, throw a `NullPointerException`.
- Use an array as your backing store.
- `Set<E>` implements `Iterable<E>`. So you'll also need to write a class that implements `Iterator<Square>`, an instance of which you should return from `SquareSet`'s `iterator` method. Your `Iterator<Square>` class should be an inner class.

For each class include Javadoc comments as described in the [CS 1331 style guide](../../cs1331-style-guide.html).

## Grading

-  5 points: no-arg contsructor creates an instance of `SquareSet`
-  5 points: `SquareSet(Collection<Square>)` contsructor creates an instance of `SquareSet` with no duplicates or `null`s
-  5 points: `add` method adds a valid `Square` not already in the set
-  5 points: `add` method throws exceptoin for attempt to add and invalid `Square`
-  5 points: `add` method does not add a valid `Square` already in the set
- 10 points: `contains`
-  5 points: `containsAll`
- 10 points: `equals`
- 10 points: `hashCode`
- 10 points: `isEmpty`
- 10 points: `iterator`
-  5 points: `size`
-  5 points: `toArray`
- 10 points: `toArray(T[] a)`

**Bonus**:

- 10 points: `addAll` adds all `Square`s in argument if all squares are valid
- 10 points: `addAll` throws `InvalidSquareExceptoin` and adds no `Square`s from argument if any `Square` in argument is invalid
- 10 points: `addAll` adds `Square`s from arguemnt that are not already in set but not any `Square`'s that are already in the set
- 10 points: `remove` removes argument from set

Checkstyle deduction will be capped at 50 points for this homework.

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
