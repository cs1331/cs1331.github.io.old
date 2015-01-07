public class Bugs {

    public static void main(String[] args) {
        String email = null;
        if (args.length > 0) {
            email = args[0];
        } else {
            System.out.println("Need command line args.");
            System.exit(0);
        }
        
        // If no command line arguments, what is args.length?
        //email = args[0];
        
        
        // What if email not assigned a value after initialization?
        int len = email.length();
        
        // What if email, an aribitrary String, is not a valid email address?
        boolean isEmailValid =
            (email.endsWith(".com")
             || email.endsWith(".org")
             || email.endsWith(".edu"))
            && containsAtSymbol(email);
    }

    /**
     * A helper method to check for the presense of the @ symbol in a String
     *
     * @param s a String
     * @return true if s contains @, false otherwise
     */
    private static boolean containsAtSymbol(String s) {
        boolean containsAt = false;
        // Can you spot the bugs here before we run the program?
        for (int i = 0; i <= s.length(); i++) {
            if (s.substring(i, i) == "@") containsAt = true;
            // What if @ is early in the string?
        }
        return containsAt;
    }
}
