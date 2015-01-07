public class BlackjackHand implements Comparable {
    
    private PlayingCard faceDownCard;
    private PlayingCard[] faceUpCards;
    private int lastFaceUpCard;

    public BlackjackHand() {
        faceUpCards = new PlayingCard[10];
        int lastFaceUpCard = -1;
    }

    public void addFaceDown(PlayingCard card) {
        faceDownCard = card;
    }

    public void addFaceUp(PlayingCard card) {
        if (null == faceDownCard) {
            System.out.println("Can't add a face up card before adding a "+
                               "face down card.  Hand still empty.");
        } else {
            faceUpCards[lastFaceUpCard++] = card;
        }
    }

    public int value() {
        if (null == faceDownCard) return 0;
        int value = cardValue(faceDownCard);
        for (int i = 0; i < lastFaceUpCard; ++i) {
            value += cardValue(faceUpCards[i]);
        }
        int acesRemaining = countAces();
        while ((value > 21) && (acesRemaining > 0)) {
            value -= 10;
            acesRemaining--;
        }
        return value;
    }

    private int cardValue(PlayingCard card) {
        if (card.getRank() == PlayingCard.Rank.JACK
            || card.getRank() == PlayingCard.Rank.QUEEN
            || card.getRank() == PlayingCard.Rank.KING) {
            return 10;
        } else if (card.getRank() == PlayingCard.Rank.ACE) {
            return 11;
        } else {
            return card.getRank().ordinal();
        }
    }

    private int countAces() {
        int count = (faceDownCard.getRank() == PlayingCard.Rank.ACE) ? 1 : 0;
        for (int i = 0; i < lastFaceUpCard; ++i) {
            if (faceUpCards[i].getRank() == PlayingCard.Rank.ACE) count++;
        }
        return count;
    }

    public int compareTo(Object other) {
        // First, make sure we're comparing to another BlackjackHand
        if (!(other instanceof BlackjackHand)) {
            String msg = "Can't compare a BlackjacHand  object to a " +
                other.getClass().getName() + " object: " + other;
            throw new IllegalArgumentException(msg);
        }
        // Now this is guaranteed to work
        BlackjackHand that = (BlackjackHand) other;
        return this.value() - that.value();
    }

    public String toString() {
        if (null == faceDownCard) {
            return "Empty hand.";
        } else if (faceUpCards.length < 1) {
            return "One face down card.";
        } else {
            String ret = "One face down card and: " + 
                System.getProperty("line.separator");
            for (int i = 0; i < lastFaceUpCard; ++i) {
                ret += faceUpCards[i] + System.getProperty("line.separator");
            }
            return ret;
        }
    }

    public String show() {
        if (null == faceDownCard) {
            return "Empty hand.";
        } else {
            String ret = faceDownCard + System.getProperty("line.separator");
            for (int i = 0; i < lastFaceUpCard; ++i) {
                ret += faceUpCards[i] + System.getProperty("line.separator");
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        BlackjackHand hand = new BlackjackHand();
        System.out.println("New hand:");
        System.out.println(hand.toString());
        PlayingCard ace = new PlayingCard(PlayingCard.Rank.ACE,
                                          PlayingCard.Suit.SPADES);
        hand.addFaceDown();
        System.out.println("After one face down card:");
        System.out.println(hand.toString());
        System.out.println("After one face up card:");
        hand.addFaceUp(deck.draw());
        System.out.println(hand.toString());
        System.out.println("Value should be 21:");
        System.out.println(hand.value());
    }
}
