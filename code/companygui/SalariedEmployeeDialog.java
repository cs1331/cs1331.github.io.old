import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SalariedEmployeeDialog extends JDialog {

    private boolean dismissedWithOk;
    private SalariedEmployee employee;
    private JTextField nameTextField;
    private JTextField hireDateTextField;
    private JTextField salaryTextField;
    private String validationErrors;
    /**
     * Use this constructor if you're creating a new employee.
     */
    public SalariedEmployeeDialog(Frame parent) {
        this(parent, "New Employee", new SalariedEmployee(""));
    }

    /**
     * Use this constructor if you're editing an existing employee.
     */
    public SalariedEmployeeDialog(Frame parent,
                                  String dialogTitle,
                                  SalariedEmployee employee) {
        super(parent, dialogTitle);
        super.setModal(true);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.employee = employee;

        super.getContentPane().setLayout( new BorderLayout() );
	JPanel mainPanel = new JPanel();
        // We're only putting one thing in here, but we need it to
        // grow and shrink as the dialog is resized.  Using a
        // GridLayout is a cheap way to accomplish this.
        mainPanel.setLayout( new GridLayout() );
	mainPanel.setBorder( BorderFactory.createRaisedBevelBorder() );
	mainPanel.add(createDataEntryPanel());
	super.getContentPane().add(mainPanel, BorderLayout.CENTER);
	super.getContentPane().add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel createDataEntryPanel() {
        JLabel nameLabel = new JLabel("Name:");
        nameTextField = new JTextField(employee.getName(), 20);
        JLabel hireDateLabel = new JLabel("Hire Date:");
        hireDateTextField =
            new JTextField(employee.getHireDate().toString(), 20);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
	p.add(Box.createHorizontalGlue());
        p.add(createDataEntryComponent(nameLabel, nameTextField));
        p.add(createDataEntryComponent(hireDateLabel, hireDateTextField));

        // Up to this point each different employee dialog would look the same.
        // How could we refactor the dialogs to eliminate code duplication?

        JLabel salaryLabel = new JLabel("AnnualSalary:");
        salaryTextField =
            new JTextField(new Double(employee.getAnnualSalary()).toString(),20);
        p.add(createDataEntryComponent(salaryLabel, salaryTextField));

        return p;
    }

    private Component createDataEntryComponent(JLabel label, Component entry) {
        // Box is a convenient way to use a BoxLayout
        Box b = new Box(BoxLayout.X_AXIS);
        b.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        b.add(label);
        b.add(Box.createHorizontalGlue());
        b.add(entry);
        return b;
    }

    private JPanel createButtonPanel() {
        Action okAction = new AbstractAction("OK") {
                public void actionPerformed(ActionEvent evt) {
                    dismissedWithOk = true;
                    if (isInputValid()) {
                        setVisible(false);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(SalariedEmployeeDialog.this,
                                                      validationErrors,
                                                      "Invalid Input",
                                                      JOptionPane.ERROR_MESSAGE);
                    }
                }
            };
        JButton okButton = new JButton(okAction);
        Action cancelAction = new AbstractAction("Cancel") {
                public void actionPerformed(ActionEvent evt) {
                    dismissedWithOk = false;
                    setVisible(false);
                    dispose();
		}
	    };
        JButton cancelButton = new JButton(cancelAction);
	JPanel p = new JPanel();
	p.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
	p.add(Box.createHorizontalGlue());
	p.add(okButton);
	p.add(Box.createHorizontalStrut(5));
	p.add(cancelButton);
	p.add(Box.createHorizontalGlue());

        super.getRootPane().setDefaultButton(okButton);
	return p;
    }

    public boolean showDialog() {
        super.setLocationRelativeTo(super.getParent());
        super.pack();
        super.setVisible(true);
        return dismissedWithOk;
    }

    private boolean isInputValid() {
        boolean isValid = false;
        try {
            DateFormat df = DateFormat.getDateInstance();
            employee =
                new SalariedEmployee(nameTextField.getText(),
                                     df.parse(hireDateTextField.getText()),
                                     Double.parseDouble(salaryTextField.getText()));
            isValid = true;
        } catch (Exception e) {
            validationErrors = e.getMessage();
        }
        return isValid;
    }

    public SalariedEmployee getEmployee() {
        return employee;
    }

    public static void main(String[] args) {
        SalariedEmployeeDialog sed = new SalariedEmployeeDialog(null);
        boolean ret = sed.showDialog();
        System.out.print("showDialog() returned and was dismissed with ");
        if (ret) {
            System.out.println("OK");
        } else {
            System.out.println("Cancel");
        }
        System.out.println(sed.getEmployee());
    }
}
