/**
 * Run from the console, this program reports whether the first command line
 * argument is a palindrome.
 */
public class Palindrome {

    public static void main(String[] args) {
        // Look up java.lang.String and java.util.regex.Pattern
        // Note that the extra \ in "\\s" is necessary to escape the '\'

        // Example of method chaining: each method returns a String,
        // on which we call another method.
        String candidate = args[0].toLowerCase().replaceAll("\\s", "");
        boolean isPalindrome = true;
        // Note example of splitting large for header across lines
        for (int i = 0, j = candidate.length() - 1;
                (j > 0) && (isPalindrome);
                i++, j--) {
            if (candidate.charAt(i) != candidate.charAt(j)) {
                isPalindrome = false;
            }
        }
        String verdict = isPalindrome ? " is " : " is not ";
        System.out.println(candidate + verdict + "a palindrome.");
    }
}
