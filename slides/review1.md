% Review 1
% CS 1331

# Hello, Java!

```Java
import java.util.Random;
public class Hello {
    private static final String[] GREETINGS = {"Hello!", "Hi!", "W'sup!"};
    private String greeting;

    private Hello() {
        Random rand = new Random();
        int greetingsIndex = rand.nextInt(GREETINGS.length);
        greeting = GREETINGS[greetingsIndex];
    }
    public Hello(int anIndex) {
        int greetingsIndex = anIndex % GREETINGS.length;
        greeting = GREETINGS[greetingsIndex];
    }
    public String getGreeting() {return greeting;}
    public static void main(String[] args) {
        Hello h = new Hello();
        System.out.println(h.getGreeting());
    }
}
```

<!------------------------------------ Slide -------------------------------->
# The `import` Statement

The statement
```Java
import java.util.Random;
```

allows us to use the `java.util.Random` class in our program.  Without the import, the line

```Java
  Random rand = new Random(1);
```

would prodiuce the following error:

```Java
Hello.java:11: error: cannot find symbol
        Random rand = new Random(1);
        ^
  symbol:   class Random
  location: class Hello
```



<!------------------------------------ Slide -------------------------------->
# No-arg Constructors

```Java
public Hello() {
    Random rand = new Random(10);
    int greetingsIndex = rand.nextInt(greetings.length);
    greeting = greetings[greetingsIndex];
}
```

- Constructors initialize an object of a class.  In this case, the constructor initializes the `greeting` instance variable
- Constructors are called with operator `new`
- After `Hello h = new Hello();`, `h` holds the address of a `Hello` object which has some randomly assigned `greeting` instance variable
- `h` is a *reference* to a `Hello` object


What does `Random rand = new Random(10);` do?

<!------------------------------------ Slide -------------------------------->
# Constructors With Parameters

```Java
public Hello(int anIndex) {
    int greetingsIndex = anIndex % greetings.length;
    greeting = greetings[greetingsIndex];
}
```

- To call this constructor, provide an argument in the call to `new`, as in `Hello h = new Hello(1);`
- Providing the argument in the `new` call selects a particular constructor, in this case the constructor that takes one `int` parameter




<!------------------------------------ Slide -------------------------------->
# Static versus Non-Static

Consider [Doberman.java](../code/classes/Doberman.java):

```Java
public class Doberman {
    private static int dobieCount = 0;
    private String name;

    public Doberman(String name) {
        this.name = name;
        dobieCount++;
    }
    public String reportDobieCount() {
        return name + " says there are " + dobieCount + " dobies.";
    }
}
```

- `dobieCount` is shared between all instances of the `Doberman` class.
- Each instance of `Doberman` has its own distinct copy of `name`.


<!------------------------------------ Slide -------------------------------->
# Reference Counting

Given [DaringDobermans.java](../code/classes/DaringDobermans.java):
```Java
public class DaringDobermans {
    public static void main(String[] args) {
        Doberman fido = new Doberman("Fido");
        Doberman prince = new Doberman("Prince");
        Doberman chloe = new Doberman("Chloe");
        System.out.println(fido.reportDobieCount());
        System.out.println(prince.reportDobieCount());
        System.out.println(chloe.reportDobieCount());
    }
}
```

and our definition of `Doberman`, what will `java DaringDobermans` print?

```Java
$ java DaringDobermans
???
???
???
```


<!------------------------------------ Slide -------------------------------->
# Reference Counting

Given [DaringDobermans.java](../code/classes/DaringDobermans.java):
```Java
public class DaringDobermans {
    public static void main(String[] args) {
        Doberman fido = new Doberman("Fido");
        Doberman prince = new Doberman("Prince");
        Doberman chloe = new Doberman("Chloe");
        System.out.println(fido.reportDobieCount());
        System.out.println(prince.reportDobieCount());
        System.out.println(chloe.reportDobieCount());
    }
}
```

and our definition of `Doberman`, what will `java DaringDobermans` print?

```Java
$ java DaringDobermans
Fido says there are 3 dobies.
Prince says there are 3 dobies.
Chloe says there are 3 dobies.
```


<!------------------------------------ Slide -------------------------------->
# Not Reference Counting

Now remove `static` from the definition of `dobieCount`:

```Java
    private int dobieCount = 0;
```

Now when we run `DaringDobermans` we get

```Java
$ java DaringDobermans
Fido says there are 1 dobies.
Prince says there are 1 dobies.
Chloe says there are 1 dobies.
```

The difference is that now each `Doberman` instance has its own copy of `dobieCount`, not a class-wide, or `static` `dobieCount`

<!------------------------------------ Slide -------------------------------->
# Review Question 1

```Java
public class Doberman {
    private static int dobieCount = 0;
    private String name;

    public Doberman(String name) {
        this.name = name;
        dobieCount++;
    }
    public String reportDobieCount() {
        return name+" says there are "+dobieCount+" dobies.";
    }
}
```

What does this code print?

```Java
        Doberman fido = new Doberman("Fido");
        System.out.println(fido.reportDobieCount());
        Doberman prince = new Doberman("Prince");
        System.out.println(prince.reportDobieCount());
        Doberman chloe = new Doberman("Chloe");
        System.out.println(chloe.reportDobieCount());
```

<!------------------------------------ Slide -------------------------------->
# Review Question 1

Given the definition of `Doberman` from the previous slide,
```Java
        Doberman fido = new Doberman("Fido");
        System.out.println(fido.reportDobieCount());
        Doberman prince = new Doberman("Prince");
        System.out.println(prince.reportDobieCount());
        Doberman chloe = new Doberman("Chloe");
        System.out.println(chloe.reportDobieCount());
```
prints
```sh
Fido says there are 1 dobies.
Prince says there are 2 dobies.
Chloe says there are 3 dobies.
```

<!------------------------------------ Slide -------------------------------->
# Review Question 2

- Is `int n = 2.2;` legal?
- What's the value of the expression `17 % 4`?
- What's the value of `n` after `int n = (int) 2.2;`?
- After the line above and `n++;`, what's the value of `n`?
- After the line above and `n += 2;`, what's the value of `n`?
- After the line above and `String s = "Answer: " + n;`, what's the value of `s`?

<!------------------------------------ Slide -------------------------------->
# Review Question 2

- `int n = 2.2;` is not legal -- implicit narrowing conversion
- `17 % 4` is `1`
- After `int n = (int) 2.2;` `n` is 2
- After the line above and `n++;`,  `n` is 3
- After the line above and `n += 2;`, `n` is 5
- After the line above and `String s = "Answer: " + n;`, `s` is `"Answer: 5"`


<!------------------------------------ Slide -------------------------------->
# Review Question 3


Will this code compile?

```Java
String condition = "true";
if (condition) {
    System.out.println("The true path.");
} else {
    System.out.println("The false path.");
}
```

<!------------------------------------ Slide -------------------------------->
# Review Question 3


Will this code compile?

```Java
String condition = "true";
if (condition) {
    System.out.println("The true path.");
} else {
    System.out.println("The false path.");
}
```

No. `condition` must be a boolean expression.

<!------------------------------------ Slide -------------------------------->
# Review Question 4

What will this code print?
```Java
boolean a = true;
boolean b = false;
if (a && b ) {
    System.out.println("the true path");
} else {
    System.out.println("the false path");
}
```

<!------------------------------------ Slide -------------------------------->
# Review Question 4

```Java
boolean a = true;
boolean b = false;
if (a && b ) {
    System.out.println("the true path");
} else {
    System.out.println("the false path");
}
```
prints

```sh
the false path
```

`&&` is logical *and*.

<!------------------------------------ Slide -------------------------------->
# Review Question 5

What will this code print?

```Java
public class ShortCircuit {

    private static int counter = 0;

    private static boolean inc() {
        counter++;
        return true;
    }
    public static void main(String args[]) {
        boolean a = false;
        if (a || inc()) {
            System.out.println("Meow");
        }
        System.out.println("counter: " + counter);
        if (a && inc()) {
            System.out.println("Woof");
        }
        System.out.println("counter: " + counter);
    }
}
```
<!------------------------------------ Slide -------------------------------->
# Review Question 5

Substitute values, track `counter` and output:

```Java
Code                                       counter  Output

boolean a = false;                         0
if (a || inc()) {                          1
    System.out.println("Meow");            1        Meow
}                                          1
System.out.println("counter: " + counter); 1        counter: 1
if (a && inc()) {                          1
    System.out.println("Woof");            1
}                                          1
System.out.println("counter: " + counter); 1        counter: 1
```

Key points:

- `inc()` always returns `true`
- Due to short-curcuit evaluation, `inc()` not always evaluated


<!------------------------------------ Slide -------------------------------->
# Review Qustion 6

How would you write this `while` loop as a `for` loop?
```Java
int n = 0;
while (n < 5) {
    System.out.println("Hip, hip, hooray!");
    n++;
}
```

Answer:
```Java
???
???
???
```

<!------------------------------------ Slide -------------------------------->
# Review Qustion 6

How would you write this `while` loop as a `for` loop?
```Java
int n = 0;
while (n < 5) {
    System.out.println("Hip, hip, hooray!");
    n++;
}
```

Answer:
```Java
for (int n = 0; n < 5; n++) {
    System.out.println("Hip, hip, hooray!");
}
```


<!------------------------------------ Slide -------------------------------->
# Review Question 7

What will this code print?
```Java
public class Foo {
    private String bar;
    public Foo(String bar) {
        this.bar = bar;
    }
    public boolean equals(Object other) {
        return this.bar.equals(((Foo) other).bar);
    }
    public static void main(String[] args) {
        Foo foo1 = new Foo("bar");
        Foo foo2 = new Foo("bar");
        Foo foo3 = foo1;
        System.out.println("foo1.equals(foo2): " + foo1.equals(foo2));
        System.out.println("foo1 == foo2: " + (foo1 == foo2));
        System.out.println("foo1 == foo3: " + (foo1 == foo3));
    }
}
```

<!------------------------------------ Slide -------------------------------->
# Review Question 7

Given the definition of `Foo` on previous slide and:
```Java
        Foo foo1 = new Foo("bar");
        Foo foo2 = new Foo("bar");
        Foo foo3 = foo1;
```

You have:

```sh
foo1.equals(foo2): true
foo1 == foo2: false
foo1 == foo3: true
```

<!------------------------------------ Slide -------------------------------->
# Review Question 8

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
# Review Question 8

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
# Review Question 9

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
# Review Question 9

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
# Review Question 10

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
# Review Question 10

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
# Review Question 11

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
# Review Question 11

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
