import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GtFrame extends JFrame {

    public GtFrame() {
        super("Go Tech!");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        add(new JButton("Button"), BorderLayout.SOUTH);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(207, 181, 59));
        g.drawArc(75, 50, 250, 200, 20, 340);
        g.drawLine(275, 150, 375, 150);
        g.drawLine(325, 150, 325, 250);
        g.setFont(new Font("Helvetica", Font.BOLD, 24));
        g.drawString("Go Tech!", 150, 275);
    }

    public static void main(String[] args) {
        GtFrame gtf = new GtFrame();
        gtf.setVisible(true);
    }
}
