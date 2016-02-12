% Classes, Part 2
% CS 1331


# Classes, Part 2


<center>
<img src="AceofBaseTheSignAlbumcover.jpg" />
</center>

Source: [Wikipedia](http://en.wikipedia.org/wiki/File:AceofBaseTheSignAlbumcover.jpg)

<!------------------------------------ Slide -------------------------------->
# Progress Check

Let's review our progress with our Card class design:

- We have a nice string representation of Card objects (`Card` v0.1).
- We have encapsulated the rank and suit in private instance variables (`Card` v1.0) with mutator methods (`Card` v1.2) to set their values.
- We validate the rank and suit in the mutator methods so we can't set invalid ranks and suits in Card objects (`Card` v1.3).
  - `Card` v2.0.1 has a constructor, which ensures that instance variables are initialized when an instance of `Card` v2.0.1 is created.

<!------------------------------------ Slide -------------------------------->
# Card 2.0.1 Redux

```Java
public class Card {

    private final String[] VALID_RANKS =
        {"2", "3", "4", "5", "6", "7", "8", "9",
         "10", "jack", "queen", "king", "ace"};

    private final String[] VALID_SUITS =
        {"diamonds", "clubs", "hearts","spades"};
```

Do we need a separate instance of `VALID_RANKS` and `VALID_SUITS` for each instance of our Card class?

<!------------------------------------ Slide -------------------------------->
# Static Members, Card v2.1

`static` members are shared with all instances of a class:
```Java
public static final String[] VALID_RANKS =
    {"2", "3", "4", "5", "6", "7", "8", "9",
     "10", "jack", "queen", "king", "ace"};
public static final String[] VALID_SUITS =
    {"diamonds", "clubs", "hearts","spades"};
```
Given the declarations above:

- Each instance shares a single copy of `VALID_RANKS` and a single copy of `VALID_SUITS`
- Since they're `final`, we can safely make them `public` so clients of our Card class can use them

<!------------------------------------ Slide -------------------------------->
# Fail

This code should bother you.

```Java
public class Dealer {

    public static void main(String[] args) {
        Card c = new Card("Queen", "Bohemian Rhapsody");
        System.out.println(c);
    }
}
```

Why does it bother you?

<!------------------------------------ Slide -------------------------------->
# Enums Types

An [Enum](http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html) defines a class and all instances of the class in one definition.

```Java
public enum Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
}
```
```Java
public enum Suit {
    DIAMONDS, CLUBS, HEARTS, SPADES
}
```

There's more to Enum types that we won't cover in class but may test on exams.

<!------------------------------------ Slide -------------------------------->
# Using Enums in `Card` v3.0

```Java
public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        setRank(rank);
        setSuit(suit);
    }
    public void setRank(Rank rank) {
        this.rank = rank;
    }
    public void setSuit(Suit suit) {
        this.suit = suit;
    }
    public String toString() {
        return rank + " of " + suit;
    }
}
```
No need for hand-written validation code. No more run-time validation errors. Yay static types!

<!------------------------------------ Slide -------------------------------->
# Using Enums

And using the `Card` v3.0 class is simpler:

```Java
public class Dealer {

    public static void main(String[] args) {
        Card c = new Card(Rank.QUEEN, Suit.HEARTS);
        System.out.println(c);
    }
}
```

You'll even get auto-complete if your editor or IDE is set up to do that.

<!------------------------------------ Slide -------------------------------->
# One Final Enhancement

`Card` v3.0 is pretty good, but we can write code like this (check out v3.1 for this `Dealer`):

```Java
public class Dealer {

    public static void main(String[] args) {
        Card c = new Card(Rank.QUEEN, Suit.HEARTS);
        System.out.println(c);
        c.setRank(Rank.JACK); // modifying c
        System.out.println(c);
    }
}
```
Does this make sense?  Should Card objects be mutable?

<!------------------------------------ Slide -------------------------------->
# Immutable `Card`, v4.0

Card objects don't change.  We can model this behavior by removing the setters and putting the initialization code in the constructor:

```Java
public class Card {

    private Rank rank;
    private Suit suit;

    public Card(Rank aRank, Suit aSuit) {
        rank = aRank;
        suit = aSuit;
    }
    public String toString() {
        return rank + " of " + suit;
    }
}
```

Note the use of another idiom for disambiguating constructor paramters from instance variables (as opposed to using `this`).


<!------------------------------------ Slide -------------------------------->
# Designing Immutable Classes

An immutable class is a class whose instances cannot be modified.  To make a class immutable:

- Don't provide mutator methods ("setters")
- Make the class `final` so it can't be extended (there's another way to accomplish this, but making the class `final` is good enough for now)
- Make all fields `final`
- Make all fields `private`
- For fields of mutable class types, return defensive copies in accessor methods (we'll discuss this later)

<!------------------------------------ Slide -------------------------------->
# Prefer Immutable Classes

In general, make your classes immutable unless you have a good reason to make them mutable.  Why?  Because immutable objects

- are simpler to design becuase you don't have to worry about enforcing class invariants in multiple places,
- are easier to reason about because the state of an object never changes after instantiation,
- are inherently thread-safe becuase access to mutable data need not be syncronized, and
- enable safe instance sharing, so redundant copies need not be created.


<!------------------------------------ Slide -------------------------------->
# Equality, `Card` v4.1

- `==` means identity equality (aliasing) for reference types (objects).
- The `equals(Object)` tests value equality for objects.

```Java
public class Card {
...
    public boolean equals(Object other) {
        if (null == other) { return false; }
        if (this == other) { return true; }
        if (!(other instanceof Card)) { return false; }
        Card that = (Card) other;
        return this.rank.equals(that.rank) && this.suit.equals(that.suit);
    }
}
```
You'll learn how to write `equals` methods later. For now just understand the meaning.

<!------------------------------------ Slide -------------------------------->
# Equality vs. Aliasing

With `Card`'s properly implemented `equals` method, this code:

```Java
Card c1 = new Card(Rank.ACE, Suit.SPADES);
Card c2 = new Card(Rank.ACE, Suit.SPADES);
Card c3 = c1;
System.out.println("c1 == c2 returns " + (c1 == c2));
System.out.println("c1.equals(c2) returns " + c1.equals(c2));
System.out.println("c1 == c3 returns " + (c1 == c3));
System.out.println("c1.equals(c3) returns " + c1.equals(c3));
```

produces this output:

```Java
  c1 == c2 returns false
  c1.equals(c2) returns true
  c1 == c3 returns true
  c1.equals(c3) returns true
```

<!------------------------------------ Slide -------------------------------->
# Packages (v5.0)

We have a nice `Card` library, but it's in the "default" (no-name) package. This will make it hard to use in other code. So let's put it in a package by add ing this declaration at the top of each source file:

```Java
package edu.gatech.cs1331.card;
```

Java requires the directory structure to match the package structure. So we need to move our classes into a `edu/gatech/cs1331/card` directory from our "source root."

<!--------------------------------Slide ------------------------------------->
# Standard Directory Layout

Source Directories

- `src/main/java` for Java source files ("source root")
- `src/main/resources` for resources that will go on the classpath, like image files

Output Directories

- `build/classes` for `javac` output and resources copied from `src/main/resources`

More details on the de-facto standard Java project directory layout: [Maven's directory layout guide](http://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html).

So we'll put our Card source files in `src/main/java/edu/gatech/cs1331/card/`

<!--------------------------------Slide ------------------------------------->
# Using the Standard Layout

Now we're separating our source files from compiler output. Here's how to use the new directory layout:

Make a directory for compiler output:

```sh
[chris@nijinsky ~/cs1331/card]
$ mkdir -p build/classes
```

Tell `javac` where to put compiler output with the `-d` switch:
```sh
[chris@nijinsky ~/cs1331/card]
$ javac -d build/classes/ src/main/java/edu/gatech/cs1331/card/*.java
```

Specify a classpath and fully-qualified class name to run:
```sh
[chris@nijinsky ~/cs1331/card]
$ java -cp ./build/classes/ edu.gatech.cs1331.card.Dealer
```

<!--------------------------------Slide ------------------------------------->
# The Classpath

Just as your operating system shell looks in the `PATH` environment variable for executable files, JDK tools (such as `javac` and `java`) look in the `CLASSPATH` for Java classes.

A classpath specification is a list of places to find `.class` files and other resources.  Two kinds of elements in this list:

- directories in which to find `.class` files on the filesystem, or
- `.jar` files that contain archives of directory trees containing `.class` files and other files (more later).


<!--------------------------------Slide ------------------------------------->
# Specifying a Classpath

To specify a classpath:

- set an environment variable named `CLASSAPTH`, or
- specify a classpath on a per-application basis by using the `-cp` switch.  The classpath set with `-cp` overrides the `CLASSPATH` environment variable.

Don't use the `CLASSPATH` environment variable.  If it's already set, clear it with (on Windows):
```sh
C:\> set CLASSPATH=
```
or (on Unix):
```sh
$ unset CLASSPATH
```
