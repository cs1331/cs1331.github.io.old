public class Card4 {

    private String rank;
    private String suit;

    public String toString() {
        return rank + " of " + suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
