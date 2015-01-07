import java.util.Scanner;

public class Blackjack {

    private static void dealFaceDown(Deck deck, Player player) {
        player.getHand().addFaceDown(deck.draw());
    }

    private static void dealFaceUp(Deck deck, Player player) {
        player.getHand().addFaceUp(deck.draw());
    }

    private static void printHands(BlackjackHand ... hands) {
        for (BlackjackHand hand: hands) {
            hand.toString();
        }
    }

    public static void main(String[] args) {
        Player dealer = new RandomPlayer("Dealer");
        Scanner kbd = new Scanner(System.in);
        System.out.print("What's your name? ");
        String name = kbd.nextLine();
        Player player = new HumanPlayer(name);
        Deck deck = new Deck();
        deck.shuffle();
        dealFaceDown(deck, dealer);
        dealFaceDown(deck, player);
        dealFaceUp(deck, dealer);
        dealFaceUp(deck, player);
        boolean shouldKeepPlaying = true;
        while (shouldKeepPlaying) {
            System.out.println("Here's the table:");
            printHands(dealer.getHand(), player.getHand());
            Player.Move playerMove = player.getMove(dealer.getHand());
            dealer.getMove(player.getHand());
            if (playerMove == Player.Move.STAND) {
                shouldKeepPlaying = false;
            }
        }
    }
}
