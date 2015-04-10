import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<E> implements Iterable<E> {

    private class DynamicArrayIterator implements Iterator<E> {
        private int cursor = 0;

        public boolean hasNext() {
            return cursor <= lastIndex;
        }

        public E next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
            E answer = get(cursor++);
            return answer;
        }

        public void remove() {
            DynamicArray.this.remove(cursor - 1);
        }
    }

    private class ReverseDynamicArrayIterator implements Iterator<E> {
        private int cursor = size() - 1;

        public boolean hasNext() {
            return cursor >= 0;
        }

        public E next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
            E answer = get(cursor--);
            return answer;
        }

        public void remove() {
            DynamicArray.this.remove(cursor + 1);
        }
    }


    private Object[] elements;
    private int lastIndex;

    public DynamicArray() {
        this(10);
    }

    public DynamicArray(int capacity) {
        this.elements = new Object[capacity];
        lastIndex = -1;
    }

    public Iterator<E> iterator() {
        return new DynamicArrayIterator();
    }

    public Iterator<E> reverseIterator() {
        return new ReverseDynamicArrayIterator();
    }

    public void add(E item) {
        if (lastIndex == elements.length - 1) {
            // Note: this is simplistic.  In production code we'd want to
            // guard against overflow
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
        elements[++lastIndex] = item;
    }

    public E get(int index) {
        if ((index < 0) || (index > lastIndex)) {
            throw new IndexOutOfBoundsException(new Integer(index).toString());
        }
        return (E) elements[index];
    }

    public void set(int index, E item) {
        elements[index] = item;
    }

    public int size() {
        return lastIndex + 1;
    }

    public E remove(int index) {
        E removedItem = (E) elements[index];
        for (int i = index + 1; i <= lastIndex; i++) {
            elements[i - 1] = elements[i];
        }
        lastIndex--;
        return removedItem;
    }

    public static void main(String[] args) {
        DynamicArray<String> da = new DynamicArray<>(2);
        da.add("Stan");
        da.add("Kenny");
        // Automatically growing capacity
        da.add("Kyle");
        da.add("Butters");
        da.add("Cartman");
        System.out.println("da contents:");
        // Using indexed-based access:
        for (int i = 0; i < da.size(); ++i) {
            System.out.println(da.get(i));
        }
        System.out.println("You killed Kenny!");
        Iterator daIter = da.iterator();
        while (daIter.hasNext()) {
            if (daIter.next().equals("Kenny")) {
                daIter.remove();
            }
        }

        // Using iterator:
        for (String e: da) {
            System.out.println(e);
        }


        System.out.println("Using reverseIterator:");
        Iterator revIter = da.reverseIterator();
        while (revIter.hasNext()) {
            System.out.println(revIter.next());
        }


    }
}
