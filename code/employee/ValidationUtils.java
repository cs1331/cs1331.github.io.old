public class ValidationUtils {

    public static void disallowNullArguments(Object ... args) {
        boolean shouldThrowException = false;
        for (Object arg: args) {
            if (arg == null) {
                shouldThrowException = true;
            }
        }
        if (shouldThrowException) {
            String msg = "null arguments not allowed. ";
            throw new IllegalArgumentException(msg);
        }
    }

    public static void disallowZeroesAndNegatives(double ... args) {
        boolean shouldThrowException = false;
        String nonPositives = "";
        for (double arg: args) {
            if (arg <= 0.0) {
                shouldThrowException = true;
                nonPositives += arg + " ";
            }
        }
        if (shouldThrowException) {
            String msg = "Following arguments were <= 0: " + nonPositives;
            throw new IllegalArgumentException(msg);
        }
    }
}
