import java.util.Arrays;
import java.util.Random;

public class Sort {

    private static Random random;

    public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
        for (int j = 1; j < a.length; ++j) {
            assert isSorted(a, 0, j - 1);
            T key = a[j];
            int i = j - 1;
            while (i >= 0 && (a[i].compareTo(key) > 0)) {
                a[i + 1] = a[i];
                i = i - 1;
            }
            a[i + 1] = key;
        }
    }

    private static <T extends Comparable<? super T>>
            boolean isSorted(T[] array, int start, int end) {
        for (int i = start; i < end; ++i) {
            if (!(array[i].compareTo(array[i + 1]) < 0)) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] a) {
        qs(a, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>>
            void qs(T[] a, int begin, int end) {
        if (begin >= end) { // Base case: nothing to sort
            return;
        }
        int pivot = partition(a, begin, end);
        qs(a, begin, pivot - 1);
        qs(a, pivot + 1, end);
    }

    private static <T extends Comparable<? super T>>
            int partition(T[] a, int begin, int end) {
        T pivotValue = a[end];
        int i = begin - 1;
        for (int j = begin; j <= end - 1; j++) {
            if (a[j].compareTo(pivotValue) <= 0) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, end);
        return i + 1;
    }

    private static <T> void swap(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // Why isn't something like this in Arrays, like Collections.shuffle()?
    public static <T> void shuffle(T[] array) {
        if (random == null) {
            random = new Random();
        }
        int count = array.length;
        for (int i = count; i > 1; i--) {
            swap(array, i - 1, random.nextInt(i));
        }
    }

    public static void main(String[] args) {
        Integer[] a = {5, 2, 4, 6, 1, 3};
        System.out.println("Unsorted aray: " + Arrays.toString(a));
        insertionSort(a);
        System.out.println("Insertion-sorted aray: " + Arrays.toString(a));

        shuffle(a);
        System.out.println("Shuffled aray: " + Arrays.toString(a));
        quickSort(a);
        System.out.println("Quicksorted aray: " + Arrays.toString(a));

    }

}
