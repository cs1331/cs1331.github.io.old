public class ConsoleOutput {

    public static void main(String[] args) {
        // All these will be printed on one line
        System.out.print("A ");
        System.out.print("wagon ");
        System.out.print("full ");
        System.out.println("of ...");

        // This will be printed on a new line because the previous output
        // method was println (instead of print)
        System.out.println("pancakes!\n");

        // You can use \n to add a newline so printf acts like println
        System.out.printf("%d %s.\n", 7, "Samurai");

        // Better to use %n tahn \n because %n is platform-independent
        System.out.printf("I like %5.3f.%n%n", Math.PI);

        // Notice that you can use any String-valued expression
        // for the format string
        System.out.printf("%e is how Java prints the scientific"
                          + " notation equivalent of %f.\n", .001, .001);
        String msgWithENotation = "%e is how Java prints the scientific"
            + " notation equivalent of %f.%n%n";
        // Notice that need to write 1000f (f means floating point constant)
        // because  the %e conversion takes a floating point number
        System.out.printf(msgWithENotation, 1000f, 1000f);

        // With no field width specifier, %f defaults to 6 significant digits
        double x = 42.0000001;
        System.out.printf("Where's the 1 in %f?\n", x);

        // Use a field width specifier if you need more
        System.out.printf("There it is: %.7f.%n%n", x);

        // Formatted fields are right-justified by default
        String scoreLine = "%12s %2d%n";
        System.out.printf(scoreLine, "Georgia Tech", 21);
        System.out.printf(scoreLine, "USC", 7);
        System.out.println();

        // Add a - after the % to left-justify a field
        String betterScoreLine = "%-12s %2d%n";
        System.out.printf(betterScoreLine, "Georgia Tech", 21);
        System.out.printf(betterScoreLine, "USC", 7);
    }
}
