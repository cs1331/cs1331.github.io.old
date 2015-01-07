import java.util.Scanner;
import java.util.InputMismatchException;

public class GuessNumber {

    public static void main(String[] args) {
        System.out.println("I'm thinking of a number between 1 and 10.");
        Scanner kbd = new Scanner(System.in);
        int number = 0;
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                System.out.print("Enter an integer: ");
                number = kbd.nextInt();
                // If nextInt() throws an exception, we won't get here
                isValidInput = true;
            } catch (InputMismatchException e) {
                // This nextLine() consumes the token that
                // nextInt() couldn't translate to an int.
                String input = kbd.nextLine();
                System.out.println(input + " is not an integer.");
                System.out.println("Try again.");
            }
        }
    }
}
