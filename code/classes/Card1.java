public class Card1 {

    String rank;
    String suit;

    public String toString() {
        return rank + " of " + suit;
    }

    public static void main(String[] args) {
        Card1 swedishPop = new Card1();
        swedishPop.rank = "ace";
        swedishPop.suit = "base";
        Card1 handy = new Card1();
        handy.rank = "jack";
        handy.suit = "all trades";
        System.out.println(swedishPop);
        System.out.println(handy);
    }
}
