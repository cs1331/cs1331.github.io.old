public class ArrayParameters {

    private int[] years;

    public ArrayParameters() {
        // Note that we can't do this, because it has to be done at declaration
        // importantYears = {1968, 1990, 2012;
        years = new int[3];
        years[0] = 1968;
        years[1] = 1990;
        years[2] = 2012;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Important years: ");
        for (int year: years) {
            sb.append(year + " ");
        }
        return sb.toString();
    }

    public int[] getYears() {
        return years;
    }

    private void modifyElement(int[] array, int index, int newValue) {
        array[index] = newValue;
    }

    public static int[] copyOf(int[] sourceArray) {
        int[] newArray = new int[sourceArray.length];
        for (int i = 0; i < newArray.length; ++i) {
            newArray[i] = sourceArray[i];
        }
        return newArray;
    }

    public static String asString(int[] array) {
        StringBuffer sb = new StringBuffer();
        for (int element: array) {
            sb.append(element + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayParameters ap = new ArrayParameters();
        System.out.println("Initial values:");
        System.out.println(ap);
        System.out.println("After ap.modifyElement(ap.getYears(), 2, 2013);");
        ap.modifyElement(ap.getYears(), 2, 2013);
        System.out.println(ap);

        // To avoid modifying original array, make a copy
        int[] a  = {1, 2, 3};
        int[] b = copyOf(a);
        int[] c = a;
        c[2] = 66;
        b[2] = 42; // This doesn't modify a, becuase b is a different array
        System.out.println(asString(a));
        System.out.println(asString(b));
        System.out.println(asString(c));
    }
}
