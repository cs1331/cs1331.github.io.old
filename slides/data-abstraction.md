% Data Abstraction
% CS 1331

# Data Abstraction

An abstraction captures the essence of a concept by ignoring details that are irrelevant to a particular application.

- Process abstraction - functions, methods
- Data abstraction - encapsulation of data with the operations defined on the data
- A particular data abstraction is called an **abstract data type**.

In each case, an abstraction hides details --- details of a process or details of a data structure.


> Abstraction is selective ignorance.
-- Andrew Koenig (C++ Guru)

<!--------------------------------- Slide ----------------------------------->
# A Complex Number ADT

**ADT: Complex**
Data:

- **real: double** the real part of a complex number
- **imaginary: double** the imaginary part of a complex number

Operations:

- **new** - construct a new complex number
- **plus** - add one complex number to another, yielding a new complex number

An ADT is *abstract* because the data and operations of the ADT are declared independently of how they are implemented.  We say that an ADT *encapsulates* the data and the operations on the data.

<!--------------------------------- Slide ----------------------------------->
# Data Abstractions with Classes

Java provides langauge suppport for defining ADTs in the form of classes.

A class is a blueprint for objects.  A class definition contains

- instance variables, a.k.a. member variables or fields -- the state, or data of an object
- methods, a.k.a. member functions or messages -- the operations defined on objects of the class

We *instantiate* or *construct* an object from a class.

<!--------------------------------- Slide ----------------------------------->
# Complex Number ADT in Java

```Java
public class Complex {
    // These are the data of the ADT

    private double real;
    private double imaginary;

    // These are the operations of the ADT

    public Complex(double aReal, double anImaginary) {
        real = aReal;
        imaginary = anImaginary;
    }

    public Complex plus(Complex other) {
        double resultReal = this.real + other.real;
        double resultImaginary = this.imaginary + other.imaginary;
        return new Complex(resultReal, resultImaginary);
    }
}
```
Source: http://introcs.cs.princeton.edu/java/33design/

<!--------------------------------- Slide ----------------------------------->
# Reference Variables

Consider the following code:
```Java
Complex a = new Complex(1.0, 2.0);
Complex b = new Complex(3.0, 4.0);
Complex c = a.plus(b);
```

`a`, `b`, and `c` are *reference* variables of type `Complex`.  Reference variables have one of two values:


- the address of an object in memory (in this case an instance of `Complex`), or
- `null`, meaning the variable references nothing.

<!--------------------------------- Slide ----------------------------------->
# Invoking Constructors

The line:
```Java
Complex a = new Complex(1.0, 2.0);
```

invokes the `Complex` constructor, passing arguments `1.0` and `2.0` as in this pseudo-Java:

```Java
public Complex(aReal=1.0, anImaginary=2.0) {
    real = 1.0;
    imaginary = 2.0;
}
```

which *instantiates* a `Complex` object and stores its address in the variable `a`

<!--------------------------------- Slide ----------------------------------->
# Visualizing Objects

The object creation expression `new Complex(1.0, 2.0)` applies the blueprint in the `Complex` class definition:

<center>
<img src="complex-class.png" />
</center>

to the constructor arguments `(1.0, 2.0)` to create an instance of `Complex`:

<center>
<img src="complex-instance.png" />
</center>

<!--------------------------------- Slide ----------------------------------->
# Visualizing Reference Variables


We can assign this object to a reference variable, e.g.,`Complex a = new Complex(1.0, 2.0)`:

<center>
<img src="complex-reference.png" />
</center>


<!--------------------------------- Slide ----------------------------------->
# Invoking Methods on Objects


The line:
```Java
Complex c = a.plus(b);
```
invokes the `plus` method on the `a` object, passing the `b` object as an argument, which binds the object referenced by `b` to the parameter `other`:
```Java
a.plus(other=b) {
  double resultReal = this.real + b.real; // 1.0 + 3.0
  double resultImaginary = this.imaginary + b.imaginary; // 2.0 + 4.0
  return new Complex(resultReal, resultImaginary);
}
```
which returns a new `Complex` object and assigns its address to the  reference variable `c`.


<!--------------------------------- Slide ----------------------------------->
# Using the `Complex` Class

Users, or *clients* of the `Complex` class can then write code like this:
```Java
Complex a = new Complex(1.0, 2.0);
Complex b = new Complex(3.0, 4.0);
Complex c = a.plus(b);
```

without being concerned with `Complex`'s implementation (which could use polar form, for example).

Clients (i.e., users) of the `Complex` class need only be concerned with its interface, or *API* (application programmer interface) -- the public methods of the class.

<!--------------------------------- Slide ----------------------------------->
# Visualizing `Complex` Operations

```Java
Complex a = new Complex(1.0, 2.0);
Complex b = new Complex(3.0, 4.0);
Complex c = a.plus(b);
```

After the code above we have the following `Complex` objects in memory:
<center>
<img src="complex-abc.png" />
</center>