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

You may use classes from the Java standard library, but you may not write your own classes. If you already know some object-oriented programming, you will find these restrictions annoying.

## Problem Description

You are writing a chess game database that will import chess games in [PGN](http://www.saremba.de/chessgml/standards/pgn/pgn-complete.htm) format. As a first step you decide to write code to read PGN games.

## Solution Description

Write a class called `PgnReader` that contains the following `public` `static` methods:

- `tagValue` takes two `String` arguments: a tag name and a `String`  which contains a PGN-formatted game, and returns a `String` containing the value from the `tag name` tag pair in the PGN game text. If there is no `tag name` tag pair, return `"NOT GIVEN"`.
- `finalPosition` takes a single `String` argument which contains a PGN-formatted game and returns a `String` containing the game's final position in Forsyth-Edwards Notation ([FEN](http://www.saremba.de/chessgml/standards/pgn/pgn-complete.htm#c16.1)).

Write a main method that reads the file named in the `PgnReader`'s first command-line argument into a `String` and uses that `String` as the argument to each method above in order to print game information to the console. First, print the tag names and associated values for the core seven tags of the PGN standard: Event, Site, Date, Round, White, Black, Result. Then print a line reading "Final Position:" and a line displaying the final game position in FEN. Note that in this assignment we only care about the piece placement data, not the other elements of FEN such as active color or castling availability.

For example, using the [fegatello.pgn](fegatello.pgn), a shell session with your program would look like this:

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

Each PGN file will contain a single game and you may assume that the game contains no illegal moves. You may use the following helper function to read the PGN game file and return its contents as a `String`:

```Java
    public static String fileContent(String fileName) {
        Path file = Paths.get(fileName);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                // Add the \n that's removed by readline()
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            System.exit(1);
        }
        return sb.toString();
    }
```

### Discussion

You don't need to know how to play chess, you only need to know how the pieces and pawns move and how to record chess moves. Use the following links for this purpose:

- [Learn to Play Chess](http://www.chesscorner.com/tutorial/learn.htm) -- You only need to read the information under "Rules of Chess."
- [Chess Notation](9http://www.chesscorner.com/tutorial/basic/notation/notate.htm) -- look at abbreviated algebraic notation.


And, of course, you need to know the [PGN Standard](http://www.saremba.de/chessgml/standards/pgn/pgn-complete.htm). PGN is simple, and you can learn it well enough by simply looking at example PGN games.

## Grading

- 40 points for correctly extracting tag values.
- 10 points for correctly finding final position of simple games or openings ([fools-mate.pgn](fools-mate.pgn), [scholars-mate.pgn](scholars-mate.pgn), [fegatello.pgn](fegatello.pgn))
- 10 points for correctly finding final position of games that contain castling moves
- 10 points for correctly finding final position of games that contain en passant pawn captures
- 10 points for correctly finding final position of games that contain pawn promotions
- 10 points for correctly finding final position of games that contain moves requiring disambiguation of starting file or rank but not both to distinguish between two pieces that could make the same move
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
