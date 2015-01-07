import java.util.Random;

public class Greeter {

    private static final String[] GREETINGS = {"Hi", "Hello", "W'sup"};

    private String greetee;

    public Greeter(String name) {
        greetee = name;
    }

    public String greet() {
        Random rand = new Random();
        int index = rand.nextInt(GREETINGS.length);
        String greeting = GREETINGS[index];
        greeting += ", " + greetee +"!";
        return greeting;
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter("bob");
        String greeting = greeter.greet();
        System.out.println(greeting);
    }
}
