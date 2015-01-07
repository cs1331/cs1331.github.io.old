import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CounterFrame extends JFrame {

    public CounterFrame() {
        super("Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitListener());

        JLabel counterLabel = new JLabel("Count: 0");
        JButton counterButton = new JButton("Increment count");
        counterButton.addActionListener(new CountListener(counterLabel));

        setLayout(new GridLayout(3, 1));
        add(counterLabel);
        add(counterButton);
        add(exitButton);

        pack();
    }

    public static void main(String[] args) {
        CounterFrame cf = new CounterFrame();
        cf.setVisible(true);
    }
}
