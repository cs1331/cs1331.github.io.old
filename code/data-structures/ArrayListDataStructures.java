import java.util.ArrayList;

public class ArrayListDataStructures {

    /**
     * LIFO data structure.
     */
    static class Stack<E> {
        private ArrayList<E> elems = new ArrayList<>();

        public void push(E item) {
            elems.add(item);
        }

        public E pop() {
            return elems.remove(elems.size() - 1);
        }

        public boolean isEmpty() {
            return elems.isEmpty();
        }
    }

    /**
     * FIFO data structure.
     */
    static class Queue<E> {
        private ArrayList<E> elems = new ArrayList<>();

        public void enqueue(E item) {
            elems.add(item);
        }

        public E dequeue() {
            return elems.remove(0);
        }

        public boolean isEmpty() {
            return elems.isEmpty();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> ints = new Stack<>();

        ints.push(1);
        ints.push(2);
        ints.push(3);

        System.out.println(ints.pop());
        System.out.println(ints.pop());
        System.out.println(ints.pop());
        System.out.println(ints.pop());

        // Queue<Integer> intq = new Queue<>();
        //
        // intq.enqueue(1);
        // intq.enqueue(2);
        // intq.enqueue(3);
        //
        // System.out.println(intq.dequeue());
        // System.out.println(intq.dequeue());
        // System.out.println(intq.dequeue());
    }
}
