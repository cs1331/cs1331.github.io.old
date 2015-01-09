public class PartialIntArray {

    private int[] elements;
    private int size;


    public PartialIntArray() {
        this(10);
    }

    public PartialIntArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: "
                    + initialCapacity);
        }
        this.elements = new int[initialCapacity];
    }

    public void add(int e) {
        if (size >= elements.length) {
            int[] resizedArray = new int[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                //TODO add code here!
            }
        }

        elements[size++] = e;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            //TODO add code here!
        }
        return elements[index];
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        PartialIntArray pia = new PartialIntArray();
        pia.add(2);
        pia.add(4);
        pia.add(6);
        for (int i = 0; i < pia.size(); i++) {
            System.out.println(pia.get(i));
        }
        pia.get(10);
    }

}
