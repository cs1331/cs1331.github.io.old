---
layout: default
title: CS 1331 - API Guide
---

# Debugging Guide
*Nicolette Fink*

## Overview

Writing code is the easy part. It’s debugging that is difficult. Unfortunately, there’s no methodological way to go about it. This guide will give you some tips and information about the errors/exceptions you might see which will help you get started, but as with anything related to programming, practice is the best way to develop an intuitive sense of where bugs are coming from and why they are occurring.

## General Tips

1.  **Don’t write all of your code at once: compile as you go.**

    I really can’t stress this enough. Very rarely will you write perfect code the first time and it’s much easier to fix things when you only have a couple compilation errors at a time versus hundreds.

2.  **Print statements are your best friend.**

    Put them everywhere when you’re debugging. Or even when you’re writing code, they can be helpful at making sure what you have so far is working properly. (Just make sure you comment all of them out when you turn in your homework.)

3.  **Start at the top of the stack trace and work your way down.**

    When debugging errors and exceptions, it’s generally best to start at the top and work your way down the list. Occasionally there will be one error that causes several other errors to be thrown. If you started at the bottom you’d be trying to fix problems that aren’t actually there.

4.  **Comment your code.**

    Put comments where the logic or implementation might not make sense when you look at it again later. There’s nothing worse than coming back to code you’ve written and not having a clue what it’s supposed to be doing. However, don’t go overboard with it. If you have the line `i++`; a comment that says ”increment i” is completely unnecessary.

5.  **Talk through your code with someone.**

    I’ve found that this works remarkably well, especially with figuring out bugs in your code. Usually I start explaining the code and halfway through I realize what I was doing wrong.

6.  **When in doubt: Stack Overflow**

    If you can’t figure out what an error means, copy and past the line from the stack trace into google. Someone on stack overflow will have an explanation/solution.

7.  **Take a break every now and then.**

    If you get stuck, take a break. Step away from the code for a little while and come back. I should really take my own advice on this. There have been many times when I sat struggling with a program for hours on end, finally gave up and went to sleep, then woke up the next morning and fixed it in about 10 minutes.


## Common Exceptions/Errors

1. **ArrayIndexOutOfBoundsException**
    This occurs when you try to index at a position outside of the range of the array. Check your loop conditions and make sure the condition terminates with the last valid index.

2. **NullPointerException**

    This can be one of the most tricky errors to pinpoint the cause of, especially when there is a long chain of `NullPointerException`s. Look at the lines of code where the NullPointerException occurred, and the possible values that could have thrown it are anything to the left of a . (basically, any object that a method has been called on). For example, if we had gotten a `NullPointerException` thrown on the following line of code:

        list.add(student.getName());

    The two variables that could have been null can caused the exception are list and student (because you can’t call `add()` on a null `List` and you can’t call `getName()` on a null `Student`). You could use print statements before that line to determine which is null and then analyze your code to determine why. A common reason is that the variable was declared somewhere, but never initialized to a value.

3. **ClassCastException**

    This exception occurs when you try to cast an object into something that it is not a subclass of. For example, you couldn’t do something like:

        Car c = (Car) new Student();

    Because (more than likely) `Student` isn’t a subclass of `Car`, so even though it’s an explicit cast, the compiler can’t perform it because `Student` and `Car` aren’t in the same class hierarchy.

4. **Cannot Find Symbol**

    More than likely, the problem here is that either you forgot to import a class that you are using in your code or you misspelled a method. For java classes that aren’t in the built in java package java.lang, you have to import the class using `import <package pathway>;`. Otherwise the compiler won’t know which class you are talking about and will throw an error that it can’t find that symbol. If you get the error saying it can’t find a method, then that means the class of the object you’re trying to call the method on doesn’t have that method so the compiler doesn’t know how to execute it.

5. **Possible Loss of Precision**

    Typically you’ll see this when casting primitives. Casting upwards in the hierarchy is always safe (ie: you can safely cast from an int to a double because you won’t be losing any information from doing so. However, casting downwards in the hierarchy isn’t guaranteed to be safe. Implicitly casting from a double to an int will cause the error to be thrown that there is a possible loss of conversion (because you’re truncating the decimal off of the double to convert it to an int). If this is the behavior you’re looking for, you can explicitly cast to force the compiler to perform the conversion without throwing the error. In code:

        double a = 1; // no problem here, 1 will simply become 1.0
        int b = 1.5; // won’t compile - possible loss of precision, you would be losing the .5
        int c = (int) 1.5; // explicit cast - c will contain 1

     The same concept applies to Objects. For example, suppose we have a `Person` class and a `Student` class which extends `Person`. You can safely cast upwards: a `Student` object can be cast into a `Person` object because a `Student` is a `Person`. However, you cannot safely cast downwards: a `Person` cannot always be cast into a `Student` because it isn’t guaranteed that every `Person` is a `Student`.

6. **Incompatible Types**

    For an assignment statement to be valid, the type on the left (typically called the static type or compiletime type) of the assignment operator must be the same or a superclass of the value given on the right 2 (typically called the dynamic or run-time type). Below are some examples of valid assignments and ones that would throw an incompatible types error.

        Person p1 = new Student(); // valid - Person is superclass of Student
        Student p2 = new Person(); // incompatible types - Student not superclass of Person
        Person p3 = "Fred"; // incompatible types - String cannot be converted to Person

7. **Non-Static Variable or Method Cannot be Referenced from a Static Context**

    Static vs. non-static is one of those concepts that is hard to grasp. If a method/variable is `static` that means it belongs to the class, not any particular instance of the class. If a method/variable is non-static, that means it belongs to an instance of the class. Trying to use an instance method/variable within a static method doesn’t make sense. You can call static methods when there are 0, 1, 10, or infinite instances of the class. Static methods aren’t called on an instance because there doesn’t even need to be one, so if you attempt to use an instance variable or method within a static method, the program won’t know what instance of the class you’re trying to use. The other way around is perfectly acceptable though. You’re allowed to reference static variables and methods from within a non-static method. Below are examples of each situation:

    This is a valid use of referencing a static variable from a non-static method:

        public class Student {
            private static int numStudents = 0;

            public Student() {
                ...
                numStudents++; // increment numStudents when new Student is created
            }
        }

    This is a invalid reference of a non-static method from a static context:

        public class Driver {
            public static void main(String ... args) {
                someHelperMethod();
            }

            public void someHelperMethod() {
                // does some stuff
            }
        }

8. **Variable Might Not Have Been Initialized**

    When you declare class level fields (for example, instance data) the variables are given their default value according to their type if you don’t provide an initial value. However, local variables aren’t given an initial value. If you try to use a variable that has only been declared locally, it will throw an error saying that the variable may not have been initialized. The following code (which would throw an error saying b might not have been initialized) illustrates the difference between the two situations:

        public class Driver {
            private int a; // this gets the default value 0

            public static void main(String ... args) {
                int b; // doesn’t get a default value
                System.out.println(a + b); // won’t compile
            }
        }

9. **Variable is Already Defined**

    This error is thrown when you attempt to redeclare a variable using the same name. For example, you can’t do something like:

        int a = 4;
        int a = 6;

    Once a variable is declared with a type, you can’t redeclare it with the same (or different) type later on in the code.

## Misleading Error Messages

1. **Illegal Start of Expression**

    An illegal start of expression error is usually a syntactical error. Check to make sure you’ve used all of the java keywords and operators properly. This could also be caused by missing parentheses/brackets which cause the compiler to parse the subsequent lines incorrectly.

2. **Reached End of File While Parsing**

    The only reason I’ve ever seen this thrown is when you’re missing a closing parenthesis/bracket somewhere in your code.

3. **Not a Statement**

    This is also usually due to syntax errors. It means whatever line of code it is thrown on isn’t valid java syntax and thus isn’t a statement that can be compiled.

4. **Unreachable Statement**

    The java compiler checks to make sure that all lines of code have a chance to execute. If there are any that will never get executed, you’ll get an unreachable statement error. Below is one example:

        public int someMethod() {
            int num;
            ... // code that assigns a value to num
            return num;
            System.out.println("Success!"); // <- unreachable statement because of return
        }

## Special Tips for Timed Labs or Programming Quizzes

1. Compile as you go. Like every few lines of code that you write, recompile it.

2. You’re allowed to submit the assignment as many times as you want, so every time it compiles, submit it. That way you always have at least something turned in. (Extra tip: The code we provide will compile before any changes.)

3. The `javac` and `java` commands don’t disappear just because you’re doing a timed lab. If you’re more comfortable using those instead of the sbt commands while you’re writing the code, use those. Then just use `sbt run` and `sbt grade` once you’re pretty much done and want to test it.
