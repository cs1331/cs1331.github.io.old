/**
 * This program performs the same task as CharCountSwitch.java but without
 * a switch statement (and is correct).
 */
public class CharCount {

    public static void main(String[] args) {
        System.out.print("Enter a string of characters: ");
        String s = System.console().readLine();
        int digitCount = 0, punctuationCount = 0, letterCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i))) {
                digitCount++;
            } else if (Character.isLetter(s.charAt(i))) {
                letterCount++;
            } else if (Character.getType(s.charAt(i))
                            == Character.START_PUNCTUATION
                        || Character.getType(s.charAt(i))
                            == Character.END_PUNCTUATION
                        || Character.getType(s.charAt(i))
                            == Character.CONNECTOR_PUNCTUATION
                        || Character.getType(s.charAt(i))
                            == Character.DASH_PUNCTUATION
                        || Character.getType(s.charAt(i))
                            == Character.OTHER_PUNCTUATION) {
                punctuationCount++;
            }
            // Will the code above provide accurate counts?
        }
        System.out.printf("Your input contained %d digits, %d "
                          + "punctuaion marks, and %d letters.%n",
                          digitCount, punctuationCount, letterCount);
    }
}
