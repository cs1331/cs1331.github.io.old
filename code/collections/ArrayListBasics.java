import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListBasics {

    private static class Person {
        private String name;
        public Person(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        List<Person> peeps = new ArrayList<Person>();
        peeps.add(new Person("Aaron"));
        peeps.add(new Person("Evan"));
        //peeps.add(new Object());

        for (Person p: peeps) {
            System.out.println(p.getName());
        }


        // ArrayList tasks = new ArrayList();
        // tasks.add("Eat");
        // tasks.add("Sleep");
        // tasks.add("Code");

        // System.out.println("Life of a CS major:");

        // // Best way to iterate: using for-each loop
        // for (Object task: tasks) {
        //     System.out.println(task);
        // }

        // System.out.println("\nLet's be real:");
        // tasks.remove("Sleep");

        // // Another way to iterate, using iterator and while
        // Iterator tasksIter = tasks.iterator();
        // while (tasksIter.hasNext()) {
        //     Object task = tasksIter.next();
        //     System.out.println(task);
        // }

        // System.out.println("\nOK, maybe:");
        // tasks.add("Red Bull");

        // // Using iterator and for (notice we're incrementing the
        // // iterator in the body, not the for-loop header).
        // for (Iterator iter = tasks.iterator(); iter.hasNext(); ) {
        //     Object task = iter.next();
        //     System.out.println(task);
        // }

        // System.out.println("\nPerhaps in a different order:");
        // tasks.remove("Code");
        // tasks.add("Code");

        // // Using indexes and for:
        // for (int i = 0; i < tasks.size(); i++) {
        //     Object task = tasks.get(i);
        //     System.out.println(task);
        // }
        // System.out.println("\nNah, we need sleep!");
        // tasks.add(1, "Sleep");
        // for (int i = 0; i < tasks.size(); i++) {
        //     Object task = tasks.get(i);
        //     System.out.println(task);
        // }

        // System.out.println("\nOr let the computer sort it out:");
        // Collections.sort(tasks);
        // for (Object task: tasks) {
        //     System.out.println(task);
        // }
    }

}
