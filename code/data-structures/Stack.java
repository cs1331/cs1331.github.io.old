public interface Stack<E> {

    public void push(E item);

    public E pop() throws java.util.EmptyStackException;

    public boolean isEmpty();
}
