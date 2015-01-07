import java.util.Iterator;

public class DynamicArrayIterator<E> implements Iterator<E> {

    private int cursor = 0;
    private DynamicArray<E> da;

    public DynamicArrayIterator(DynamicArray<E> da) {
        this.da = da;
    }

    public boolean hasNext() {
        if (cursor >= da.size() - 1) {
            return false;
        }
        return true;
    }

    public E next() {
        E answer = da.get(cursor);
        cursor++;
        return answer;
    }

    public void remove() {
        da.remove(cursor - 1);
    }
}
