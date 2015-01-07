import java.util.Random;

public class RandomPlayer extends BlackjackPlayer {

    public RandomPlayer(String name) {
        super(name);
    }

    public Move getMove(BlackjackHand ... opponentHands) {
        if (hand.value() >= 21) return Move.STAND;
        Random rand = new Random();
        if (rand.nextInt(10) < 3) {
            return Move.HIT;
        } else {
            return Move.STAND;
        }
    }
}
