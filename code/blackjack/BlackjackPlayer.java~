public abstract class BlackjackPlayer {

    public enum Move {HIT, STAND};

    private String name;
    protected BlackjackHand hand;

    public BlackjackPlayer(String aName) {
        name = aName;
        hand = new BlackjackHand();
    }

    public String getName() {
        return name;
    }

    public BlackjackHand getHand() {
        return hand;
    }

    public void dealFaceUp(PlayingCard card) {
        hand.addFaceUp(card);
    }

    public void dealFaceDown(PlayingCard card) {
        hand.addFaceDown(card);
    }

    public abstract Move getMove(BlackjackHand ... otherHands);
}
