---
layout: default
title: CS 1331 - Writing Javadocs 
---

# Javadocs
Javadocs are a particular form of Java comments used to document code in a consistent format. Javadocs are added before class headers and method headers.

## General Format
Javadoc comments are block comments with an extra asterik preceding every line:

```java
/**
 * Comments go here
 * Sometimes, there are special kinds of comments preceded with the @
 *      symbol, like so:
 * @return      something
 */
```

Take note of:

- The extra asterik on the first line
- The space on each line before the asterik

## Class Headers
All public classes should be commented in the following format:

```java 
/**
 * Represents a canine animal
 * @author Thomas Shields
 * @author Chris Simpkins
 * @version 1.0 Oct. 2 2015
 */
 public class Dog {
    ...
 }
 ```

There are three components:

- The first line is a general description of the class
- The second line begins with the `@author` tag and is followed by the name of the person who wrote the class. If there is more than one author, include more tags.
- The final line is the version, which starts with `@version` and is followed by anything that represents a version. This can be a date, a version number, whatever you want.

## Method Headers
Method headers should be commented as follows:

```java
/**
 * Calculates the speed an object was travelling given the distance and time 
 * @param time      How long the object is moving for
 * @param distance  How far the object moved 
 * @throws ArithmeticException If the time is zero.
 * @return a double representing the speed at which the object was travelling.
 */
public double getSpeed(double time, double distance) {
    return distance / time;
}
```

The components are:

- The first line is a general description of the class
- For every method parameter, include a line in the format ``@param <parameter_name> <description of what should be passed in>``
- If the method declares an exception, a line in the format ``@param <exception_name> <when/why it would be thrown>`
- If the method has a return type (i.e, not `void` or a Constructor), a line in the format ``@return <description of what is returned>``
