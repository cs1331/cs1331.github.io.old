import java.time.*;
import java.util.*;
import java.util.stream.*;

public class Search {

    public static int linearSearch(Integer[] array, Integer value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) { return i; }
        }
        return -1;
    }

    public static int binarySearchLoop(Integer[] array, int queryValue) {
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            int middle = (lo + hi)/2;
            if (array[middle] == queryValue) {
                return middle;
            }
            if (array[middle] > queryValue) {
                hi = middle - 1;
            } else {
                lo = middle + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(Integer[] array, int queryValue) {
        return bsHelper(array, queryValue, 0, array.length - 1);
    }

    private static int bsHelper(Integer[] array, int queryValue, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int middle = (lo + hi)/2;
        if (queryValue == array[middle]) {
            return middle;
        } else if (queryValue > array[middle]) {
            return bsHelper(array, queryValue, middle + 1, hi);
        } else {
            return bsHelper(array, queryValue, lo, middle - 1);
        }
    }

    public static <T> int binarySearch(T[] array, T queryValue,
                                      Comparator<? super T> c) {
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            int middle = (lo + hi)/2;
            if (c.compare(array[middle], queryValue) == 0) {
                return middle;
            }
            if (c.compare(array[middle], queryValue) > 0) {
                hi = middle - 1;
            } else {
                lo = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int size = 2000000;
        Integer[] randoms = Stream.generate(random::nextInt)
            .limit(size)
            .collect(Collectors.toList())
            .toArray(new Integer[0]);
        int queryValue = random.nextInt();
        Instant start = Instant.now();
        int index = linearSearch(randoms, queryValue);
        Instant end = Instant.now();
        System.out.printf("linearSearch of %d element array took %d ms%n",
                          size, Duration.between(start, end).toMillis());

        start = Instant.now();
        index = binarySearch(randoms, queryValue);
        end = Instant.now();
        System.out.printf("binarySearch of %d element array took %d ms%n",
                          size, Duration.between(start, end).toMillis());

        // Integer[] ints = {4,7,5,6,3,9,2,1,8};
        // System.out.println(Arrays.toString(ints));
        // Arrays.sort(ints);
        // System.out.println(Arrays.toString(ints));
        // // When testing, test the edge cases
        // System.out.println("Where is 4? " + binarySearchLoop(ints, 4));
        // System.out.println("Where is 8? " + binarySearchLoop(ints, 8));
        // System.out.println("Where is 5? " + binarySearchLoop(ints, 5));
        // System.out.println("Now with recursive binarySearch:");
        // System.out.println("Where is 4? " + binarySearch(ints, 4));
        // System.out.println("Where is 8? " + binarySearch(ints, 8));
        // System.out.println("Where is 5? " + binarySearch(ints, 5));
        //
        // GtStudent[] gtStuds = {
        //     new GtStudent("Von Neumann", Major.CMPE),
        //     new GtStudent("Sakaguchi", Major.CM),
        //     new GtStudent("Turing", Major.CS),
        //     new GtStudent("Bernoulli", Major.AE),
        //     new GtStudent("Maxwell", Major.EE),
        //     new GtStudent("Church", Major.CS),
        //     new GtStudent("Wright", Major.ARCH),
        //     new GtStudent("Sandiego", Major.IE)
        // };
        // System.out.println("Unsorted studs: " + Arrays.toString(gtStuds));
        // Comparator<GtStudent> studComparator = new Comparator<GtStudent>() {
        //     public int compare(GtStudent a, GtStudent b) {
        //         if (!a.getMajor().equals(b.getMajor())) {
        //             return a.getMajor().compareTo(b.getMajor());
        //         } else {
        //             return a.getName().compareTo(b.getName());
        //         }
        //     }
        // };
        // Arrays.sort(gtStuds, studComparator);
        // System.out.println("Sorted studs: " + Arrays.toString(gtStuds));
        // GtStudent sandiego = new GtStudent("Sandiego", Major.IE);
        // System.out.println("Where is Sandiego: "
        //     + binarySearch(gtStuds, sandiego, studComparator));
    }
}
