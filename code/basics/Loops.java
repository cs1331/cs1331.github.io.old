public class Loops {

    public static void main(String[] args) {
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("Enter a string of alphanumeric characters"
                    + " (exit to quit):");
            String input = System.console().readLine();
            int digitCount = 0, letterCount = 0;
            for (int i = 0; i < input.length(); ++i) {
                char c = input.charAt(i);
                if (Character.isDigit(c)) {
                    digitCount++;
                }
                if (Character.isAlphabetic(c)) {
                    letterCount++;
                }
            }
            System.out.printf("Input contained %d digits and %d letters.%n",
                    digitCount, letterCount);
            shouldContinue = (input.equalsIgnoreCase("exit")) ? false : true;
        }

        for (int i = 0; i < 10; ++i) {
            System.out.println("Meow!");
        }

        String mystery = "mnerigpaba";
        String solved = "";
        int len = mystery.length();
        for (int i = 0, j = len - 1; i < len / 2; ++i, --j) {
            solved = solved + mystery.charAt(i) + mystery.charAt(j);
        }
        System.out.println(solved);

        // If you uncomment either of these for-ever loops,
        // you'll have to use Ctrl-C to stop the program.

        //for (;;) {
        // ever
        //}

        // while (true} {
        //     // forever
        // }
    }
}
