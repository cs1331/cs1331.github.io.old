import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ColorBox extends JFrame implements ActionListener {

    JPanel colorPanel;

    public ColorBox() {
        super("Color, Box, and Nesting Demo");

        // Set up button panel
        JButton redButton = new JButton("Red");
        redButton.addActionListener(this);

        redButton.setEnabled(false);

        JButton whiteButton = new JButton("White");
        whiteButton.addActionListener(this);
        JButton blueButton = new JButton("Blue");
        blueButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(redButton);
        buttonPanel.add(whiteButton);
        buttonPanel.add(blueButton);

        // Set up color panel
        colorPanel = new JPanel();
        colorPanel.setSize(200, 200);

        // Set up main application frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));
        add(buttonPanel);
        add(colorPanel);

        JMenuBar menuBar = createJMenuBar();
        setJMenuBar(menuBar);
    }

    private JMenuBar createJMenuBar() {
        JMenuItem redMenuItem = new JMenuItem("Rot");
        redMenuItem.addActionListener(this);
        redMenuItem.setActionCommand("Red");
        JMenuItem whiteMenuItem = new JMenuItem("Weiss");
        whiteMenuItem.addActionListener(this);
        JMenuItem blueMenuItem = new JMenuItem("Blau");
        blueMenuItem.addActionListener(this);

        JMenu colorMenu = new JMenu("Color");
        colorMenu.add(redMenuItem);
        colorMenu.add(whiteMenuItem);
        colorMenu.add(blueMenuItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(colorMenu);
        return menuBar;
    }

    private JButton createButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button == "Red") {
            colorPanel.setBackground(Color.RED);
        } else if (button == "White") {
            colorPanel.setBackground(Color.WHITE);
        } else if (button == "Blue") {
            colorPanel.setBackground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        ColorBox cb = new ColorBox();
        cb.pack();
        cb.setVisible(true);
    }
}
