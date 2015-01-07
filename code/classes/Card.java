import java.util.Arrays;

public class Card {

    public static final String[] VALID_RANKS =
        {"2", "3", "4", "5", "6", "7", "8", "9",
         "10", "jack", "queen", "king", "ace"};
    public static final String[] VALID_SUITS =
        {"diamonds", "clubs", "hearts","spades"};

    private String rank;
    private String suit;

    public Card(String aRank, String aSuit) {
        String theRank = normalizeString(aRank);
        String theSuit = normalizeString(aSuit);
        if (isValidRank(theRank)) {
            rank = theRank;
        } else {
            String msg = "Illegal rank: " + theRank;
            throw new IllegalArgumentException(msg);
        }
        if (isValidSuit(theSuit)) {
            suit = theSuit;
        } else {
            String msg = "Illegal suit: " + theSuit;
            throw new IllegalArgumentException(msg);
        }
    }
    private static String normalizeString(String someString) {
        return someString.trim().toLowerCase();
    }

    private static boolean isValidRank(String someRank) {
        return Arrays.asList(VALID_RANKS).contains(someRank);
    }

    private static boolean isValidSuit(String someSuit) {
        return Arrays.asList(VALID_SUITS).contains(someSuit);
    }

    public String toString() {
        return rank + " of " + suit;
    }
    
    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (!(other instanceof Card)) return false;
        Card that = (Card) other;
        return this.rank.equals(that.rank) && this.suit.equals(that.suit);
    }

    public static void main(String[] args) {
        Card c1 = new Card("ace", "spades");
        Card c2 = new Card("ace", "spades");
        Card c3 = c1;
        System.out.println("c1 == c2 returns " + (c1 == c2));
        System.out.println("c1.equals(c2) returns " + c1.equals(c2));
        System.out.println("c1 == c3 returns " + (c1 == c3));
        System.out.println("c1.equals(c3) returns " + c1.equals(c3));

        String a = "foo";
        String b = "foo";

        System.out.println(a == b);
    }
}
