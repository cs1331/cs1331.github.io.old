import java.util.Random;

public class Deck {

    private PlayingCard[] cards;
    private int topCard;

    public Deck() {
        cards = new PlayingCard[52];
        topCard = 51;
        int cardNumber = 0;
        for (PlayingCard.Suit suit: PlayingCard.Suit.values()) {
            for (PlayingCard.Rank rank: PlayingCard.Rank.values()) {
                cards[cardNumber] = new PlayingCard(rank, suit);
                cardNumber++;
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int card1 = rand.nextInt(topCard + 1);
            int card2 = rand.nextInt(topCard + 1);
            swap(card1, card2);
        }
    }

    private void swap(int card1, int card2) {
        PlayingCard tmp = cards[card1];
        cards[card1] = cards[card2];
        cards[card2] = tmp;
    }

    public PlayingCard draw() {
        topCard--;
        assert(topCard >= -1);
        return cards[topCard + 1];
    }

    public boolean hasCards() {
        return topCard >= 0;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= topCard; ++i) {
            sb.append(cards[i].toString()
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
