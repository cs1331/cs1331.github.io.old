import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
* Poliwhirl
* @author Heather
* @version 1
*/
public class Poliwhirl extends WaterType {

    /**
     * Constructor
     * @param x The X position of Poliwhirl
     * @param y The Y position of Poliwhirl
     * @param bounds The bounding Rectangle
     */
    public Poliwhirl(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage(new ImageIcon("../resources/poliwhirl.png"));
    }
}
