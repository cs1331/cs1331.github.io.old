import java.util.ArrayList;

public class ArrayListEqualsDemo {

    abstract static class Person {
        public String name;
        public Person(String name) {
            this.name = name;
        }

        // Here just to show covariant returns
        public Object covariantReturn() { return new Object(); }
    }

    static class LostPerson extends Person {
        public LostPerson(String name) { super(name); }

        @Override
        public LostPerson covariantReturn() { return this; }
    }

    // static class SubLostPerson extends LostPerson {
    //     public SubLostPerson(String name) { super(name); }
    //
    //     @Override
    //     public Person covariantReturn() { return this; }
    // }

    static class FoundPerson extends Person {
        public FoundPerson(String name) { super(name); }

        public boolean equals(Object other) {
            if (this == other) { return true; }
            if (!(other instanceof Person)) { return false; }
            return ((Person) other).name.equals(this.name);
        }
    }

    static class OverloadedPerson extends Person {
        public OverloadedPerson(String name) { super(name); }

        public boolean equals(OverloadedPerson other) {
            if (this == other) { return true; }
            if (!(other instanceof OverloadedPerson)) { return false; }
            return ((OverloadedPerson) other).name.equals(this.name);
        }
    }

    // static class NonCompilingPerson extends Person {
    //     public NonCompilingPerson(String name) { super(name); }
    //
    //     /**
    //      * This method won't compile because int is not a subtype of boolean.
    //      */
    //     public int equals(Object other) {
    //         if (this == other) return 1;
    //         if (!(other instanceof Person)) return 0;
    //         return ((Person) other).name.equals(this.name) ? 1 : 0;
    //     }
    // }

    public static void main(String[] args) {
        ArrayList peeps = new ArrayList();
        // Notice that we can put subclasses of Person in peeps
        Person wilma = new LostPerson("Wilma");
        peeps.add(wilma);
        peeps.add(new FoundPerson("Fred"));
        peeps.add(new LostPerson("Barney"));
        peeps.add(new OverloadedPerson("Bam-Bam"));

        System.out.println("peeps contains:");
        System.out.println("wilma (a refrence to a LostPerson)");
        System.out.println("new FoundPerson(\"Fred\")");
        System.out.println("new LostPerson(\"Barney\")");
        System.out.println("new OverloadedPerson(\"Bam-Bam\")");

        System.out.println("\nIn each case below, the 'right' answer is true.");
        // 1:
        // Will print true because the default implementation of equals
        // uses == for object identity, and we're using the same reference
        // that's stored in peeps
        System.out.println("\n1: Querying with alias: ");
        System.out.println("peeps.contains(wilma)) == "
                           + peeps.contains(wilma));
        System.out.println("\n1.1: Querying with equal-valued distinct object: ");
        System.out.println("peeps.contains(new LostPerson(\"Wilma\")) == "
                           + peeps.contains(new LostPerson("Wilma")));

        // The rest of the examples each use new objects, so can't rely
        // on object identity
        System.out.println("\nRemaining examples query with equal-valued "
                           + "distinct objects.");

        // 2:
        // Will print true because we're querying with a FoundPerson,
        // which has a properly implemented equals()
        System.out.println("\nSearching for FoundPerson in list.");
        System.out.println("\n2: Querying with FoundPerson object: ");
        System.out.println("peeps.contains(new FoundPerson(\"Fred\")) == "
                           + peeps.contains(new FoundPerson("Fred")));

        // 3:
        // Will print false because we're querying with a LostPerson,
        // which does not hashave a properly implemented equals()
        System.out.println("\n3: Querying with LostPerson: ");
        System.out.println("peeps.contains(new LostPerson(\"Fred\")) == "
                           + peeps.contains(new LostPerson("Fred")));

        // 4:
        // Will print true because we're querying with a FoundPerson,
        // which has a properly implemented equals().
        // Notice it doesn't matter that the object in the list is of
        // type LostPerson.  The query object's equals() method is used.
        System.out.println("\nSearching for LostPerson in list.");
        System.out.println("\nNotice that contains method uses query object's"
                           + " equals method.");
        System.out.println("4: Querying with FoundPerson: "
                           + peeps.contains(new FoundPerson("Barney")));

        // 5:
        // Will print false because we're querying with a LostPerson,
        // which does not have a properly implemented equals()
        System.out.println("\n5: Querying with LostPerson: ");
        System.out.println("peeps.contains(new LostPerson(\"Barney\")) == "
                           + peeps.contains(new LostPerson("Barney")));

        // 6:
        // Will print false because OverloadedPerson does not override equals,
        // rather OverloadedPerson overloads equals.
        System.out.println("\n6: Querying with OverloadedPerson: ");
        System.out.println("peeps.contains(new OverloadedPerson(\"Bam-Bam\"))== "
                           + peeps.contains(new OverloadedPerson("Bam-Bam")));
    }

}
