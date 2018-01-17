import java.util.Random;
import java.util.Scanner;

public class WordGuess {

    static final String[] CANDIDATES = {"cat", "dad", "dog", "mom", "rat"};

    public static void main(String[] args) {
        String secretWord = args.length > 0
            ? CANDIDATES[Integer.parseInt(args[0])]
            : CANDIDATES[new Random().nextInt(CANDIDATES.length)];

        // Your code goes here:

    }
}
