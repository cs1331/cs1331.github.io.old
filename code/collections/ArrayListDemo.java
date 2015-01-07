import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {

    static abstract class Person {
        public String name;
        public Person(String name) {
            this.name = name;
        }
    }

    static class LostPerson extends Person {
        public LostPerson(String name) { super(name); }
    }

    static class FoundPerson extends Person {
        public FoundPerson(String name) { super(name); }

        public boolean equals(Object other) {
            if (this == other) return true;
            if (!(other instanceof Person)) return false;
            return ((Person) other).name.equals(this.name);
        }
    }

    public static void main(String[] args) {
        ArrayList<Person> peeps = new ArrayList<>();
        // Notice that we can put subclasses of Person in peeps
        Person wilma = new FoundPerson("Wilma");
        peeps.add(wilma);
        peeps.add(new FoundPerson("Fred"));
        peeps.add(new LostPerson("Barney"));

        Iterator<Person> piter = peeps.iterator();
        while (piter.hasNext()) {
            System.out.println(piter.next());
        }
        piter.next();

        // 1:
        // Will print true becuase the default implementation of equals
        // uses == for object identity, and we're using the same reference
        // that's stored in peeps
        System.out.println("1: "+peeps.contains(wilma));

        // The rest of the examples each use new objects, so can't rely
        // on object identity

        // 2:
        // Will print true because we're querying with a FoundPerson,
        // which has a properly implemented equals()
        System.out.println("2: "+peeps.contains(new FoundPerson("Fred")));

        // 3:
        // Will print false because we're querying with a LostPerson,
        // which does not hashave a properly implemented equals()
        System.out.println("3: "+peeps.contains(new LostPerson("Fred")));

        // 4:
        // Will print true because we're querying with a FoundPerson,
        // which has a properly implemented equals().
        // Notice it doesn't matter that the object in the list is of
        // type LostPerson.  The query object's equals() method is used.
        System.out.println("4: "+peeps.contains(new FoundPerson("Barney")));

        // 5:
        // Will print false because we're querying with a LostPerson,
        // which does not hashave a properly implemented equals()
        System.out.println("5: "+peeps.contains(new LostPerson("Barney")));
    }

}
