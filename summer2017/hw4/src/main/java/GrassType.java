/**
 * A grass type pokemon
 *
 * @author Farhan Tejani
 * @version 1
 */

import java.awt.Rectangle;

public abstract class GrassType extends Pokemon {

    /**
     * Constructor
     * @param x The X position of the Grass type Pokemon
     * @param y The Y position of the Grass type Pokemon
     * @param bounds The bounding Rectangle
     */
    public GrassType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }
}
