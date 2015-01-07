import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CounterWindow {

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Counter");
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitListener());

        JLabel counterLabel = new JLabel("Count: 0");
        JButton counterButton = new JButton("Increment count");
        counterButton.addActionListener(new CountListener(counterLabel));

        mainFrame.add(counterButton, BorderLayout.NORTH);
        mainFrame.add(counterLabel, BorderLayout.CENTER);
        mainFrame.add(exitButton, BorderLayout.SOUTH);

        mainFrame.setSize(200, 300);
        mainFrame.setVisible(true);
    }
}
