import java.util.*;
import java.util.stream.Collectors;

public class LambdaTroopers {

    // Notice that this method has the same single abstract method as
    // Comparator<Trooper>
    static interface Bar {
        int compare(Trooper a, Trooper b);
    }

    static void foo(Bar b) {
        Trooper one = new Trooper("A", true);
        Trooper two = new Trooper("Bang", true);
        // Notice how we use the parameter b: it's just an instance of a class,
        // even if that instance was created with a lambda expression
        System.out.println("Useless foo method: " + b.compare(one, two));
    }

    static void foo(Comparator<Trooper> b) {
        Trooper one = new Trooper("Baz", true);
        Trooper two = new Trooper("Bang", false);
        // Notice how we use the parameter b: it's just an instance of a class,
        // even if that instance was created with a lambda expression
        System.out.println("Useless foo method: " + b.compare(one, two));
    }


    public static void main(String[] args) {
        List<Trooper> troopers = new ArrayList<>();
        troopers.add(new Trooper("Thorny", true));
        troopers.add(new Trooper("Farva", true));
        troopers.add(new Trooper("Farva", true));
        troopers.add(new Trooper("Ursula", false));
        troopers.add(new Trooper("Rabbit", false));
        troopers.add(new Trooper("Mac", true));
        troopers.add(new Trooper("Foster", true));
        troopers.add(new Trooper("Grady", false));
        troopers.add(new Trooper("Ursula", false));
        troopers.add(new Trooper("Rando", true));


        System.out.println("Before sorting:\n" + troopers);

        // Using an instance of an anonymous inner class
        Collections.sort(troopers, new Comparator<Trooper>() {
            public int compare(Trooper a, Trooper b) {
                if (a.hasMustache() && !b.hasMustache()) {
                    return 1;
                } else if (b.hasMustache() && !a.hasMustache()) {
                    return -1;
                } else {
                    return a.getName().compareTo(b.getName());
                }
            }
        });

        // Using a lambda expression - this is equivalent to the previous
        // example using an anonymous inner class.
        Collections.sort(troopers, (Trooper a, Trooper b) -> {
            if (a.hasMustache() && !b.hasMustache()) {
                return 1;
            } else if (b.hasMustache() && !a.hasMustache()) {
                return -1;
            } else {
                return a.getName().compareTo(b.getName());
            }
        });
        System.out.println("\nAfter mustache-based sorting:\n" + troopers);

        // Since the overloaded foo() methods above both take parameters that
        // are functional interfaces, the following line would not compile
        // because javac could not unambiguously determine the target type of
        // the lambda expression
        // foo((Trooper t1, Trooper t2) -> 1);

        // Here we resolve the ambiguity in the overloaded foo() mthods by
        // casting the lambda expression
        foo((Bar) (Trooper t1, Trooper t2) ->
            t1.hasMustache() && t2.hasMustache()
                ? t1.getName().compareTo(t2.getName())
                : (t1.hasMustache() ? 1 : -1));

        /////////////////////////////////////////////////////////////////////
        // Method reference examples

        List<Trooper> spurbury = new ArrayList<>();
        spurbury.add(new Trooper("Grady", false));
        spurbury.add(new Trooper("Ursula", false));
        spurbury.add(new Trooper("Rando", true));
        spurbury.add(null);

        System.out.println("\nSpurbury officers with a null:");
        System.out.println(spurbury);

        // Class::staticMethod method reference
        spurbury.removeIf(Objects::isNull);
        System.out.println("\nSpurbury officers with nulls removed:");
        System.out.println(spurbury);


        List<Trooper> superTroopers = new ArrayList<>(troopers);
        // object::instanceMethod method reference
        superTroopers.removeIf(spurbury::contains);
        System.out.println("\nJust super troopers:");
        System.out.println(superTroopers);


        // Using a composed comparator
        // Trooper::hasMustache is a method reference to an instance method
        // It is equivalent to (Trooper e) -> e.hasMustache()
        Comparator<Trooper> byMustacheThenName =
            // Class::instanceMethod method reference
            Comparator.comparing(Trooper::hasMustache)
            .thenComparing(Trooper::getName);
        Collections.sort(troopers, byMustacheThenName);
        System.out.println("\nBy mustache, then name:\n" + troopers);
    }

}
