import java.awt.Color;

public class CoffeeShop {

    public static void main(String[] args) {
        Person blackCoffee = new Person("Louie");
        Hipster soyLatte = new Hipster("Louie", 0, 5, Color.ORANGE);
        System.out.println("blackCoffee.equals(soyLatte): "
                           + blackCoffee.equals(soyLatte));
        // Symmetry broken.  Not an equivalence relation, improper
        // equals() impolementation.
        System.out.println("soyLatte.equals(blackCoffee): "
                           + soyLatte.equals(blackCoffee));
    }
}
