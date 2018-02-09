/**
 * Class representing the items to buy at Burdell's
 * @author CS1331 TAs
 * @version 1
 */
public enum BurdellsItem {
    HOODIE(30), HEADPHONES(20), GUM(1);

    private double costBuzzFunds;

    private BurdellsItem(double costBuzzFunds) {
        this.costBuzzFunds = costBuzzFunds;
    }

    /**
     * Getter method for the buzz funds required to buy an item.
     * @return Buzz funds cost of item.
     */
    public double getBuzzFunds() {
        return costBuzzFunds;
    }
}
