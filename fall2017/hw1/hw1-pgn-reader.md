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

You may use classes from `java.util` and `java.io`, but you may not write your own classes. If you already know some object-oriented programming, you will find these restrictions annoying.

## Problem Description

You are writing a chess game database that will import chess games in [PGN](http://www.saremba.de/chessgml/standards/pgn/pgn-complete.htm) format. As a first step you decide to write code to read PGN games.

## Solution Description

Write a class called `PgnReader` that contains the following `public` `static` methods:

- `tagValue` takes a `String` tag name and a `String` argument which contains a PGN-formatted game and returns a `String` containing the value from the `Event` tag pair in the PGN game text. If there is no `Event` tag pair, return `"NOT GIVEN"`.
- `finalPosition` takes a single `String` argument which contains a PGN-formatted game and returns a `String` containing the game's final position in [FEN](http://www.saremba.de/chessgml/standards/pgn/pgn-complete.htm#c16.1)

Write a main method that reads the file named in the `PgnReader`'s first command-line argument into a `String` and uses that `String` as the argument to each method above in order to print game information to the console. For example, given a file called `tal-fischer-1959-10-11.pgn` with the following contents:

```pgn
[Event "Bled-Zagreb-Belgrade Candidates"]
[Site "Bled, Zagreb & Belgrade YUG"]
[Date "1959.10.11"]
[Round "20"]
[Result "1-0"]
[White "Mikhail Tal"]
[Black "Robert James Fischer"]

1. d4 Nf6 2. c4 g6 3. Nc3 Bg7 4. e4 d6 5.
Be2 O-O 6. Nf3 e5 7. d5 Nbd7 8. Bg5 h6 9.
Bh4 a6 10. O-O Qe8 11. Nd2 Nh7 12. b4 Bf6
13. Bxf6 Nhxf6 14. Nb3 Qe7 15. Qd2 Kh7 16.
Qe3 Ng8 17. c5 f5 18. exf5 gxf5 19. f4 exf4
20. Qxf4 dxc5 21. Bd3 cxb4 22. Rae1 Qf6 23.
Re6 Qxc3 24. Bxf5+ Rxf5 25. Qxf5+ Kh8 26.
Rf3 Qb2 27. Re8 Nf6 28. Qxf6+ Qxf6 29. Rxf6
Kg7 30. Rff8 Ne7 31. Na5 h5 32. h4 Rb8 33.
Nc4 b5 34. Ne5 1-0
```

a shell session with your program would look like this:

```sh
```

Each PGN file will contain a single game and you may assume that the game contains no illegal moves. You may use the following helper function to help you read the file:

You may use the following helper method to read the file:

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

You can read the

- [PGN Standard](http://www.saremba.de/chessgml/standards/pgn/pgn-complete.htm)


![Annotated chess board](chess-board.jpg)

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
