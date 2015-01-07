import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CounterGrid extends JFrame {


    private class CountListener implements ActionListener {
        int count = 0;

        public void actionPerformed(ActionEvent e) {
            System.out.println(count++);
        }
    }

    public CounterGrid() {
        super("Counter");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3,1)); // 3 rows, 1 column

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitListener());

        JLabel counterLabel = new JLabel("Count: 0");
        JButton counterButton = new JButton("Increment count");
        counterButton.addActionListener(new CountListener());

        add(counterButton);
        add(counterLabel);
        add(exitButton);

        setSize(200, 300);
    }

    public static void main(String[] args) {
        CounterGrid cf = new CounterGrid();
        cf.setVisible(true);
    }
}
