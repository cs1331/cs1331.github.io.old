import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
*This is the class that will run the Pokemon Battle.
*
* @author Heather
* @version 1.0
*/

public class PokeBattle {
    public static void main(String[] args) {
        JFrame frame = new JFrame("PokeWorld");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel control = new ControlPanel();
        frame.add(control, BorderLayout.WEST);
        frame.add(new PokeWorld(control)); //defaults to CENTER
        frame.pack();
        frame.setVisible(true);
    }
}