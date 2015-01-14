/**
 * This program performs the same task as CharCountSwitch.java but without
 * a switch statement.
 */
public class CharCountSwitch {

    public static void main(String[] args) {
        System.out.print("Enter a string of characters: ");
        String s = System.console().readLine();
        int digitCount = 0, punctuationCount = 0, letterCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                // Fall-through matches all digits
                digitCount++;
                break;
            case '!':
            case '?':
            case '.':
                // Fall-through matches all punctuation
                punctuationCount++;
                break;
            default:
                // Others are assumed to be letters
                letterCount++;
                // break is optional after the default case
            }
            // Will the code above provide an accurate count of letters?
        }
        System.out.printf("Your input contained %d digits, %d "
                + "punctuaion marks, and %d letters.%n",
                digitCount, punctuationCount, letterCount);
    }
}
