import java.io.File;

public class BadCompany {

    private HourlyEmployee[] hourlyEmployees;
    private int numHourlyEmployees;
    private SalariedEmployee[] salariedEmployees;
    private int numSalariedEmployees;

    public BadCompany(String employeeDataFile) {
        hourlyEmployees = new HourlyEmployee[10];
        salariedEmployees = new SalariedEmployee[10];
        loadEmployeesFromFile(new File(employeeDataFile));
    }

    public double monthlyPayroll() {
        double payroll = 0.0;
        for (int i = 0; i < numHourlyEmployees; ++i) {
            payroll += hourlyEmployees[i].monthlyPay();
        }
        for (int i = 0; i < numSalariedEmployees; ++i) {
            payroll += salariedEmployees[i].monthlyPay();
        }
        return payroll;
    }
    
    private void loadEmployeesFromFile(File empData) {

    }
}
