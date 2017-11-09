---
layout: homework
title: Homework 5 - Chess Game
---

# Homework 5 - Chess Game

## Introduction

In this assignment you will practice

- Using [Optional](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html)
- Using [Predicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)
- Using Lists
- Using Lambdas, Anonymous classes, and Inner classes

## Problem Description

In this homework, you will begin creating many useful classes for our end goal of making a chess database!

- `Ply`
    - One player's move in chess. Kind of like half of a move.
- `Move`
    - One turn of chess: both White's `Ply` and Black's `Ply`.
- `ChessGame`
    - a sequence of `Move`s.

## Solution Description

Classes:
- `Ply`

  - fields:
    - `Piece piece`
    - `Square from`
    - `Square to`
    - `Optional<String> comment`
  - methods:
    - Getter methods for all fields.
    - Constructor that takes in and assigns all fields.

- `Move`

  - fields:
    - `Ply whitePly`
    - `Ply blackPly`
  - methods:
    - Getter methods for all fields.
    - Constructor that takes in and assigns both Plies.

- `ChessGame`

  - fields:
    - `List<Move> moves`
  - methods:
    - `Move getMove(int n)`: returns the nth move.
    - `List<Move> filter(Predicate<Move> filter)`: Returns a list filtered by the predicate. Must not change moves field.
    - `List<Move> getMovesWithComment()`: returns a list of moves with comments (if either or both Ply has a comment). Must not change moves field. Must call `filter` with a **lambda**.
    - `List<Move> getMovesWithoutComment()`: returns a list of moves without comments (if neither Ply has a comment). Must not change moves field. Must call `filter` with an **anonymous inner class**.
    - `List<Move> getMovesWithPiece(Piece p)`: returns a list of moves with a piece of this type (if either Ply uses a piece of the same type as p). **Note:** the pieces don't have to be the exact same but only must be the same type (both pawns or both queens etc.). Must not change moves field. Must call `filter` with an instance of an **inner class**.
    - Constructor that takes in a List of moves.
    - Getter for moves.

**Important:**
`getMovesWithComment`, `getMovesWithoutComment`, `getMovesWithPiece(Piece p)` must use `filter` with a lambda, an anonymous class, and inner class respectively.

If there are any classes that you are unfamiliar with (e.g. Predicate or Optional), look them up in Javadocs. Make the visibility of all the methods and fields as you see best fits good programming style.

Here are links to the approved solution. Feel free to use it instead of your own code. Remember JavaDocs are still required.
- [Piece](ApprovedSolution/Piece.java)
- [Color](ApprovedSolution/Color.java)
- [Bishop](ApprovedSolution/Bishop.java)
- [King](ApprovedSolution/King.java)
- [Knight](ApprovedSolution/Knight.java)
- [Pawn](ApprovedSolution/Pawn.java)
- [Queen](ApprovedSolution/Queen.java)
- [Rook](ApprovedSolution/Rook.java)
- [Square](ApprovedSolution/Square.java)
- [InvalidSquareException](ApprovedSolution/InvalidSquareException.java)

## Grading

Checkstyle deduction will be capped at 50 points for this homework.
Use the -a flag when running checkstyle! JavaDocs will be counted for this homework.

Run this in the folder that has your java files:
`java -jar <path-to-checkstyle.jar> -a *.java`

**Submit code that compiles!!!**

Non compiling code will receive an automatic zero.

- Ply (15 Points)

    - Each field is correctly declared and assigned (2pts per field)
    - Has a constructor that takes in the fields (2pts)
    - Getter methods (5pts)

- Move (10 points)

    - Each field is correctly declared and assigned (2pts per field)
    - Has a constructor that takes in the fields (2pts)
    - Getter methods (4pts)

- ChessGame (75 points)
    - ListMove is correctly declared and assigned (5pts)
    - `getMove()` (10)
    - `getMovesWithComment()` (15)
    - `getMovesWithoutComment()` (15)
    - `getMovesWithPiece(Piece p)` (15)
    - `filter(Predicate<Move> filter)` (15)

## Turn-in Procedure

Submit each of your Java source files necessary for ChessGame to compile on T-Square as separate attachments.  When you're ready, double-check that you have submitted and not just saved a draft. **Download each file and compile them to assure that nothing went wrong with the submission process.**

Files needed:

- Piece and all subclasses of Piece.
- ChessGame
- Ply
- Move
- Color
- Square
- InvalidSquareException

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