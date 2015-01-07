import java.util.Random;

public class Greetings {

    private static final String[] GREETINGS = {"Hi", "Hello", "W'sup"};

    public static void main(String[] args) {
        Random rand = new Random();
        int greeting = rand.nextInt(GREETINGS.length);
        System.out.print(GREETINGS[greeting]);
        if (args.length > 0) { // What if we didn't include this check?
            System.out.print(", " + args[0]);
        }
        System.out.println("!");
    }
}
