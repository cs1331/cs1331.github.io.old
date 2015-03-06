import java.util.Arrays;

public class PlayingCard {

    public enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
                      TEN, JACK, QUEEN, KING, ACE};
    public enum Suit {DIAMONDS, CLUBS, HEARTS, SPADES};

    private Rank rank;
    private Suit suit;

    public PlayingCard(String aCardDescription) {
        this(extractRank(aCardDescription), extractSuit(aCardDescription));
    }

    private static Rank extractRank(String cardDescription)
            throws IllegalArgumentException {
        String[] parts = cardDescription.split(" ");
        if (parts.length != 3) {
            String msg="Illegal card description: " + cardDescription;
            msg += "\nCard descriptions must have the form <rank> of <suit>";
            msg += ", as in \"ace of spades\".";
            throw new IllegalArgumentException(msg);
        }
        return Rank.valueOf(normalizeString(parts[0].trim()));
    }

    private static Suit extractSuit(String cardDescription) {
        String[] parts = cardDescription.split(" ");
        if (parts.length != 3) {
            String msg="Illegal card description: " + cardDescription;
            msg += "\nCard descriptions must have the form <rank> of <suit>";
            msg += ", as in \"ace of spades\".";
            throw new IllegalArgumentException(msg);
        }
        return Suit.valueOf(normalizeString(parts[2]));
    }

    private static String normalizeString(String someString) {
        return someString.trim().toUpperCase();
    }

    public PlayingCard(Rank aRank, Suit aSuit) {
        rank = aRank;
        suit = aSuit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public static void main(String[] args) {
        System.out.print("Possible ranks are: ");
        for (Rank rank: Rank.values()) {
            System.out.print(rank + " ");
        }
        System.out.println();

        System.out.print("Possible suits are: ");
        for (Suit suit: Suit.values()) {
            System.out.print(suit + " ");
        }
        System.out.println();
        System.out.println("Example PlayingCards:");
        PlayingCard c1 = new PlayingCard(Rank.TWO, Suit.DIAMONDS);
        System.out.println(c1);
        PlayingCard c2 = new PlayingCard("QuEen of heARts");
        System.out.println(c2);
    }
}
