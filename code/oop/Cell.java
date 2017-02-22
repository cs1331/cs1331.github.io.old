public class Cell<T> {

    private T current;

    public Cell(T init) {
        current = init;
    }

    public T get() { return current; }

    public void set(T newVal) { current = newVal; }

    public static void main(String[] args) {
        // Parameterized types are invaiant ...
        Cell<String> c1 = new Cell<String>("abc");

        // So even though String is a subclass of Object,
        // Cell<String> is not a subclass of Cell<Object>,
        // so this line won't compile:
        //Cell<Object> c2 = c1;

        // If the above were allowed, you could have this unsafe code:
        // c2.set(1);
        // String s = c1.get();
        // Compile-time checking prevents potential run-time errors like this.


        // Invariance of generic types is necessary because of type erasure --
        // type arguments are not reified, that is, not stored at runtime (and
        // therefore can't be checked at runtime). But as the example above
        // shows, this is a good thing. Unfortunately, Java Arrays, whose
        // element types *are* reified, are covariant.
        // So this compiles:
        String[] a1 = { "abc" };
        Object[] a2 = a1;

        // But this line produces a run-time ArrayStoreException when Integer
        // is found to be incompatible with the element type String:
        a2[0] = new Integer(42);
        String s = a1[0];

        // So why are Java arrays covariant? So that earlier, pre-generics
        // versions of Java could have "generic" methods like this:
        // void sort(Object[] a, Comparator cmp);

        // Covariant arrays are no longer necessary with generics, but arrays
        // are still covariant to maintain backward compatibility.
    }
}
