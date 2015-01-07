import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class CountListener implements ActionListener {

    private JLabel countLabel;
    private int count;

    public CountListener(JLabel countLabel) {
        this.countLabel = countLabel;
        count = 0;
    }

    public void actionPerformed(ActionEvent e) {
        count++;
        countLabel.setText("Count: " + count);
    }
}
