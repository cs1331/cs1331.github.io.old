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
  - `Card` v2.0 has a constructor, which ensures that instance variables are initialized when an instance of `Card` v2.0 is created.

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
