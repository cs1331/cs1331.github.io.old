import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloButtons {

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Hello, buttons!");
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitListener());

        JLabel counterLabel = new JLabel("Count: 0");

        JButton counterButton = new JButton("Increment count");
        CountListener cl = new CountListener(counterLabel);
        counterButton.addActionListener(cl);

        mainFrame.add(exitButton);
        mainFrame.add(counterButton);
        mainFrame.add(counterLabel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
