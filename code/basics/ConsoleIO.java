import java.io.Console;

public class ConsoleIO {
    public static void main(String[] args) {
        Console console = System.console();
        console.printf("Gimme input: ----- ");
        String input = console.readLine();
        System.out.println("input=" + input);
        
    }
}
