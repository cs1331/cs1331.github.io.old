import java.util.Arrays;

public class ArrayBasics {

    class Dog {
        public void speak() {
            System.out.println("Woof, woof!");
        }
    }


    public static double[][] scalarMult(double x, double[][] a) {
        double[][] result = a; // new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = x * a[i][j];
            }
        }
        return result;
    }

    public static String arrayToString(double[] a) {
        StringBuilder sb = new StringBuilder();
        for (double e: a) {
            sb.append(e + " ");
        }
        return sb.toString();
    }

    public static String arrayToString(double[][] a) {
        StringBuilder sb = new StringBuilder();
        for (double[] row: a) {
            sb.append(Arrays.toString(row));
            // for (double e: row) {
            //     sb.append(e + " ");
            // }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        double[] scores = new double[5];
        System.out.println("After double[] scores = new double[5]:");
        for (int i = 0; i < 5; ++i) {
            System.out.printf("scores[%d] = %.2f%n", i, scores[i]);
        }

        scores[0] = 89;
        scores[1] = 100;
        scores[2] = 95.6;
        scores[3] = 84.5;
        scores[4] = 91;
        scores[scores.length - 1] = 99.2;
        System.out.println("After element-by-element initialization:");
        // Note: much better way to bound loop: using scores.length
        for (int i = 0; i < scores.length; ++i) {
            System.out.printf("scores[%d] = %.2f%n", i, scores[i]);
        }


        // Using traditional for loop with index, you can update array elements
        for (int i = 0; i < scores.length; ++i) {
            scores[i] = scores[i] - 10;
        }
        System.out.println("Each element decreased by 10:");
        for (int i = 0; i < scores.length; ++i) {
            System.out.printf("scores[%d] = %.2f%n", i, scores[i]);
        }


        // For-each loop parameter is a temporary variable/read-only iterator
        for (double score: scores) {
            score = score - 10;
        }
        System.out.println("For-each doesn't allow updates to array:");
        for (int i = 0; i < scores.length; ++i) {
            System.out.printf("scores[%d] = %.2f%n", i, scores[i]);
        }

        // System.out.println("Trying scores[scores.length] = 100 causes:");
        // scores[scores.length] = 100;

        double[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Matrix:");
        System.out.println(Arrays.toString(matrix));
        double[][] doubledMatrix = scalarMult(2, matrix);
        System.out.println("Doubled Matrix:");
        System.out.println(arrayToString(doubledMatrix));
    }
}
