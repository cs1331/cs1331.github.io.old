import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
* Rapidash
* @author Heather
* @version 1
*/
public class Rapidash extends FireType {

    /**
     * Constructor
     * @param x The X position of Rapidash
     * @param y The Y position of Rapidash
     * @param bounds The bounding Rectangle
     */
    public Rapidash(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage(new ImageIcon("../resources/rapidash.png"));
    }
}
