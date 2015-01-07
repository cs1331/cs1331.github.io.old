public class Animals {

    public static abstract class Animal {
        public abstract void speak();
    }

    public static class Mammal extends Animal {
        public void speak() {
            System.out.println("Hello!");
        }
    }
    public static class Dog extends Mammal {
        public void speak() {
            System.out.println("Woof, woof!");
        }
        public void wagTail() {
            System.out.println("(wags tail)");
        }
    }
    public static class Cat extends Mammal {
        public void speak() {
            System.out.println("Meow!");
        }
    }

    public static void main(String[] args) {
        Mammal fido = new Dog();
        fido.speak();
        // Dog fido2 = fido; // Won't compile: Java won't implicitly downcast
        ((Mammal) fido).speak();

        Mammal mittens = (Mammal) new Cat(); // Safe
        Mammal sparky = new Mammal();
        // Compiles, but will cause a ClassCastException at run-time,
        Dog huh = (Dog) sparky;
        // so we won't even get here.
        huh.wagTail();
    }

}
