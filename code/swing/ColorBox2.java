import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ColorBox2 extends JFrame {

    private JPanel colorPanel;
    private Action redAction;
    private Action whiteAction;
    private Action blueAction;

    private class RedAction extends AbstractAction {
        public RedAction() {
            super("Red");
        }

        public void actionPerformed(ActionEvent e) {
            colorPanel.setBackground(Color.RED);
        }
    }

    public ColorBox2() {
        super("Color, Box, and Nesting Demo");

        initActions();

        // Set up color panel
        colorPanel = new JPanel();
        colorPanel.setSize(200, 200);

        // Set up main application frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Grid layout with 1 row, 2 columns
        setLayout(new GridLayout(1, 2));
        add(createButtonPanel());
        add(colorPanel);
        setJMenuBar(createJMenuBar());
        redAction.setEnabled(false);
    }

    private void initActions() {
        redAction = new RedAction();
        whiteAction = new AbstractAction("Weiss") {
                public void actionPerformed(ActionEvent e) {
                    colorPanel.setBackground(Color.WHITE);
                }
            };
        blueAction = new AbstractAction("Blue") {
                public void actionPerformed(ActionEvent e) {
                    colorPanel.setBackground(Color.BLUE);
                }
            };
    }

    private JPanel createButtonPanel() {
        JButton redButton = new JButton(redAction);
        JButton whiteButton = new JButton(whiteAction);
        JButton blueButton = new JButton(blueAction);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(redButton);
        buttonPanel.add(whiteButton);
        buttonPanel.add(blueButton);

        return buttonPanel;
    }

    private JMenuBar createJMenuBar() {
        JMenuItem redMenuItem = new JMenuItem(redAction);
        JMenuItem whiteMenuItem = new JMenuItem(whiteAction);
        JMenuItem blueMenuItem = new JMenuItem(blueAction);

        JMenu colorMenu = new JMenu("Color");
        colorMenu.add(redMenuItem);
        colorMenu.add(whiteMenuItem);
        colorMenu.add(blueMenuItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(colorMenu);
        return menuBar;
    }

    public static void main(String[] args) {
        ColorBox2 cb = new ColorBox2();
        cb.pack();
        cb.setVisible(true);
    }
}
