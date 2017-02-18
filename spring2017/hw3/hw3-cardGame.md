---
layout: homework
title: Homework 3
---

# CS1331 Homework 03 - Card Game

Hello! In this assignment we will be testing your understanding of polymorphism,
inheritance, abstract classes, and interfaces by having you create a simple
children's card game. Remember to give this whole guide a good once over before
you begin writing.

[Download zip](hw3-cardGame.zip)

## Table of Contents

* Introduction

* Problem Description

* Background

* Tips

* Game Rules

* Solution Description

* Running and Testing

* JavaDocs

* Checkstyle

* Submitting

## Introduction

Seto Kaiba has decided that the rules to the card game Duel Monsters are far too
complicated, and has decided to do away with most of them and create his own
card game, Duel Monsters Abridged. As a proof of concept for the Kaibacorp
board of directors, he has hired you to create a simple text simulation of the
game.

![green hair](https://images.duckduckgo.com/iu/?u=http%3A%2F%2Fimg4.wikia.nocookie.net%2F__cb20100307234750%2Fyu-gi-ohfanon%2Fimages%2F7%2F7f%2FKaiba_on_the_Phone.jpg&f=1)

## Problem Description

You will be writing several classes to represent things such as the player,
the game field, and the cards that the game will be played with. A simple
frontend/testing program has been provided for you as DuelMonstersAbridged.java.
Note that this file will not compile without some other classes being written
first. There are alot of moving parts to this assignment, so suggested workflow
would be to get it to compile first, so that way you can use the tester as you
add functionality. This means you should create files for all the classes, and
write the headers for their methods, just making them return some dummy values
until you implement them. The tester will not be submitted, so feel free to
modify it in whatever way you'd like to best test out different parts of your
code.

## Background

* A subclass can extend a superclass to add some more functionality while
also being able to reuse code from the superclass.

* A subclass can override a superclass's version of a method by providing its
own implementation with the same method header.

    * However, a valid override can also have a covariant return type with
    the super class's version of the method, which means that the return
    type of the subclass's method is just a subclass of the return type
    of the super class's version. Everything else is the same. Remember
    that if you were to change the types of the parameters for the method,
    this would be overloading the method instead of overriding it.

* Anywhere an instance of a superclass is accepted, a subclass can also be
accepted (this kind of explains the covariant return type thing).

* Subclasses inherit all public and protected methods from the superclass.

* A class can be designated as an abstract class, which allows it to have
abstract methods. An abstract method is just a method header without a method
body (i.e it has no implementation yet). Since abstract classes can have methods
without implementations, it doesn't make sense for them to be instantiated, so
they cannot be.

* Classes that are not abstract are said to be concrete, and can be instantiated
as they do not have unimplemented methods (concrete classes must implement all
inherited abstract methods).

* A subclass that extends an abstract class must implement all inherited
abstract methods if it is concrete. It need not do so if it is itself abstract.

* A subclass may only directly extend one other class, but may be a subclass
of many classes. Remember that all classes are subclasses of the Object class.

    * In this way, java is said to have single inheritance of state (i.e it can
    only directly extend one class, and classes can store internal state
    in the form of instance data).

* A subclass can directly implement as many interfaces as it would like.

* An interface is almost like a fully abstract class. It can only have public
abstract methods (this is a bit of a white lie, but don't worry about it) and
cannot have instance data. An interface is almost like a contract; any class
that implements it inherits all of the abstract methods, effectively signing
a contract to implement those methods.

* Anywhere a reference to some interface is expected, a reference to a class
that implements that interface can be used.

    * In this way, java is said to have multiple inheritance of type, as it
    can directly implement multiple interfaces.

## Tips

* This assignment has alot of moving parts, so it would probably be **very**
helpful to draw a diagram of how the classes interact with eachother before
you start coding so you can get a visualization.

* You can use the @Override tag to ask the compiler to double check that a
method you wrote is actually overriding something. For example, you could do
the following if you were overriding hashCode:

```java
// This tag asks the compiler to let you know if you got the method header wrong
@Override
public int hashCode() {
    return 1;
}
```

* You can call a super class's version of a method by using the super keyword.
For example, if a subclass overrides the toString method, you can still access
the super class's version by using:

```java
super.toString()
```

* If you have a couple similar methods, see if you can make a private helper
method to avoid having to duplicate code.

* You can check the dynamic (runtime) type of an object by using the
`instanceof` keyword.

## Game Rules

The following is the abridged rule set for Duel Monsters Abridged. Some of these
rules are implemented by the tester, but you will be responsible for enforcing
some of them in your implementation. Pay attention to the solution description
for what needs to be done in each class.

* This game is two players (in the tester, there is just a simple cpu that
acts as the second player, and all it does is put down cards from its hand).

* There are three broad categories of Card, which are Monster Cards, Spell
Cards, and Trap Cards.

* Monster Cards have an attack power, and can attack an enemy's monster cards.
Each player can have at most five monster cards on the field at once.

* Monster cards may only attack once per turn.

* Monster cards can only attack Monsters with equal or lower attack power.

* Spell Cards have an effect that happens each turn, and an effect that happens
when they are destroyed. A player can have at most five spell cards on the field
at once.

* Trap Cards have an instant effect when played, but do not actually have a spot
on the field.

* Cards may be Special, which means they have an instant effect when played.
All Trap Cards are considered Special.

* Each player has a hand that can have at most five cards.

* Each player has a main deck, from which they can draw one card per turn (
though each player starts the game with a full hand). In the event that a player
has enough space in their hand to draw another card, but has no more cards in
their main deck, they instead lose 500 life points as a penalty.

* Each player has a special deck, which contains only Special cards. They can
hold one of these cards in addition to their hand at any given time, and may
draw another at the end of their turn should they use the one they have.

* Cards played from the special deck will have an instant effect when played.

* Each player has some number of life points. Life points are lost when monsters
battle with each other (the amount lost is the difference between the monsters
attack power). When a player loses all their life points, the game ends.

* Players may play as many of the cards from their hand during a turn as they
want, and amy also play their special card. The only restriction on the number
of cards that can be played is the number of cards that fit on the field.

## Solution Description

As stated in the project description, you should block out all of these classes
and their methods to get the tester to compile first. Once that is done, it
may make sense to work on the classes in the order they are listed here.
Remember that you can compile classes individually to make sure they work before
moving to the next one. That way you don't need to deal with a ton of compiler
errors all at the end.

### Card.java

Represents a card that can be played in the game. This is an abstract class,
and should not be able to be instantiated.

This class has the following private fields, **and associated getter and setter
methods for them**:

* `name` which is a String that represents the name of the card.

* `description` which is a String that represents the description of the card.

This class has the following constructors:

* One that takes in a String for the name, and a String for the description (in
that order) and sets their corresponding instance fields.

This class has the following public methods in addition of the getters and
setters:

* A properly overridden equals method that compares cards based on their names
and descriptions.

* A properly overridden toString method that returns a String in the format:
`name: description`.

### Special.java

This is an interface that a card can implement if it can be summoned to the
field from the special deck, and instantly cause an effect when summoned.

This interface has the following public methods:

* `void instantEffect(Field owner, Field enemy)`

### ObjectDeck.java

Represents a Deck of Objects (think a deck of Cards, but not as specific). This
is an abstract class and should not be able to be instantiated. It is used to
hold a number of items, and can hold them in the form of an array.

This class has the following constructors:

* One that takes in an array of objects, and stores it internally.

This class has the following public methods:

* `Object deal()` which returns the next item in the deck (should return
items starting from the highest index down to the lowest index), or null if
no items remain in the deck. When an object is dealt from the deck, it should
not be possible  for the Deck to deal the item a second time.

* `int size()` which returns the number of items still in the deck.

* `boolean isEmpty()` which returns true if there are no more items in the deck,
and false otherwise.

### CardDeck.java

Represents a deck of Cards specifically. This class is concrete, and
**is an** ObjectDeck, making use of inherited methods so as to reuse as much
code as possible (points will be deducted for unnecessarily duplicating code).

This class has the following constructors:

* One that takes in a **variable number** of Cards and stores them internally.
Hint: this constructor can be done in one line.

This class has the following public methods:

* You should override the deal method to instead return a Card instead of an
Object. Hint: this method can be done in one line.

### SpecialDeck.java

Represents a deck of Specials specifically. This class is concrete, and
**is an** ObjectDeck, making use of inherited methods so as to reuse as much
code as possible (points will be deducted for unnecessarily duplicating code).

This class has the following constructors:

* One that takes in a **variable number** of Specials and stores them
internally. Hint: this constructor can be done in one line.

This class has the following public methods:

* You should override the deal method to instead return a Special instead of an
Object. Hint: this method can be done in one line.

### MonsterCard.java

Represents a Monster card in the game, that can attack other monster cards and
thereby inflict damage to the opponent's life points. This **is a** Card,
and should reuse as much code as possible. Points will be deducted for
unnecessarily duplicating code. This is a concrete class.

This class has the following private fields, **and associated getter and setter
methods for them**:

* `int power` which is the current attack power of the monster.

* `int basePower` which is the initial attack power of the monster when it was
created. This field does not need a setter, as it should not be changed from
the outside.

* `boolean canAttack` which is whether or not the monster can attack on a given
turn.

This class has the following constructors:

* One that takes in a String for the name, and a String for the description, an
int for the power, and a boolean for if it can attack (in that order) and sets
their corresponding instance fields.

* One that does not take in a boolean for if it can attack, and sets a default
value of false for canAttack. (Hint: this constructor should be done in one
line).

This class has the following public methods in addition of the getters and
setters:

* A properly overridden equals method that compares cards based on their names,
descriptions, powers, and basePowers. Remember that you can reuse code from
the Card class here, and you need not rewrite code for comparing the names
and descriptions!

* A properly overridden toString method that returns a String in the format:
`name: description | Power: power | Can attack: canAttack`. Again, remember
that you have already written some of the code for this!

### SpellCard.java

Represents a spell card that has an effect that it applies every turn, and also
applies some effect when it gets destroyed. This is an abstract class and should
not be able to be instantiated. This **is a** Card, and should reuse as much
code as possible.

This class has the following constructors:

* One that takes in a String for the name, and a String for the description (in
that order) and sets their corresponding instance fields.

This class has the following public methods:

* `abstract void turnEffect(Field ownerField, Field enemyField)` which is the
effect that gets applied every turn.

* `abstract void destroyedEffect(Field ownerField, Field enemyField)` which is
the effect that gets applied when the card is destroyed.

* A properly overridden equals method that compares cards based on their names
and descriptions. Again, remember to reuse code, and be careful to make sure
that this will not return true for a MonsterCard of the same description and
name for example.

### TrapCard.java

Represents a card that has some instant effect and does not actually get
placed onto the Field. This is an abstract class that **is a** Card and also
**is** Special.

This class has the following public methods:

* A properly overridden equals method that compares cards based on their names
and descriptions. Again, remember to reuse code, and be careful to make sure
that this will not return true for a MonsterCard of the same description and
name for example.

### Field.java

Represents a game field that the cards can be placed on. This is a concrete
class.

This class has the following private fields, **and associated getter methods for
them (you need not write setter methods for this class)**:

* `MonsterCard[] monsters` which is an array of length 5 that stores the
monsters currently on the field.

* `SpellCard[] spells` which is an array of length 5 that stores the spells
currently on the field.

This class has the following public methods:

* `void cardTurnEffects(Field enemyField)` which should apply the turnEffects
for every spell currently on this field, and also set all monsters on the field
to be able to attack. This gets run at the end of the player's turn.

* `boolean addMonsterCard(MonsterCard card)` which will add card to the first
non-null spot in the monsters array and return true, or return false if there is
no space in the array for it to be added.

* `boolean addSpellCard(SpellCard card)` which will add card to the first
non-null spot in the spells array and return true, or return false if there is
no space in the array for it to be added.

### Player.java

Represents a player in the game that has decks and a hand and such. This is a
concrete class.

This class has the following private fields, **and associated getter and setter
methods for them**:

* `CardDeck mainDeck` which will be the main deck for the Player's Cards. You
need not write getters and setters for this.

* `SpecialDeck specialDeck` which will be the deck for the Player's Special
Cards. You need not write getters and setters for this.

* `Card[] hand` which will be an array of length 5 that stores the Cards in the
player's hand.

* `Special nextSpecial` which will be the player's special card that they may
play.

* `int lifePoints` the number of life points the player has remaining.

This class has the following constructors:

* One that takes in, in this order, a CardDeck for the main Deck, a SpecialDeck
for the special Deck, and an int for the lifepoints, and sets their
corresponding instance fields.

* One that does not take in lifepoints, and instead sets lifepoints to a default
of 5000 (again, this should be done in one line).

This class has the following public methods:

* `boolean draw(int count)` will attempt to draw count cards from the mainDeck
into the hand array. It should fill up null spots in the array starting from
the beginning. In the event that there is a null spot in the hand, but not
enough cards in the mainDeck to fill it, false should be returned. Otherwise
return true.

* `void drawSpecialCard()` should fill nextSpecial with the next card in the
specialDeck if nextSpecial is null.

* `void nextTurnPrep()` which will attempt to draw one card from the mainDeck,
and if it cannot, will deduct 500 lifepoints. Will also attempt to draw a
Special card into the nextSpecial position.

* `boolean playCardFromHand(int whichCard, Field myField)` should add the card
at index whichCard in the hadn onto myField. Make sure to check that the
passed in index is within the bounds of hand. MonsterCards and SpellCards should
be added to the field appropriately, while TrapCards should not be added (as
they are just for quick play). Returns whether or not the card was successfully
played (the play fails if there is not room on the field, or if the index is
out of range). Should also remove the played card from the hand.

* `boolean playSpecial(Field myField)` works similarly to playCardFromHand,
except it only tries to play nextSpecial. Remember to clear nextSpecial if
it is played successfully.

* `void changeLifePoints(int change)` will add change to the current lifePoints.

* `boolean isDefeated()` returns whether or not lifepoints are less than or
equal to zero.

### BlueEyesWhiteDragon.java

Represents a Blue Eyes White Dragon monster, that also has a Special effect.
This is a concrete class.

This class has the following constructors:

* A no-args constructor that sets its name to "Blue Eyes White Dragon", its
description to "The best card.", its attack to 3000, and makes it so that this
card may attack.

This class has the following public methods:

* This class should implement any remaining abstract methods. Since Kaiba loves
this card so much, he loves being able to summon a bunch of them to the field
all in one turn. So, the special instant effect of this card should be to add
two new Blue Eyes White Dragons to its owner's side of the field (add at most
two dragons, or just fill up the remaining spots if there are less than two
spaces).

### PowerCard.java

Represents a Spell Card that increases the power of monsters on its owner's
side of the field each turn, or decreases their power once destroyed.

This class has the following constructors:

* A no-args constructor that sets its name to "Power Card", and its description
to "Increases power of monsters by 100 each turn."

This class has the following public methods:

* It should implement any remaining abstract methods such that the effect it
has each turn is to increase the power of all monsters on its owner's side of
the field by 100. When destroyed, this card should decrease the power of all
monsters on its owner's side of the field by 300.

### DestroySpell.java

Represents a Trap Card that has the ability to destroy an opponent's Spell Card.

This class has the following constructors:

* A no-args constructor that sets its name to "Destroy Spell" and its
description to "Destroys the enemy's first spell card.".

This class has the following public methods:

* This should implement any remaining abstract methods such that its instant
effect when played is to destroy the enemy's first spell card (i.e the first
spell card it finds when searching through the enemy's active spell cards on
the field).

## Running and Testing

A good way to test your implementation is to play games with the tester and
make sure that all of the rules of the game are being followed, and that
nothing unexpected is happening. You shouldn't need to modify the tester too
much to this end, but within DuelMonstersAbridged.java, there is a method called
`private static void setupPlayers()` that puts together the decks and
instantiates the players. If you make your own cards to test functionality,
you can add them into the decks here.

* Note: the current way the decks are setup, Red Eyes Black Dragon should be the
first card that you draw from the mainDeck in the game, and Blue Eyes White
Dragon should be your first special card.

## Javadocs

- Starting from this homework, you will need to write Javadoc comments along with checkstyling your submission.

    - Every class should two class level Javadocs, `@author <GT Username>` and `@version 1.0`.

    - Every method should have a Javadoc explaining what the method does and includes any of the following tags if applicable.

        - `@param <parameter name> <brief description of parameter>`

        - `@return <brief description of what is returned>`

        - `@throws <Exception> <brief explanation of when the given exception is thrown>`

- See the [CS 1331 Style Guide](http://cs1331.gatech.edu/cs1331-style-guide.html) section on Javadoc comments for examples as well as the provided `DuelMonstersAbridged.java` file.

## Checkstyle

As mentioned in the previous homework, you will be running a style checking program on your code. For each violation the tool finds, you will lose one point on your total grade for this assignment.

To make things easier for you in the beginning of the semester, the first few homeworks will have a checkstyle cap, or a maximum amount of points that can be lost to checkstyle. For *this homework*, the **checkstyle cap is 50**, meaning you can lose up to **50** points on this assignment due to style errors. As the semester goes on, this cap will increase with each homework and eventually go away. **Run checkstyle early, and get in the habit of writing style compliant code the first time**. Don't wait until 5 minutes before the deadline to find out that you have 100+ violations.

- If you encounter trouble running checkstyle, check Piazza for a solution and/or ask a TA as soon as you can!

- You can run checkstyle on your code by using the jar file found [on the course website](http://cs1331.gatech.edu/cs1331-style-guide.html) like so: `java -jar checkstyle-6.2.2.jar -a *.java`.

- Javadoc errors are the same as checkstyle errors, as in each one is worth a single point and they are counted towards the checkstyle cap.

- ** You will be responsible for running checkstyle on *ALL* of your code. **

- Depending on your editor, you might be able to change some settings to make it easier to write style-compliant code. See [the customization tips page](http://cs1331.gatech.edu/customization-tips.html) (at the bottom) for more information.

## Submitting
You should not import any libraries or packages that trivialize the assignment. This includes data structures other than arrays (so no `List`, `Map`, `Set`, etc). If you are unsure of whether something is allowed, ask on Piazza. In general, if something does a large part of the assignment for you, it is probably not allowed. **Important:** `java.util.Arrays` is not allowed. However, that is different from a Java array (e.g `int[] nums = new int[10]`), which is necessary for this assignment.

- The submission tool is included with the HW files. Run it by typing `java -jar hw3-submit.jar`. You can submit as many times as you want so feel free to submit as you make substantial progress on the homework.

- As always, late submissions will not be accepted and non-compiling code will be given a score of 0. For this reason, we recommend submitting early and then confirming that you submitted *ALL* of the necessary files by navigating to the link that the submission tool gives you.
