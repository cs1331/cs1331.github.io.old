import java.util.Random;
import java.util.Scanner;

public class WordGuess {

    static final String[] candidateWords = {"cat", "dad", "dog", "mom", "rat"};

    public static void main(String[] args) {
        String secretWord = args.length > 0
            ? candidateWords[Integer.parseInt(args[0])]
            : candidateWords[new Random().nextInt(candidateWords.length)];

        // Your code goes here:

    }
}
