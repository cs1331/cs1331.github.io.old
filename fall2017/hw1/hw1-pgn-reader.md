---
layout: homework
title: Homework 1 - PGN Reader
---

# Homework 1 - PGN Reader

## Introduction

In this assignment you will practice

- reading standards,
- manipulating strings,
- using control structures,
- using arrays, and
- maintaining state.

You may use File IO, stream scanning (`java.util.Scanner`) and regular expression classes from the Java standard library, but you may not use any collections classes or write your own classes other than the single class that holds your static methods. You may only use language features we've covered through arrays. If you already know some object-oriented programming this restriction may frustrate you. But this restriction will gain confidence with Java control structures and arrays, and you will appreciate data abstraction with classes.

## Problem Description

Over the course of this semester you will write a chess game database that will import chess games in [PGN](http://www.saremba.de/chessgml/standards/pgn/pgn-complete.htm) format. As a first step you will write code to read PGN games and resolve board positions.

## Solution Description

Write a class called `PgnReader` that contains the following `public` `static` methods:

- `tagValue` takes two `String` arguments: a tag name and a `String`  which contains a PGN-formatted game, and returns a `String` containing the value from the `tag name` tag pair in the PGN game text. If there is no `tag name` tag pair, return `"NOT GIVEN"`.
- `finalPosition` takes a single `String` argument which contains a PGN-formatted game and returns a `String` containing the game's final position in Forsyth-Edwards Notation ([FEN](http://www.saremba.de/chessgml/standards/pgn/pgn-complete.htm#c16.1)).

Write a main method that reads the file named in the `PgnReader`'s first command-line argument into a `String` and uses that `String` as the argument to each method above in order to print game information to the console. First, print the tag names and associated values for the core seven tags of the PGN standard: Event, Site, Date, Round, White, Black, Result. Then print a line reading "Final Position:" and a line displaying the final game position in FEN. Note that in this assignment we only care about the piece placement data, not the other elements of FEN such as active color or castling availability.

Each PGN file will contain a single game and you may assume that the PGN files are valid, and the move text contains only moves, no annotation text. Moves may end in check symbols ('+') or strength judgements ('!', '?').

As your program reads the moves in a game it will need to maintain the state of the board, which you should store in a 2-d array. You will also need to translate between the algebraic notation used to represent moves in PGN, and the internal representation you use for board state, e.g., array indices.

You may use this skeleton file which contains a completed main method and code to read a file and return its content as a `String`: [PgnReader.java](PgnReader.java). This skeleton file also contains stubbed `tagValue` and `finalPosition` methods. A stubbed method is a method that returns a dummy type-correct value (if applicable) so that you can successfully compile code that uses the method. Stubbed methods are useful in incremental program development. You will want to write many helper methods.

### Example

Using the [fegatello.pgn](fegatello.pgn), a shell session with your program would look like this:

```sh
$ java PgnReader fegatello.pgn
Event: Fegatello Attack
Site: NOT GIVEN
Date: NOT GIVEN
Round: NOT GIVEN
White: NOT GIVEN
Black: NOT GIVEN
Result: NOT GIVEN
Final Position:
r1bqkb1r/ppp2Npp/2n5/3np3/2B5/8/PPPP1PPP/RNBQK2R
```

### Domain Knowledge

You don't need to know how to play chess, you only need to know how the pieces and pawns move and how to record chess moves. Use the following links for this purpose:

- [Learn to Play Chess](http://www.chesscorner.com/tutorial/learn.htm) -- You only need to read the information under "Rules of Chess."
- [Chess Notation](http://www.chesscorner.com/tutorial/basic/notation/notate.htm) -- look at abbreviated algebraic notation.


And, of course, you need to know the [PGN Standard](http://www.saremba.de/chessgml/standards/pgn/pgn-complete.htm). You only need sections 2.3, 8.1-8.2.3.6, 16.1.3.1 and 16.1.4. PGN is simple, and you can learn it well enough by simply looking at example PGN games.

### Tips

- Write your program incrementally. Start with `tagValue`, which is easy. Then write your `finalPosition` method so that it correctly analyzes simple games. Finish a 10 point grading category before moving on to the next. After you finish the next grading category, make sure your program is still correct with games in the previous categories. For example, after you finish writing the code to handle castling moves, make sure your program still handle simple games correctly.
- `char` is an integral type. That means you can do arithemtic with `char`s like `algebraicSquare.charAt(0) - 'a'` to translate a file letter to an integer index.
- The [`String`](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html) class's `split` method takes a regular expression as the delimiter, so you can, for example, use any number token (1 or more digits) followed by a period to split a `String` into a `String[]`.
- The [`Character`](https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html) class includes static utility methods for testing `char`s. For example, `Character.isDigit('1')` returns `true`, `Character.isDigit('N')` returns `false`. There are similar methods for detecting upper and lower case `char`s.

## Grading

There are 20 bonus points on this assignment.

- 50 points for correctly extracting tag values.
- 10 points for correctly finding final position of simple openings (in which no piece moves more than once, e.g., each move starts from a home square). ([giuoco-piano.pgn](giuoco-piano.pgn), [ruy-lopez.pgn](ruy-lopez.pgn), [petrov-defense.pgn](petrov-defense.pgn))
- 10 points for simple games or extended openings ([fools-mate.pgn](fools-mate.pgn), [scholars-mate.pgn](scholars-mate.pgn), [fegatello.pgn](fegatello.pgn))
- 10 points for correctly finding final position of simple games or openings that contain castling moves ([ruy-lopez-closed.pgn](ruy-lopez-closed.pgn))
- 10 points for correctly finding final position of games that contain pawn promotions ([panandh-amirpb007-2011.pgn](panandh-amirpb007-2011.pgn))
- 10 points for correctly finding final position of games that contain en passant pawn captures ([french-with-ep.pgn](french-with-ep.pgn), [petrov-with-ep.pgn](petrov-with-ep.pgn))
- 10 points for correctly finding final position of games that contain moves requiring disambiguation of starting file or rank (but not both) to distinguish between two pieces that could make the same move ([A Night at the Opera](morphy-isouard-karl-1958.pgn))
- 10 points for correctly finding final position of games that contain moves requiring disambiguation of starting file and rank to distinguish between two pieces that could make the same move
- 10 points for correctly finding final position of games that require knowledge of tactics (e.g., pinned pieces) to disambiguate to distinguish between two pieces that could make the same move ([tal-fischer-1959-10-11.pgn](tal-fischer-1959-10-11.pgn))

Checkstyle deduction will be capped at 10 points for this homework.

## Turn-in Procedure

Submit your `PgnReader.java` file on T-Square as an attachment.  When you're ready, double-check that you have submitted and not just saved a draft.

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
