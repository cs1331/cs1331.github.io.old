import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {5, 2, 4, 6, 1, 3};
        System.out.println("Unsorted aray: " + Arrays.toString(a));
        for (int j = 1; j < a.length; ++j) {
            assert isSorted(a, 0, j - 1);
            int key = a[j];
            int i = j - 1;
            while (i >= 0 && a[i] < key) {
                a[i + 1] = a[i];
                i = i - 1;
            }
            a[i + 1] = key;
        }
        System.out.println("Sorted aray: " + Arrays.toString(a));
    }

    private static boolean isSorted(int[] array, int start, int end) {
        for (int i = start; i < end; ++i) {
            if (!(array[i] < array[i + 1])) {
                return false;
            }
        }
        return true;
    }
}
