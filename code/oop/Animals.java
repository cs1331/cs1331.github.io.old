interface Named {
    String getName();
}

abstract class Animal implements Named {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void speak();
}

class Mammal extends Animal {

    public Mammal(String name) {
        super(name);
    }

    public void speak() {
        System.out.println("Hello!");
    }
}

class Dog extends Mammal {

    public Dog(String name) {
        super(name);
    }

    public void speak() {
        System.out.println("Woof, woof!");
    }
    public void wagTail() {
        System.out.println("(wags tail)");
    }
}

class Cat extends Mammal {

    public Cat(String name) {
        super(name);
    }

    public void speak() {
        System.out.println("Meow!");
    }
}

// Notice that this is the only public class in this file. What if we
// made other classes public?
public class Animals {

    public static void main(String[] args) {
        // Won't compile because it's abstract
        // Animal a = new Animal();
        Mammal fido = new Dog("Chloe");
        fido.speak();
        Dog fido2 = (Dog) fido; // Won't compile: Java won't implicitly downcast
        ((Mammal) fido).speak();

        Mammal mittens = (Mammal) new Cat("Fiona"); // Safe
        Mammal sparky = new Mammal("Bailey");
        // Compiles, but will cause a ClassCastException at run-time,
        Dog huh = (Dog) sparky;
        // // so we won't even get here.
        // huh.wagTail();
    }

}
