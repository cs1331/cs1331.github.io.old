public abstract class AbstractStack<E> implements Stack<E> {

    public final E pop() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return removeNext();
    }

    protected abstract E removeNext();
}
