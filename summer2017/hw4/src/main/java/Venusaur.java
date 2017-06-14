import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
* Venusaur
* @author Heather
* @version 1
*/
public class Venusaur extends GrassType {

    /**
     * Constructor
     * @param x The X position of Venusaur
     * @param y The Y position of Venusaur
     * @param bounds The bounding Rectangle
     */
    public Venusaur(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage(new ImageIcon("../resources/venusaur.png"));
    }
}
