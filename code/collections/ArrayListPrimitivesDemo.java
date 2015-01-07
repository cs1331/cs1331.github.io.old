import java.util.ArrayList;

public class ArrayListPrimitivesDemo {

    public static void main(String[] args) {
        ArrayList ints = new ArrayList();
        ints.add(new Integer(42));
        ints.add(new Integer(66));
        ints.add(new Double(2.2));
        // With an untyped collection, Java will auto-box when adding
        ints.add(99);
        System.out.println(ints);

        // However, autoboxing doesn't happen when retrieving
        // from an untyped collection
        // int num = ints.get(0); // won't compile

        // So the old-style way is to cast it to wrapper type, then unboxing
        // is done on the casted wrapper object
        // This compiles and works at run-time
        int num = (Integer) ints.get(0);
        System.out.println(num);

        // This compiles but causes a ClassCastException at run-time
        // because we have a Double instance at index 2
        int num2 = (int) (double) (Double) ints.get(2);
        System.out.println(num2);
    }

}
