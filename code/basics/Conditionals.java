import java.util.Scanner;

public class Conditionals {

    public static void main(String[] args) {
        System.out.print("Enter an integer: ");
        Scanner keyboard = new Scanner(System.in);
        int num = keyboard.nextInt();

        if ((num % 2) == 0) {
            System.out.printf("%d is even.%n", num);
        } else {
            System.out.printf("%d is odd.%n", num);
        }

        // Boolean expressions
        boolean numIsEven = (num % 2) == 0;

        // Notice the use of {} even for single statements -
        // - good idea always to use {}
        if (numIsEven) {
            System.out.println("I like even numbers.");
        } else {
            System.out.println("I'm ambivalent about odd numbers.");
        }

        // The if-else statements above can be combined using blocks
        if (numIsEven) {
            System.out.printf("%d is even.%n", num);
            System.out.println("I like even numbers.");
        } else {
            System.out.printf("%d is odd.%n", num);
            System.out.println("I'm ambivalent about odd numbers.");
        }

        // Beware that assignment is actually an expression.
        // An assignment has the value of the assignment.
        // This is why chained assignments work.
        System.out.println("\n************* CAUTION! *************");
        if (numIsEven = true) {
            System.out.println("This statement will always execute.");
        } else {
            System.out.println("This statement will never execute.");
        }

        System.out.println();
    }
}
