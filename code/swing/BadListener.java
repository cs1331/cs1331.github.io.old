import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BadListener extends JFrame implements ActionListener {

    public BadListener() {
        super("Bad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton helloButton = new JButton("Hello");
        helloButton.addActionListener(this);
        JButton goodByeButton = new JButton("Good bye");
        goodByeButton.addActionListener(this);
        add(helloButton, BorderLayout.NORTH);
        add(goodByeButton, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.equals("Hello")) {
            System.out.println("Hello was perssed.");
        } else if (button.equals("Good bye")) {
            System.out.println("Good bye was perssed.");
        }
    }

    public static void main(String[] args) {
        BadListener bad = new BadListener();
        bad.pack();
        bad.setVisible(true);
    }
}
