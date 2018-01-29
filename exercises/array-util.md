---
layout: exercise
title: CS 1331 Exercise - Array Utilities
---

# Array Utilities

## Introduction

In this exercise you will practice

- writing methods,
- using classes from the Java Standard Library, and
- working with arrays.

## Problem Description

You find yourself needing to do things with arrays frequently, such as getting subarrays from them, determining equality, concatenating them, and printing them.

## Solution Description

Write a class called `ArrayUtil` with the following methods:

- `public static int[] take(int n, int[] xs)` which returns a new array containing the first n elements of xs
- `public static int[] drop(int n, int[] xs)` which returns a new array containing the last n elements of xs
- `public static boolean equals(int[] xs, int[] ys)` which returns true if xs.length == ys.length and xs[i] == ys[i] for 0 <=i < xs.length
- `public static int[] concat(int[] xs, int[] ys)` which returns a new array containing the elements of ys after the elements of xs
- `public static String toString(int[] xs)`
- `public static String toString(int[][] as)`
- `public static int[][] identity(int n)` which returns an n x n identity matrix

## Tips and Considerations
