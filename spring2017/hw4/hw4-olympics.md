---
layout: homework
title: Homework 4
---

# CS1331 Homework 04 - Olympics

In this assignment, we will be testing your understanding of the first three
SOLID principles: **S**ingle responsibility, **O**pen/closed, and the **L**iskov
Substitution Principle.

[Download zip](hw-olympics.zip)

## Table of Contents

* Introduction

* Problem Description

* Background

* Solution Description

* JavaDocs

* Checkstyle

* Submitting

## Introduction

The Olympics are happening (in like two/four years but whatever)! However, the
Olympic commission has become wracked with corruption and as a result the event
is being terribly mismanaged. This is especially evident in the Java program
they're using to manage the people at the event. As a promising Georgia Tech
undergrad, they have hired you to work (for free) to fix their computer system
and save the Olympics!

<img src="https://images.duckduckgo.com/iu/?u=http%3A%2F%2Fchangeworkscom.co.uk%2Fweb-cont1001%2Fuploads%2FOlympic-Rings-large_transX9gqeEfKXQcqd954t2rXzvTSL8SM4yNVj_ZSDGesqAM.jpg&f=1" width=100%>

## Problem Description

The current codebase for managing the people at the Olympic event violates many
of the SOLID principles, namely Single Responsibility, Open/Closed, and Liskov
Substitution. Your job is to refactor this code base to conform to these
principles. This assignment is fairly open ended, so you have freedom to create
new files and name them as you like. Consequently, most of your grade on this
assignment will be on your design choices, and your explanation of those design
choices.

## Background

Before beginning this assignment, it would be wise to familiarize yourself with
these three SOLID design principles (you need not worry about Interface
Segregation and Dependency Injection for now; those will be covered more in
depth in CS 2340). Your lecture notes are a good source of information, but
don't be afraid to branch out and do some of your own research! There are
plenty of good and reliable sources out there to learn from, like Wikipedia.
To give you a general idea of each principle though, we will summarize them
briefly in this section.

### Single Responsibility Principle

This principle is fairly intuitive. It basically means that each class should
only really be responsible for managing and manipulating its own information,
and there shouldn't be that much information to manage. Essentially, this
principle suggests the use of many smaller classes, each with a very specific
purpose over the use of larger, broader classes. Doing this helps to make the
code more modular, reusable, and extensible.

### Open/Closed Principle

The short form of this princple would be, "Open for extension, but closed for
modification." Essentially, it means that when you write a class, you're done.
When you need new features, this means you can't go back and add code to that
class, and this is for good reason. If for every time you needed more features
you just tacked them onto the same class, you would soon have a very broad
class that is doing too many things. Moreover, requiring everyone on a team to
edit the same file makes work a bit of a hassle. Instead, it's better to close
classes for modification, but leave them open for extension. This means that
subclassing a class is OK when you need to add more features or change
functionality.

### Liskov Substitution Principle

This one sounds spooky. but don't worry, it's not that bad. The short form of
this one is that for anywhere an instance of a super class is expected, an
instance of one of its subclasses should be able to be substituted. By, "be
able to be substituted," we mean that when the subclass inherits methods, it
does not broaden the preconditions of any of those methods, or relax their
postconditions if it overrides them. In plain English, this means that
overridden methods or functionalities do not require any more than those in
the super class, and promise no less than them. Think back to the Rectangle
and Square example from lecture. There, the Square was violating LSP because
it relaxed the postconditions (promised less than the superclass's version)
of the setWidth and setHeight methods (that they could be called without
modifiying the other variable).

## Solution Description

**Make sure that you read this whole document before starting!** It may also help
to review your lecture notes on the SOLID principles discussed in class. Also
it will probably help to take a look at the summaries above if you skipped over
them.

### Athlete.java

* Right now, due to the terrible chaos that has engulfed the Olympics, they are
only supporting Tennis Players, Soccer Players, and Javelin Throwers. To
represent these different athletes, they are using the file Athlete.java, and
have been **modifying** it as they add support for different kinds of Athletes.
Can you spot which of the SOLID principles they are violating by having done this?

* Refactor Athlete.java to make it conform to the SOLID principles. Feel free to
make additional classes and redistribute the code in Athlete.java.

    * Hint: pay attention to what the play method is doing, and what it is using
    that private instance field for. You should definitely be able to improve
    the implementation of this method.

    * Hint: what are things all Athletes should be able to do? What things are
    specific to specific kinds of Athletes? Does it make sense to instantiate a
    general Athlete?

* In the class JavaDoc for Athlete.java, briefly explain what SOLID principle(s)
the original implementation was violating and how, and also how your refactoring
has solved it (answer in 2-5 sentences, so don't write an essay please).

* Now, use your new implementation to add support for Hockey Players. Hockey
Players should have some special instance field, a getter for it, and they should
have some special method that prints something out (Use your imagination. We
are grading more on your class design, and are not particularly concerned about
your implementation of this method. It doesn't even need to be a Hockey Player
if you don't want. It could be a StartCraft player. What a time to be alive).

### EventManager.java

* The EventManager is a really busy guy. Because of budget cuts, he's basically
running the whole show and has a ton on his plate. He's in charge of training
the Athletes, cooking for them, making sure they're not cheating, and organizing
the games. Often times he gets home late at night, and his health and married
life have been suffering. He decided he needs to reevaluate where he is in life
and has turned in his two week notice.

* Do you notice which of the SOLID principles has been violated by assigning
so much work to the EventManager?

* Refactor EventManager to make the code conform to the SOLID principles. Feel
free to create additional classes as you please.

    * Hint: You may not even need the EventManager class in the end. Submit this
    file regardless though, and in its class JavaDoc, write a short explanation
    like the one for Athlete.java.

### Spectator.java and SuperFan.java

* Take a look at these two classes and consider if they violate any of the
SOLID principles. In particular, take a close look at the overridden methods
in SuperFan.

    * Hint: Consider the preconditions and postconditions of the methods.

* Refactor these two classes to make them conform to the SOLID principles. Feel
free to create any additional classes or interfaces as needed. Keep in mind that
a defining characteristic of SuperFan is that their favoriteAthlete may not
change, while a Spectator's favoriteAthlete should be able to.

    * Keep in mind that the stadium still needs to be able to have both of these
    kinds of people watching the games, and we need them to be able to cheer
    (i.e we may need to be able to store both of these things in the same array,
    and the type of the array should support cheering).

    * Hint: once you have an idea of which SOLID principle is being violated,
    take a look at the lecture slides for examples of how to correct this
    violation.

* Once again, have a brief explanation like the one in Athlete.java in the class
JavaDoc for Spectator.

### Olympics.java

* Now, create a file called Olympics.java to test your code. This file should be
the main entry point for your program.

* Make an array that has one of each kind of Athlete.

* Iterate over that array, and call the play method on each Athlete.

* Use that array to call all the public methods that were in EventManager in
the original implementation.

* Make an array that contains both Spectators and Superfans.

* Iterate over this array and make them all cheer for their favorite Athlete.

## Javadocs

- You will need to write Javadoc comments along with checkstyling your submission.

    - Every class should two class level Javadocs, `@author <GT Username>` and `@version 2.0`.

    - Every method should have a Javadoc explaining what the method does and includes any of the following tags if applicable.

            - `@param <parameter name> <brief description of parameter>`

            - `@return <brief description of what is returned>`

            - `@throws <Exception> <brief explanation of when the given exception is thrown>`

    - See the [CS 1331 Style Guide](http://cs1331.gatech.edu/cs1331-style-guide.html) section on Javadoc comments for examples as well as the provided files.

## Checkstyle

As mentioned in the previous homework, you will be running a style checking program on your code. For each violation the tool finds, you will lose one point on your total grade for this assignment.

To make things easier for you in the beginning of the semester, the first few homeworks will have a checkstyle cap, or a maximum amount of points that can be lost to checkstyle. For *this homework*, the **checkstyle cap is 75**, meaning you can lose up to **75** points on this assignment due to style errors. As the semester goes on, this cap will increase with each homework and eventually go away. **Run checkstyle early, and get in the habit of writing style compliant code the first time**. Don't wait until 5 minutes before the deadline to find out that you have 100+ violations.

- If you encounter trouble running checkstyle, check Piazza for a solution and/or ask a TA as soon as you can!

- You can run checkstyle on your code by using the jar file found [on the course website](http://cs1331.gatech.edu/cs1331-style-guide.html) like so: `java -jar checkstyle-6.2.2.jar -a *.java`.

- Javadoc errors are the same as checkstyle errors, as in each one is worth a single point and they are counted towards the checkstyle cap.

- **You will be responsible for running checkstyle on *ALL* of your code.**

- Depending on your editor, you might be able to change some settings to make it easier to write style-compliant code. See [the customization tips page](http://cs1331.gatech.edu/customization-tips.html) (at the bottom) for more information.

## Submitting

You should not import any libraries or packages that trivialize the assignment. This includes data structures other than arrays (so no `List`, `Map`, `Set`, etc). If you are unsure of whether something is allowed, ask on Piazza. In general, if something does a large part of the assignment for you, it is probably not allowed. **Important:** `java.util.Arrays` is not allowed. However, that is different from a Java array (e.g `int[] nums = new int[10]`), which is necessary for this assignment.

- The submission tool is included with the HW files. Run it by typing `java -jar hw4-submit.jar`. You can submit as many times as you want so feel free to submit as you make substantial progress on the homework.

- As always, late submissions will not be accepted and non-compiling code will be given a score of 0. For this reason, we recommend submitting early and then confirming that you submitted *ALL* of the necessary files by navigating to the link that the submission tool gives you.
