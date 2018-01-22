---
layout: exercise
title: CS 1331 Exercise - Guess Number
---

# Guess Number

## Introduction

In this exercise you will practice

- writing simple console programs,
- using objects of classes from the Java standard library,
- basic console input/output (IO), and
- control structures.

## Problem Description

You like guessing secret numbers and your friends won't play with you.

## Solution Description

Write a program that randomly chooses a secret number from 1 to 10 and asks the user to guess the number.

- As long as the user guesses incorrectly or doesn't enter "quit" the program should keep asking the user to keep guessing.
  - If the user guesses the correct number then, before exiting, print "Yay! You guessed it. It was N." where N is the randomly chosen secret number.
  - If the user guesses incorrectly print "Higher" or "Lower" depending on whether the secret number is higher or lower than the guess.
  - If the user quits before guessing correctly print "Lame. It was N." where N is the randomly chosen secret number.

## Tips and Considerations

- You may find the documentation for [Random](https://docs.oracle.com/javase/9/docs/api/java/util/Random.html) and [Scanner](https://docs.oracle.com/javase/9/docs/api/java/util/Scanner.html) useful.