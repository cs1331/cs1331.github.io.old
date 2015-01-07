package edu.gatech.cs1331.companygui;

import javax.swing.JFileChooser;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import java.io.File;

public class CompanyGui {

    public static void main(String[] args) throws Exception {
        File thisDir = new File(System.getProperty("user.dir"));
        JFileChooser chooser = new JFileChooser(thisDir);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            Company company = new Company(file);
            DefaultListModel lm = new DefaultListModel();
            for (Employee e: company.getEmployees()) {
                lm.addElement(e);
            }
            CompanyFrame cf = new CompanyFrame(lm);
            cf.pack();
            cf.setVisible(true);
        }
    }
}
