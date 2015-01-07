/**
 * This program performs the same task as CharCountSwitch.java but without
 * a switch statement.
 */
public class CharCountIf {

    public static void main(String[] args) {
        System.out.print("Enter a string of characters: ");
        String s = System.console().readLine();
        int digitCount = 0, punctuationCount = 0, letterCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0'
                    || s.charAt(i) == '1'
                    || s.charAt(i) == '2'
                    || s.charAt(i) == '3'
                    || s.charAt(i) == '4'
                    || s.charAt(i) == '5'
                    || s.charAt(i) == '6'
                    || s.charAt(i) == '7'
                    || s.charAt(i) == '8'
                    || s.charAt(i) == '9') {
                digitCount++;
            } else if (s.charAt(i) == '!'
                    || s.charAt(i) == '?'
                    || s.charAt(i) == '.') {
                punctuationCount++;
            } else {
                letterCount++;
            }
            // Will the code above provide an accurate count of letters?
        }
        System.out.printf("Your input contained %d digits, %d "
                          + "punctuaion marks, and %d letters.%n",
                          digitCount, punctuationCount, letterCount);
    }
}
