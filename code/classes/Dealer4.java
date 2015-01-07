public class Dealer4 {

    public static void main(String[] args) {
        Card4 c = new Card4();
        c.setRank("ace");
        c.setSuit("base");
        System.out.println(c);

        Card4 c1 = new Card4();
        c1.setRank("jack");
        c1.setSuit("all trades");
        System.out.println(c);
        System.out.println(c1);
    }
}
