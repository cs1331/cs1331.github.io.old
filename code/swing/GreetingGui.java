import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GreetingGui extends JFrame {

    private JLabel greetingLabel;

    private class GreetButtonListener implements ActionListener {
        private JLabel greetingLabel;

        public GreetButtonListener(JLabel greetingLabel) {
            this.greetingLabel = greetingLabel;
        }

        public void actionPerformed(ActionEvent e) {
            Greeter greeter = new Greeter("bob");
            String greeting = greeter.greet();
            greetingLabel.setText(greeting);
        }
    }

    public GreetingGui() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        greetingLabel = new JLabel("Greeting will go here.");
        JButton button = new JButton("Greet!");
        button.addActionListener(new GreetButtonListener(greetingLabel));

        add(greetingLabel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
        pack();
    }

    
    public static void main(String[] args) {
        GreetingGui gg = new GreetingGui();
        gg.setVisible(true);
    }
}
