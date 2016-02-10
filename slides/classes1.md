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
package edu.gatech.cs1331.blackjack;

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

<!------------------------------------ Slide -------------------------------->
# Following Along Card Example

Clone the repository at [https://github.com/cs1331/card](https://github.com/cs1331/card):
```sh
[chris@nijinsky ~/cs1331]
$ git clone git@github.com:cs1331/card.git
```

In the `card` directory created by cloning the repo you can get a list of versions:

```sh
$ git tag -l -n1
v0.0            Initial version
v0.1            Add main method
v0.2            Add toString() method
v1.0            Private instance variables
...
```

To check out a particular version use `git checkout` with the version name, e.g.:

```sh
[chris@nijinsky ~/cs1331/card]
$ git checkout v0.0
```

<!------------------------------------ Slide -------------------------------->
# A Card Class, v0.0<sup>[1](http://semver.org/)</sup>

Consider how to represent a Card ADT:

- rank - the rank of a playing card, e.g., 2, jack, ace
- suit - the suit of a playing card, e.g., spades, diamonds

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
# Using `Card` v0.1

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
# Card Class, v0.2


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
# Dealing with `this`: Card, v1.2.1

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
# Dealing `Card`, v1.2.1


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
# Class Invariants: Card v1.3

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
# Class Invariants Ensure Consistent Objects

And we fix `Dealer` in v1.3.1:
```Java
public class Dealer {
    public static void main(String[] args) {
        Card c = new Card();
        c.setRank("ace");
        c.setSuit("spades");
        System.out.println(c);
    }
}
```
yields:
```bash
$ java Dealer
ace of spades
```


<!------------------------------------ Slide -------------------------------->
# Classes and Objects

`Card` now ensures that we don't create card objects with invalid ranks or suits.
But consider this slight modification to `Dealer` (v1.4):

```Java
public class Dealer {

    public static void main(String[] args) {
        Card c = new Card();
        System.out.println(c); // Printing a new Card instance
        c.setRank("ace");
        c.setSuit("spades");
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

Notice that we simply use the setter methods we already wrote.

<!------------------------------------ Slide -------------------------------->
# Absence of No-Arg Constructors

If we write a constructor, Java won't provide a default no-arg constructor. (We may choose to provide one.)


So if we don't update the Dealer class it won't compile:

```sh
$ javac *.java
Dealer.java:4: error: constructor Card in class Card cannot be applied to given types;
        Card c = new Card();
                 ^
  required: String,String
  found: no arguments

```
This means there's no no-arg constructor in `Card`.

<!------------------------------------ Slide -------------------------------->
# Using the Card Constructor

Now we have a safer, more consistent  way to initialize objects (v2.0.1):
```Java
public class Dealer {

    public static void main(String[] args) {
        Card c = new Card("queen", "hearts");
        System.out.println(c);
    }
}
```

# Intermission

<center>
<img src="AceofBaseTheSignAlbumcover.jpg" />
</center>

Source: [Wikipedia](http://en.wikipedia.org/wiki/File:AceofBaseTheSignAlbumcover.jpg)
