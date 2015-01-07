public class ShortCircuit {

    private static int counter = 0;
    
    private static boolean incrementCounter() {
        counter++;
        return true;
    }

    public static void main(String args[]) {
        boolean a = true;
        boolean b = false;
        if (a || incrementCounter()) {
            System.out.println("Evaluated (a !! incrementCounter()).");
        }
        System.out.println("Counter = " + counter);
        if (a && incrementCounter()) {
            System.out.println("Evaluated (a && incrementCounter()).");
        }
        System.out.println("Counter = " + counter);
    }
}
