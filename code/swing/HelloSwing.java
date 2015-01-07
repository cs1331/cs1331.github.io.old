import javax.swing.JFrame;

public class HelloSwing {

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Hello, Swing!");
        mainFrame.setSize(640, 480);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
