% Classes
% CS 1331

# Classes

<center>
<iframe width="420" height="315" src="https://www.youtube.com/embed/8aXsEO2eKo4" frameborder="0" allowfullscreen></iframe>
</center>

<!------------------------------------ Slide -------------------------------->
# Anatomy of a Class

By the end of next lecture, you'll understand everything in this class definition.
```Java
package edu.gatech.cs1331.card;

import java.util.Arrays;

public class Card {

  public static final String[] VALID_RANKS = {"2", ... , "ace"};
  public static final String[] VALID_SUITS = {"diamonds", ... };
  private String rank;
  private String suit;

  public Card(String aRank, String aSuit) {
    // ...
  }
  public String toString() {
    return rank + " of " + suit;
  }
  private boolean isValidRank(String someRank) { ... }
}
```

# The Card Class Example

In this two-part lecture we'll use a running example stored in a Git repo. Go to [https://github.com/cs1331/card](https://github.com/cs1331/card), click on "Clone or download" and copy the clone URL. Then open your terminal and do this:

```sh
cd cs1331
git clone https://github.com/cs1331/card.git
cd card
```

Note that if you've uplaoded your public SSH key you may use an SSH clone URL.

Now you're ready to follow along.


<!------------------------------------ Slide -------------------------------->
# A Card Class, v0.0<sup>[1](http://semver.org/)</sup>

Consider how to represent a Card ADT:

- rank - the rank of a playing card, e.g., 2, jack, ace
- suit - the suit of a playing card, e.g., spades, diamonds

Here's how you would check out version 0.0:

```sh
git checkout v0.0
```
And your `Card.java` will then contain:

```Java
public class Card {

    String rank;
    String suit;
}
```

- `rank` and `suit` are instance variables
- Every *instance* of `Card` has its own copy of instance variables.

1 [Semantic Versioning](http://semver.org/)

<!------------------------------------ Slide -------------------------------->
# Using `Card` v0.0

```Java
public class Card {

    String rank;
    String suit;

    public static void main(String[] args) {
        Card c = new Card();
        System.out.println(c);
    }
}
```

Note that we can put a `main` method in any class. This is useful for exploratory testing, like we're doing here.

The `String` representation isn't very appealing.  (What does it print?)

<!------------------------------------ Slide -------------------------------->
# Card Class, v0.1


```Java
public class Card {
    String rank;
    String suit;

    public String toString() {
        return rank + " of " + suit;
    }
    public static void main(String[] args) {
        Card swedishPop = new Card();
        swedishPop.rank = "ace";
        swedishPop.suit = "base";
        Card handy = new Card();
        handy.rank = "jack";
        handy.suit = "all trades";
        System.out.println(swedishPop);
        System.out.println(handy);
    }
}
```

Now we have an "ace of base" card and a "jack of all trades" card.  But those aren't valid cards.

<!------------------------------------ Slide -------------------------------->
# Encapsulation: Card, v1.0

Let's protect the instance variables by making them private:
```Java
public class Card {
    private String rank;
    private String suit;

    public String toString() {
        return rank + " of " + suit;
    }

    public static void main(String[] args) {
        Card c = new Card();
        c.rank = "ace";
        c.suit = "base";
        System.out.println(c);
    }
}
```

Why does this still compile?

- `main` method in `Card` -- can see `Card`'s private parts


<!------------------------------------ Slide -------------------------------->
# A Dealer Class, v1.1

```Java
public class Dealer {

    public static void main(String[] args) {
        Card c = new Card();
        c.rank = "ace";
        c.suit = "base";
        System.out.println(c);
    }
}
```

This won't compile (which is what we want). Why?

<!------------------------------------ Slide -------------------------------->
# Mutators: Card, v1.2

```Java
public class Card {

    private String rank;
    private String suit;

    public void setRank(String rank) {
        rank = rank;
    }
    public void setSuit(String suit) {
        suit = suit;
    }
}
```

- Now client code can set the rank and suit of a card by calling `setRank` and `setSuit`.
- `setX` is the Java convention for a setter method for an instance variable named `x`.

<!------------------------------------ Slide -------------------------------->
# Dealing `Card`, v1.2

Let's try out our new `Card` class.
```Java
public class Dealer {

    public static void main(String[] args) {
        Card c = new Card();
        c.setRank("ace");
        c.setSuit("base");
        System.out.println(c);
    }
}
```

Oops.  Prints "null of null".  Why?

<!------------------------------------ Slide -------------------------------->
# Shadowing Variables

The parameters in the setters "shadowed" the instance variables:
```Java
public void setRank(String rank) {
    rank = rank;
}

public void setSuit(String suit) {
    suit = suit;
}
```

- `rank` in `setRank` refers to the local `rank` variable, not the instance variable of the same name
- `suit` in `setSuit` refers to the local `suit` variable, not the instance variable of the same name

<!------------------------------------ Slide -------------------------------->
# Dealing with `this`: Card, v1.3

```Java
public class Card {
    private String rank;
    private String suit;

    public void setRank(String rank) {
        this.rank = rank;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }
}
```

- Every instance of a class has a `this` reference which refers to the instance on which a method is being called.
- `this.rank` refers to the `rank` instance variable for the `Card` instance on which `setRank` is being called.
- `this.rank` is different from the local `rank` variable that is a parameter to the `setRank` method.

<!------------------------------------ Slide -------------------------------->
# Dealing `Card`, v1.3


```Java
public class Dealer {

    public static void main(String[] args) {
        Card c = new Card();
        c.setRank("ace");
        c.setSuit("base");
        System.out.println(c);
    }
}
```

Now we have encapsulation, but we can still create invalid `Card`s, e.g., "base" is not a valid suit.  How to fix?

<!------------------------------------ Slide -------------------------------->
# Class Invariants

Class invariant: a condition that must hold for all instances of a class in order for instances of the class to be considered valid.

Invariants for Card class:

- `rank` must be one of {"2", "3", "4", "5", "6", "7", "8", "9",
         "10", "jack", "queen", "king", "ace"}
- `suit` must be one of {"diamonds", "clubs", "hearts","spades"}

<!------------------------------------ Slide -------------------------------->
# Class Invariants: Card v1.4

`rank` invariant can be maintained by adding:

```Java
public class Card {
    private final String[] VALID_RANKS =
        {"2", "3", "4", "5", "6", "7", "8", "9",
         "10", "jack", "queen", "king", "ace"};
    public void setRank(String rank) {
        if (!isValidRank(rank)) {
            System.out.println(rank + " is not a valid rank.");
            System.exit(0);
        }
        this.rank = rank;
    }
    private boolean isValidRank(String someRank) {
        return contains(VALID_RANKS, someRank);
    }
    private boolean contains(String[] array, String item) {
        for (String element: array) {
            if (element.equals(item)) {
                return true;
            }
        }
        return false;
    }
    // ...
}
```

<!------------------------------------ Slide -------------------------------->
# Class Invariants Ensure Consistent Objects

Now we can't write code that instantiates an invalid `Card` object:
```Java
public class Dealer {
    public static void main(String[] args) {
        Card c = new Card();
        c.setRank("ace");
        c.setSuit("base");
        System.out.println(c);
    }
}
```
yields:
```bash
$ java Dealer
base is not a valid suit.
```

<!------------------------------------ Slide -------------------------------->
# Classes and Objects

`Card` now ensures that we don't create card objects with invalid ranks or suits.
But consider this slight modification to `Dealer`:

```Java
public class Dealer5 {

    public static void main(String[] args) {
        Card c = new Card();
        System.out.println(c); // Printing a new Card instance
        c.setRank("ace");
        c.setSuit("base");
        System.out.println(c);
    }
}
```

What if we printed our `Card` instance, `c`, before we called the setters?

<!------------------------------------ Slide -------------------------------->
# Object Initialization


Two ways to initialize the instance variables of an object:

- Declaration point initialization:

```Java
public class Card {
    private String rank = "2";
    // ...
}
```

- Constructors

```Java
public class Card {
    public Card() {
      rank = "2";
    }
    // ...
}
```

A constructor is what's being called when you invoke operator `new`.

<!------------------------------------ Slide -------------------------------->
# Initializing Objects

Since we didn't write our own constructor, Java provided a default no-arg constructor
- default no-arg ctor sets instance variables (that don't have their own declaration-point intializations) to their default values.

That's why `Card` objects are `null of null` after they're instantiated.  We have to call the setters on a `Card` instance before we have a valid object.

<!------------------------------------ Slide -------------------------------->
# Innitialization Style

In general, it's poor style to require multi-step initialization.

- After `new Card()` is called, instance variables have useless defaults.
- Client programmer must remember to call setter methods.
- Often there can be order dependencies that we don't want to burden client programmers with.

The way to fix this is by writing our own constructor.

<!------------------------------------ Slide -------------------------------->
# A Constructor for Card, v2.0

If we write a constructor, Java won't provide a default no-arg constructor. (We may choose to provide one.)
```Java
public class Card {
    // ...
    public Card(String rank, String suit) {
        setRank(rank);
        setSuit(suit);
    }
    // ...
}
```

<!------------------------------------ Slide -------------------------------->
# Using the Card v2.0 Constructor

Now we have a safer, more consistent  way to initialize objects:
```Java
public class Dealer {

    public static void main(String[] args) {
        Card c = new Card("queen", "hearts");
        System.out.println(c);
    }
}
```

<!------------------------------------ Slide -------------------------------->
# Intermission


<center>
<img src="AceofBaseTheSignAlbumcover.jpg" />
</center>

Source: [Wikipedia](http://en.wikipedia.org/wiki/File:AceofBaseTheSignAlbumcover.jpg)



<!------------------------------------ Slide -------------------------------->
# Progress Check

Let's review our progress with our Card class design:

- We have a nice string representation of Card objects (`Card`).
- We have encapsulated the rank and suit in private instance variables (`Card`) with mutator methods (`Card`) to set their values.
- We validate the rank and suit in the mutator methods so we can't set invalid ranks and suits in Card objects (`Card`).
  - `Card` has a constructor, which ensures that instance variables are initialized when an instance of `Card` is created.

<!------------------------------------ Slide -------------------------------->
# Static Members, Card v2.1

Do we need a separate instance of `VALID_RANKS` and `VALID_SUITS` for each instance of our Card class?

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
# One Final Enhancement

`Card` v2.1 is pretty good, but we can write code like this:

```Java
public class Dealer {

    public static void main(String[] args) {
        Card c = new Card("queen", "hearts");
        System.out.println(c);
        c.setRank("jack"); // modifying c
        System.out.println(c);
    }
}
```
Does this make sense?  Should Card objects be mutable?

<!------------------------------------ Slide -------------------------------->
# Immutable Objects

Card objects don't change.  We can model this behavior by removing the setters and putting the initialization code in the constructor (or making the setters private and calling them from the constructor):

```Java
public Card(String aRank, String aSuit) { // constructor
  if (!isValidRank(rank)) {
    System.out.println(aRank + " is not a valid rank.");
    System.exit(0);
  }
  rank = aRank;
  if (!isValidSuit(aSuit)) {
    System.out.println(aSuit + " is not a valid suit.");
    System.exit(0);
  }
  suit = aSuit;
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
# A Few Final Bits of Polish

Take a look at the final evolution of our Card class.  It contains a few more enhancements:

- Instead of simply terminating the program, the constructor throws `IllegalArgumentException` on invalid input so that client code can choose to deal with the exception at run-time.
- Input is normalized to lower case and spaces trimmed to make the Card object robust to oddly formatted input.
- It has an `equals()` method.

<!------------------------------------ Slide -------------------------------->
# Equality

- `==` means identity equality (aliasing) for reference types (objects).
- The `equals(Object)` tests value equality for objects.

Given our finished Card class with a properly implemented `equals(Object)` method, this code:

```Java
  Card c1 = new Card("ace", "spades");
  Card c2 = new Card("ace", "spades");
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

By the way, what if we left off the parentheses around `c1 == c2` in  `System.out.println("c1 == c2 returns " + (c1 == c2))`?

<!------------------------------------ Slide -------------------------------->
# Review Question 1

```Java
public class Kitten {
    private String name;

    public Kitten(String name) {
        name = name;
    }
    public String toString() {
        return "Kitten: " + name;
    }
}
```

Assume the following statements have been executed:

```Java
        Kitten maggie = new Kitten("Maggie");
        Kitten fiona = new Kitten("Fiona");
        Kitten fiona2 = new Kitten("Fiona");
```

What is the value of `maggie`?

- ?

<!------------------------------------ Slide -------------------------------->
# Review Question 1 Answer

```Java
public class Kitten {
    private String name;

    public Kitten(String name) {
        name = name;
    }
    public String toString() {
        return "Kitten: " + name;
    }
}
```

Assume the following statements have been executed:

```Java
        Kitten maggie = new Kitten("Maggie");
        Kitten fiona = new Kitten("Fiona");
        Kitten fiona2 = new Kitten("Fiona");
```

What is the value of `maggie`?

- the address of a `Kitten` object




<!------------------------------------ Slide -------------------------------->
# Review Question 2

```Java
public class Kitten {
    private String name;

    public Kitten(String name) {
        name = name;
    }
    public String toString() {
        return "Kitten: " + name;
    }
}
```

Assume the following statements have been executed:

```Java
        Kitten maggie = new Kitten("Maggie");
        Kitten fiona = new Kitten("Fiona");
        Kitten fiona2 = new Kitten("Fiona");
```

What does `maggie.toString()` return?

- ?

<!------------------------------------ Slide -------------------------------->
# Review Question 2 Answer

```Java
public class Kitten {
    private String name;

    public Kitten(String name) {
        name = name;
    }
    public String toString() {
        return "Kitten: " + name;
    }
}
```

Assume the following statements have been executed:

```Java
        Kitten maggie = new Kitten("Maggie");
        Kitten fiona = new Kitten("Fiona");
        Kitten fiona2 = new Kitten("Fiona");
```

What does `maggie.toString()` return?

- `"Kitten: null"`

<!------------------------------------ Slide -------------------------------->
# Review Question 3

```Java
public class Kitten {
    private String name;

    public Kitten(String name) {
        name = name;
    }
    public String toString() {
        return "Kitten: " + name;
    }
}
```

Assume the following statements have been executed:

```Java
        Kitten maggie = new Kitten("Maggie");
        Kitten fiona = new Kitten("Fiona");
        Kitten fiona2 = new Kitten("Fiona");
```

What is the value of the expression `fiona == fiona2`?

- ?

<!------------------------------------ Slide -------------------------------->
# Review Question 3 Answer

```Java
public class Kitten {
    private String name;

    public Kitten(String name) {
        name = name;
    }
    public String toString() {
        return "Kitten: " + name;
    }
}
```

Assume the following statements have been executed:

```Java
        Kitten maggie = new Kitten("Maggie");
        Kitten fiona = new Kitten("Fiona");
        Kitten fiona2 = new Kitten("Fiona");
```

What is the value of the expression `fiona == fiona2`?

- `false`

<!------------------------------------ Slide -------------------------------->
# Review Question 4

```Java
public class Kitten {
    private String name;

    public Kitten(String name) {
        name = name;
    }
    public String toString() {
        return "Kitten: " + name;
    }
}
```

Assume the following statements have been executed:

```Java
        Kitten maggie = new Kitten("Maggie");
        Kitten[] kittens = new Kitten[5];
```

What is the value of `kittens[0]` ?

- ?

<!------------------------------------ Slide -------------------------------->
# Review Question 4 Answer

```Java
public class Kitten {
    private String name;

    public Kitten(String name) {
        name = name;
    }
    public String toString() {
        return "Kitten: " + name;
    }
}
```

Assume the following statements have been executed:

```Java
        Kitten maggie = new Kitten("Maggie");
        Kitten[] kittens = new Kitten[5];
```

What is the value of `kittens[0]` ?

- `null`
