---
layout: homework
title: Homework 1 - Word Guess
---

# CS 1331 Homework 1 - Word Guess

## Introduction

In this programming project you will practice:

- simple console input and output,
- using primitive values and variables,
- using objects of two classes from the Java standard library, and
- control structures.

## Problem Description

You're a bored Georgia Tech student without enough work to fill your days and you like word games, so you decide to make a word guessing game to pass the time.

## Solution Description

Download [`WordGuess.java`](WordGuess.java) and complete the definition of the `WordGuess` class so that it implements a simple word guessing game.  [`WordGuess.java`](WordGuess.java) includes a skeleton `main` method so that you can run the class as a console program. Fill in the rest of the main method -- under the `// Your code here:` line -- with code that implements a console-based word guessing game.

**Do not modify the code we give you.**

### Rules of Word Guess

- If the player makes five incorrect guesses ("misses"), the player loses.
- Player can only guess one letter at at time.
- If a player guesses a letter that occurs in the secret word multiple times, each occurrence of the letter is revealed.

### Game Play

- As long as the player has made fewer than five misses and has not guessed all the letters in the word:
  - Print a line reporting the current missed letters and the number of remaining misses before the player loses.
  - Print a line reporting the current guess with underscores, `'_'`, for letters which haven't yet been guessed.
  - Print a prompt for the user to enter a letter on the same line as the prompt.
  - Read a letter from the console.
  - Update the current guess and the number of misses accordingly.
- Print a line reporting all the letters the player missed in the game.
- Print a line reporting the final guess, including `'_'` characters for letters that weren't guessed.
- If the player lost, print a line saying "Sorry, too many missess." and what the secret word was.
- If the player won, print a line saying "Congratulations! Your got it!" (the full secret word will have already been printed).

### Sample Output

Successful run with a couple of misses and a repeated letter:
```sh
$ java WordGuess
Missed letters (5 left):
Current guess: ___
Guess a letter: c

Missed letters (4 left): c
Current guess: ___
Guess a letter: a

Missed letters (4 left): c
Current guess: _a_
Guess a letter: t

Missed letters (3 left): ct
Current guess: _a_
Guess a letter: d

Missed letters: ct
Current guess: dad
Congratulations! You got it!
```

Unsuccessful run with a couple of hits:
```sh
$ java WordGuess
Missed letters (5 left):
Current guess: ___
Guess a letter: q

Missed letters (4 left): q
Current guess: ___
Guess a letter: w

Missed letters (3 left): qw
Current guess: ___
Guess a letter: e

Missed letters (2 left): qwe
Current guess: ___
Guess a letter: r

Missed letters (2 left): qwe
Current guess: r__
Guess a letter: t

Missed letters (2 left): qwe
Current guess: r_t
Guess a letter: y

Missed letters (1 left): qwey
Current guess: r_t
Guess a letter: u

Missed letters: qweyu
Current guess: r_t
Sorry, too many misses. The secret word was rat
```

### Solutoin Constraints

- **IMPORTANT**: Your output must match the examples above **exactly**.
- You must use a [`Scanner`](https://docs.oracle.com/javase/9/docs/api/java/util/Scanner.html) reading from `System.in` to get the player's input.
- You may not import any classes other than the ones already imported in the provieded code. Yes, certain classes from, e.g.,  `java.util` make sense for this task, but we want you to practice using primitive features of Java.

## Tips and Considerations

- You get the length of a [`String`](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html) with the `length` method, e.g., `"cat".length()` returns `5`.
- You may want to use an instance of the [`StringBuilder`](https://docs.oracle.com/javase/9/docs/api/java/lang/StringBuilder.html) class to hold the player's guess.
  - After you create a new `StringBuilder`, e.g., `StringBuilder sb = new StringBuilder()`, it's empty.
  - Use the `append` method to add a character to the String, e.g. `sb.append('_')`.
    - How would you append a particular number of `'-'` characters?
  - Use the `toString` method to get a printable `String` with the current contents of the `StringBuilder`.
  - Use the `setCharAt` method to set the `char` at a particular index of a `StringBuilder` object, e.g., if you have a `StringBuilder` `sb` whose content is `"___"`, then after `sb.setCharAt(1, 'a')` its content is `"_a_"`.
  - You can play around with `StringBuilder` in [JShell](https://docs.oracle.com/javase/9/jshell/introduction-jshell.htm) to get a feel for it.
- There is no `Scanner` method that returns a `char`. You can use the `next` method, which returns a `String` and use `String`s `charAt` method to get a `char` value. For example `"a".charAt(0)` returns `'a'`.
- The provided code includes a means to pre-select a secret word instead of randomly selecting a secret word. For example, if you run `java WordGuess 0` the secret word will be `"cat"`, if you run `java WordGuess 2` the secret word will be `"dad"`. You can use this feature to test your code. We will use this feature to auto-grade your code.

## Grading

* [10] points: Each field is correctly declared and assigned (2pts per field)
* [5] points: one-arg constructor `Hangman(int totalGuesses)`
* [20] points: guess(int totalGuesses) method (5pts per component)
  * [5] points: Prints out “Please guess one letter at a time.” when more than one letter is guessed and `totalGuesses` is not decremented
  * [5] points: Prints out “You’ve already guessed the letter [insert guessed letter].” when a previously guessed letter is guessed and `totalGuesses` is not decremented
  * [5] points: Prints out “Good guess! The letter [insert guessed letter] appears [insert number of times] time(s).” and `totalGuesses` is not decremented
  * [5] points: Prints out “Sorry. The letter [insert guessed letter] does not appear in the word.” and decrement `totalGuesses`
* [5] points: Displays all guessed letters that are not a part of the word in the correct order.
* [5] points: `show` displays the right number of blanks in the secret word
* [20] points: Fills in all the blanks for correct guesses in `show`
* [10] points: Sets `secretWord` using the index provided as an argument to index into `words`
* [10] points: Sets `secretWord` to a random word in `words` when no argument is provided.
* [5] points: Resets `secretWord` to a random word in `words` in the case where an argument was provided at Runtime and the word was guessed/the number of guesses ran out.
* [10] points: `toString()` method

## Javadocs

Starting from this homework, you will need to write Javadoc comments and watch for checkstyle errors with your submission.

- Every class should have a class level Javadoc that includes `@author <GT Username>`.

- Every public method should have a Javadoc explaining what the method does and includes any of the following tags if applicable:

	- `@param <parameter name> <brief description of parameter>`

	- `@returns <brief description of what is returned>`

	- `@throws <Exception> <brief explanation of when the given exception is thrown>`

See the [CS 1331 Style Guide](http://cs1331.gatech.edu/cs1331-style-guide.html "CS 1331 Style Guide") section on Javadoc comments for examples as well as the provided runner in the `Hangman.java` file.

## Checkstyle

As mentioned in the previously, you will be running a style checking program on your code. For each violation the tool finds, you will lose one point on your total grade for this assignment.

Since checkstyle may be an unfamiliar topic for some, the first few homeworks will have a checkstyle cap, or a maximum amount of points that can be lost to checkstyle. *For this homework*, the **checkstyle cap is 25**, meaning you can lose up to 25 points on this assignment due to style errors. As the semester goes on, this cap will increase with each homework and eventually go away. Run checkstyle early and often! Get in the habit of writing style compliant code the first time. **Do NOT wait until 5 minutes before the deadline of any assignment to run checkstyle!** You may find out that you have 100+ tedious violations to fix!

- If you encounter trouble running checkstyle, check Piazza for a solution and/or ask a TA as soon as you can!
- You can run checkstyle on your code by using the jar file found on the course website and the included xml file. Once you have both files, run the following command: `java -jar checkstyle-6.2.2.jar *.java`.
- To check if you properly wrote your Javadocs, you can run the following command: `java -jar checkstyle-6.2.2.jar -j *.java`.
- Note that the above is **different** from the normal method for running checkstyle. This command will **only check for Javadoc errors** so you will have to run both commands to fully test for style errors.
- Javadoc errors are the same as checkstyle errors, as in each one is worth a single point and they are counted towards the checkstyle cap.
- **You will be responsible for running checkstyle on *ALL* of your code.**
- Depending on your editor, you might be able to change some settings to make it easier to write style-compliant code. See the [customization tips](http://cs1331.gatech.edu/customization-tips.html) page for more information.

## Collaboration

When completing homeworks for CS1331 you may talk with other students about:

_ What general strategies or algorithms you used to solve problems in the homeworks
_ Parts of the homework specification you are unsure of and need more explanation
_ Online resources that helped you find a solution
_ Key course concepts and Java language features used in your solution
_ **You may not discuss, show, or share by other means the specifics of your code, including screenshots, file sharing, or showing someone else the code on your computer, or use code shared by others.**

### Examples of approved/disapproved collaboration:

**OKAY:** "Hey, I'm really confused on how we are supposed to implement this part of the homework. What strategies/resources did you use to solve it?"

**BY NO MEANS OKAY:** "Hey... the homework is due in like 20 minutes... Can I see your code? I *promise* won't copy it directly!"

In addition to the above rules, note that it is not allowed to upload your code to any sort of public repository. This could be considered an Honor Code violation, even if it is after the homework is due.

## Submission

* Submit your `WordGuess.java` file as an attachment to the `hw1` assignment on Canvas. You can submit as many times as you want, so feel free to submit as you make substantial progress on the homework. We only grade your **last** submission, meaning we will ignore any previous submissions.

* As always, late submissions will not be accepted and non-compiling code will be given a score of 0. For this reason, we recommend submitting early and then confirming that you submitted ALL of the necessary files by re-downloading your file(s) and compiling/running them.

## Good Luck! ```  \(°□°)/```