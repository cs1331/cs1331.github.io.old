/**
 * Class representing the items to buy at Subway
 * @author CS1331 TAs
 * @version 1
 */
public enum SubwayItem {
    FOOTLONG(9, 10), SIX_INCH(5.5, 6), CHIPS(.4, .5), DRINK(1.80, 2);

    private double diningDollars;
    private double buzzFunds;

    private SubwayItem(double diningDollars, double buzzFunds) {
        this.diningDollars = diningDollars;
        this.buzzFunds = buzzFunds;
    }

    /**
     * Getter method for the buzz funds required to buy an item.
     * @return Buzz funds cost of item.
     */
    public double getBuzzFunds() {
        return buzzFunds;
    }

    /**
     * Getter method for the dining dollars required to buy an item.
     * @return Dining dollar cost of item.
     */
    public double getDiningDollars() {
        return diningDollars;
    }
}
