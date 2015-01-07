import java.util.Random;

public class GuessNumber {

    public static void main(String[] args) {
        System.out.println("I'm thinking of a number from 1 and 10.");
        int number = new Random().nextInt(10) + 1;
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.print("Enter an integer from 1 to 10: ");
            String input = System.console().readLine();
            // What if we tested the number before testing for "quit"?
            if (input.trim().equalsIgnoreCase("quit")) {
                System.out.print("Lame. ");
                shouldContinue = false;
            } else if (Integer.parseInt(input) == number) {
                System.out.print("Yay! You guessed it. ");
                shouldContinue = false;
            } else {
                System.out.println("Nope.  Keep guessing!");
            }
        }
        System.out.printf("It was %d.%n", number);
    }
}
