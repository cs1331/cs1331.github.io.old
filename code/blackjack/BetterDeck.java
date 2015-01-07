import java.util.ArrayList;
import java.util.Random;

public class BetterDeck {

    private ArrayList<PlayingCard> cards;

    public BetterDeck() {
        cards = new ArrayList<PlayingCard>(52);
        for (PlayingCard.Suit suit: PlayingCard.Suit.values()) {
            for (PlayingCard.Rank rank: PlayingCard.Rank.values()) {
                cards.add(new PlayingCard(rank, suit));
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int card1 = rand.nextInt(cards.size());
            int card2 = rand.nextInt(cards.size());
            swap(card1, card2);
        }
    }

    private void swap(int card1, int card2) {
        PlayingCard tmp = cards.get(card1);
        cards.set(card1, cards.get(card2));
        cards.set(card2, tmp);
    }
    
    public PlayingCard draw() {
        return cards.remove(cards.size() - 1);
    }
    
    public boolean hasCards() {
        return !cards.isEmpty();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (PlayingCard card: cards) {
            sb.append(cards.toString()
                      + System.getProperty("line.separator"));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("New deck:");
        System.out.println(deck);
        deck.shuffle();
        System.out.println("Shuffled deck:");
        System.out.println(deck);
        System.out.println("A few draws:");
        System.out.println(deck.draw());
        System.out.println(deck.draw());
        System.out.println(deck.draw());
        System.out.println("Draw the remaining cards:");
        while (deck.hasCards()) {
            System.out.println(deck.draw());
        }
    }
}
