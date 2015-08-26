% Conditional Execution
% CS 1331

# Control Flow Issues

- Multiple vs. single entry ("How did we get here?")
- Multiple vs. single exit ("Where do we go from here?")
- ``goto`` considered harmful (``goto`` makes it hard to answer questions above)

# Structured Programming

All algorithms expressed by:

- Sequence - one statement after another
- Selection - conditional execution (not conditional jumping)
- Iteration - loops

No ``goto``

# Boolean Values

Four kinds of boolean expressions:

- ``boolean`` literals: ``true`` and ``false``
- ``boolean`` variables
- expressions formed by combining non-``boolean`` expressions with comparison operators
- expressions formed by combining ``boolean`` expressions with logical operators

# Comparison Expressions

- Equal to: ``==``, like $=$ in math

    - Remember, ``=`` is assignment operator, ``==`` is comparison operator!

- Not equal to: ``!=``, like $\ne$ in math
- Greater than: ``>``, like $>$ in math
- Greater than or equal to: ``>=``, like $\ge$ in math


# Comparison Examples

```Java
1 == 1 // true
1 != 1 // false
1 >= 1 // true
1 > 1  // false
```

# Logical Combinations

- And: ``\&\&``, like $\land$ in math
- Or: ``||``, like $\lor$ in math
Examples:
```Java
(1 == 1) &&  (1 != 1) // false
(1 == 1) ||  (1 != 1) // true
```

Also, unary negation operator ``!``:

```Java
!true     // false
!(1 == 2) // true
```

# ``if-else`` Statement

```Java
if (*booleanExpression*)
    // a single statement executed when booleanExpression is true
else
    // a single statement executed when booleanExpression is false
```

- *booleanExpression* must be enclosed in parentheses
- ``else`` not required


# ``if-else`` Example

```Java
if ((num % 2) == 0)
    System.out.printf("I like %d.%n", num);
else
    System.out.printf("I'm ambivalent about %d.%n", num);
```

# Conditional Assignment

``if-else`` is a statement, so conditional assignment like this:

```Java
String dinner = null;
if (temp > 60) {
    dinner = "grilled";
} else {
    dinner = "baked";
}
```

# Ternary If-Else Expression

The ternary operator combines the above into one expression (expressions have values):

```Java
String dinner = (temp > 60) ? "grilled" : "baked"
```

# Blocks

Enclose any number of statements in curly braces ({ ... }) to create a block, which is like a single statement.

```Java
if ((num % 2) == 0) {
    System.out.printf("%d is even.%n", num);
    System.out.println("I like even numbers.");
} else {
    System.out.printf("%d is odd.%n", num);
    System.out.println("I'm ambivalent about odd numbers.");
}
```

Always use curly braces in control structures.

# Nested ``if-else``

This is hard to follow:

```Java
if (color.toUpperCase().equals("RED")) {
    System.out.println("Redrum!");
} else {
    if (color.toLowerCase().equals("yellow")) {
        System.out.println("Submarine");
    } else {
        System.out.println("A Lack of Color");

}
```

# Multi-way ``if-else``

This multi-way ``if-else`` is equivalent, and clearer:

```Java
if (color.toUpperCase().equals("RED")) {
    System.out.println("Redrum!");
} else if (color.toLowerCase().equals("yellow")) {
    System.out.println("Submarine");
} else {
    System.out.println("A Lack of Color");
}
```

# Short-Circuit Evaluation

Common idiom for testing an operand before using it:
```Java
if ((kids !=0) && ((pieces / kids) >= 2))
    System.out.println("Each kid may have two pieces.");
```

If ``kids !=0`` evaluates to ``false``, then the second sub-expression is not evaluated, thus avoiding a divide-by-zero error.

See [Conditionals.java](../code/basics/Conditionals.java) for examples.

# ``switch``

```Java
switch (expr) {
case 1:
    // executed only when case 1 holds
    break;
case 2:
    // executed only when case 2 holds
case 3:
    // executed whenever case 2 or 3 hold
    break;
default:
    // executed only when other cases don't hold
}
```

- Execution jumps to the first matching case and continues until a ``break``, ``default``, or ``switch`` statement's closing curly brace is reached
- Type of ``expr`` can be ``char``, ``int``, ``short``, ``byte``, or ``String``

# Avoid ``switch``

The ``switch`` statement is error-prone.

- ``switch`` considered harmful -- 97% of fall-throughs unintended
- Anachronism from "structured assembly language", a.k.a. C (a "switch" is just a jump table)

You can do without the ``switch``.  See

- [CharCountSwitch.java](../code/basics/CharCountSwitch.java) for a ``switch`` example,
- [CharCountIf.java](../code/basics/CharCountIf.java) for the same program using an ``if`` statement in place of the ``switch`` statement, and
-  [CharCount.java](../code/basics/CharCount.java) for the same program using standard library utility methods.

# Closing Thoughts

- Conditional execution straightforward, but watch out for side-effects in boolean assignments.
- Parenthesize your expressions to make them clear to the reader and to Java.
- Next we'll learn loops, and we'll have all the tools we need to implement any algorithm. (Actually we already have all the tools we need to implement any algorithm in a functional style, but we need loops for imperative algorithms.)
