public class Fac {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println("facLoop(" + n + ")=" + facLoop(n));
        System.out.println("facTail(" + n + ")=" + facTail(n));
        System.out.println("fac(" + n + ")=" + fac(n));
    }

    /**
     * The factorial of n is n * facotrial of n-1 for n > 1, otherwise 1.
     */
    public static int fac(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fac(n - 1);
        }
    }

    public static int facLoop(int n) {
        int factorial = 1;
        for (int x = n; x > 0; x--) {
            factorial *= x;
        }
        return factorial;
    }

    /**
     * A tail recursive factorial function using a recursive helper method
     * to create the iterations.
     */
    public static int facTail(int n) {
        return facIter(n, 1);
    }

    /**
     * Designed to be called by facIter.  accum accumulates the answer as
     * n decrements to the base case.
     */
    private static int facIter(int n, int accum) {
        if (n <= 1) {
            return accum;
        } else {
            return facIter(n - 1, n * accum);
        }
    }

    /*
    Iterative process
    facIter(5);
    facIter(4, 5);
    facIter(3, 20);
    facIter(2, 60);
    facIter(1, 120);
    120

    Recursive process
    fac(5);
    5 * fac(4);
    5 * 4 * fac(3);
    5 * 4 * 3 * fac(2);
    5 * 4 * 3 * 2 *fac(1);
    5 * 4 * 3 * 2 * 1;
    5 * 4 * 3 * 2;
    5 * 4 * 6;
    5 * 24;
    120;
    */
}
