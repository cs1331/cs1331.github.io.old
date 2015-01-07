import java.util.*;
import java.util.stream.*;

public class Streams {

    static class Pair<T, U> {
        public final T _1;
        public final U _2;
        public Pair(T a, U b) {
            _1 = a; _2 = b;
        }
        @Override public String toString() {return "(" + _1 + ", " + _2 + ")";}
    }

    static int factorial(int n) {
        if (n < 2) {
            return 1;
        } else {
            return IntStream.range(1, n+1).reduce(1, (a, b) -> a * b);
        }
    }


    public static void main(String[] args) {
        List<Double> scores = Arrays.asList(80.0, 90.0, 100.0);
        List<Double> weights = Arrays.asList(.1, .2, .7);
        List<Pair<Double, Double>> zipped =new ArrayList<>();
        for (Iterator<Double> si = scores.iterator(), wi = weights.iterator();
             si.hasNext() && wi.hasNext();
             zipped.add(new Pair<Double, Double>(si.next(), wi.next())));

        System.out.println(zipped);

        List<String> words =
            Arrays.asList("Hello", "World", "Welcome", "To", "Java", "8");
        System.out.println("words: " + words);
        double avg = words.stream()
            .map(String::length)
            .reduce(0, (a, b) -> a + b) / (0.0 + words.size());
        System.out.println("avg: " + avg);

        int longest = words.stream()
            .map(String::length)
            .reduce(0, (a, b) -> (a > b) ? a : b);
        System.out.println("longest: " + longest);

        List<String> longWords = words.stream()
            .filter(word -> word.length() > avg)
            .collect(Collectors.toList());
        System.out.println(longWords);

        System.out.println("factorial(1): " + factorial(1));
        System.out.println("factorial(2): " + factorial(2));
        System.out.println("factorial(3): " + factorial(3));
        System.out.println("factorial(10): " + factorial(10));

    }
}
