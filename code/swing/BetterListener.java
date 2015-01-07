import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BetterListener extends JFrame {

    private class HelloListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Hello was pressed.");
        }
    }

    private class GoodByeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Good bye was pressed.");
        }
    }

    public BetterListener() {
        super("Better Listener");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton helloButton = new JButton("Hello");
        helloButton.addActionListener(new HelloListener());
        JButton goodByeButton = new JButton("Good bye");
        goodByeButton.addActionListener(new GoodByeListener());
        add(helloButton, BorderLayout.NORTH);
        add(goodByeButton, BorderLayout.SOUTH);
    }


    public static void main(String[] args) {
        BetterListener better = new BetterListener();
        better.pack();
        better.setVisible(true);
    }
}
