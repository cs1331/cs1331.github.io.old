public class Bugs {

    /**
     * A helper method that sends an email message.
     */
    private static void sendEmail(String body, String recipient) {
        // Pretend we have code that sends email here.
    }


    public static void main(String[] args) {
        // If no command line arguments, what is args.length?
        email = args[0];
        
        // What if email not assigned a value after initialization?
        int len = email.length();
        
        // What if email, an aribitrary String, is not a valid email address?
        sendEmail("Hi!", email);
    }
}
