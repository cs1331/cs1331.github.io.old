---
layout: exercise
title: CS 1331 Exercise - Vector2
---


Write an immutable `Vector2` class with:

- Two `public final` instance variables for the two components, `x` and `y`.
- A single constructor that takes two `double` paramters to initialize `x` and `y`.
- A `toString()` method that returns a `String` representation of a `Vector2` that looks like `(1, 2)`.
- A `plus` method that takes another `Vector2` parameter and returns the `Vector2` result of adding  this `Vector2` to the argument `Vector2`.  Vector addition is defined as: $$ (x_1, y_1) + (x_2, y_2) = (x_1 + x_2, y_1 + y_2)$$
- A `minus` method that takes another `Vector2` parameter and returns the `Vector2` result of subtracting the argument `Vector2` object from  this `Vector2`.  Vector subtraction is defined as: $$ (x_1, y_1) - (x_2, y_2) = (x_1 - x_2, y_1 - y_2)$$
- A `dot` method that takes another `Vector2` parameter and returned the `double` dot product of this `Vector2` and the argument `Vector2`.  Dot product is defined as: $$ (x_1, y_1) \cdot (x_2, y_2) = (x_1 \cdot  x_2) + (y_1 \cdot y_2)$$
