import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GreetingGui extends JFrame implements ActionListener {

    private JLabel greetingLabel;

    public GreetingGui() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        greetingLabel = new JLabel("Greeting will go here.");
        JButton button = new JButton("Greet!");
        button.addActionListener(this);

        add(greetingLabel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
        pack();
    }

    public void actionPerformed(ActionEvent e) {
        Greeter greeter = new Greeter("bob");
        String greeting = greeter.greet();
        greetingLabel.setText(greeting);
    }

    public static void main(String[] args) {
        GreetingGui gg = new GreetingGui();
        gg.setVisible(true);
    }
}
