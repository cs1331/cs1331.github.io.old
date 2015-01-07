import java.util.Scanner;

public class HumanPlayer extends BlackjackPlayer {

    Scanner keyboard;

    public HumanPlayer(String name) {
        super(name);
        keyboard = new Scanner(System.in);
    }

    public Move getMove(BlackjackHand ... opponentHands) {
        System.out.print("What's your move, " + getName() 
                         + "? (H for hit, S for stand, then ENTER) ");
        String input = keyboard.nextLine();
        if (input.equals("h") || input.equals("H")) {
            return Move.HIT;
        } else {
            return Move.STAND;
        }
    }
}
