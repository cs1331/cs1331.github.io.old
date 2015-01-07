import java.util.Scanner;

public class BlackjackGame {

    private static void printHands(BlackjackPlayer ... players) {
        for (BlackjackPlayer player: players) {
            System.out.println(player + "'s hand: " + player.getHand());
        }
    }

    public static void main(String[] args) {
        BlackjackPlayer house = new RandomPlayer("House");
        Scanner kbd = new Scanner(System.in);
        System.out.print("What's your name? ");
        String name = kbd.nextLine();
        BlackjackPlayer player = new HumanPlayer(name);
        Deck deck = new Deck();
        deck.shuffle();
        house.dealFaceDown(deck.draw());
        player.dealFaceDown(deck.draw());
        house.dealFaceUp(deck.draw());
        player.dealFaceUp(deck.draw());
        boolean shouldKeepPlaying = true;
        while (shouldKeepPlaying) {
            System.out.println("Here's the table:");
            printHands(house, player);
            BlackjackPlayer.Move playerMove = player.getMove(house.getHand());
            if (playerMove == BlackjackPlayer.Move.HIT) {
                player.dealFaceUp(deck.draw());
            } else {
                shouldKeepPlaying = false;
            }
            BlackjackPlayer.Move houseMove = house.getMove(player.getHand());
            if (houseMove == BlackjackPlayer.Move.HIT) {
                house.dealFaceUp(deck.draw());
            }

        }
    }
}
