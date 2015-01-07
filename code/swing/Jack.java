import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Jack extends JFrame {

    private JLabel imageLabel;

    private class JackWindowListener extends WindowAdapter {

        public void windowClosing(WindowEvent e) {
            int choice = JOptionPane.showConfirmDialog(
                Jack.this,
                "Do you really want to exit?",
                "Exit for reals?",
                JOptionPane.OK_CANCEL_OPTION
            );
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public Jack() {
        // Need to set DO_NOTHING_ON_CLOSE so we can handle window closing
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        // Confirm exit before exiting program
        addWindowListener(new JackWindowListener());
        imageLabel = new JLabel();

        add(imageLabel, BorderLayout.CENTER);
        add(createButtonBox(), BorderLayout.SOUTH);
        pack();
    }

    private Box createButtonBox(){
        JButton jackButton = new JButton("Show Jack of Hearts");
        ImageIcon buttonIcon = new ImageIcon("New16.gif");
        jackButton.setIcon(buttonIcon);

        ActionListener jackListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ImageIcon jackIcon = new ImageIcon("JACK-HEARTS.png");
                    imageLabel.setIcon(jackIcon);
                    pack();
                }
            };
        jackButton.addActionListener(jackListener);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(jackButton);
        return buttonBox;
    }

    public static void main(String[] args) {
        Jack j = new Jack();
        j.setVisible(true);
    }
}
