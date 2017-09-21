public class Expressions {

    public static void main(String[] args) {
        // int division -- answer may be unexpected
        float twoThirds = 2 / 3;
        System.out.println(twoThirds);

        // widening conversions are made implicitly
        double x = 1;

        // Narrowing conversions must be explicit.
        // This won't compile without explicit type cast
        int y = (int) 1.0;
    }
}
