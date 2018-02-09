/**
 * Class representing the items to buy at Burdell's
 * @author CS1331 TAs
 * @version 1
 */
public enum BrittainItem {
    BUFFET(1, 15.00);

    private int costMealSwipes;
    private double costBuzzFunds;

    private BrittainItem(int costMealSwipes, double costBuzzFunds) {
        this.costMealSwipes = costMealSwipes;
        this.costBuzzFunds = costBuzzFunds;
    }

    /**
     * Getter method for the meal swipes required to buy an item.
     * @return Meal swipe cost of item.
     */
    public int getMealSwipes() {
        return this.costMealSwipes;
    }

    /**
     * Getter method for the buzz funds required to buy an item.
     * @return Buzz funds cost of item.
     */
    public double getBuzzFunds() {
        return this.costBuzzFunds;
    }
}
