import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.time.LocalDate;

public class Company2 {

    private ArrayList<Employee2> employees;
    private Employee2[] emps;

    public Company2(String employeeDataFile) throws FileNotFoundException {
        employees = new ArrayList<Employee2>(10);
        emps = new Employee2[10];
        loadEmployeesFromFile(new File(employeeDataFile));
    }

    public double monthlyPayroll() {
        double payroll = 0.0;
        int i = 0;
        for (Employee2 employee: employees) {
            // payroll += employee.monthlyPay();
            // System.out.println(emps[i].monthlyPay());
            i++;
        }
        return payroll;
    }

    public String toString() {
        String ret = "";
        for (Employee2 employee: employees) {
            ret += employee + "\n";
        }
        return ret;
    }

    private void loadEmployeesFromFile(File empData)
            throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(empData));
        int lineNumber = 1;
        try {
            String line = reader.readLine();
            while (line != null) {
                try {
                    String[] fields = line.split(";");
                    if (fields[0].trim().equalsIgnoreCase("Salaried")) {
                        employees.add(makeSalariedEmployee(fields));
                        emps[lineNumber-1] = makeSalariedEmployee(fields);
                    } else {
                        employees.add(makeHourlyEmployee(fields));
                        emps[lineNumber-1] = makeHourlyEmployee(fields);
                    }
                } catch (ParseException e) {
                    String msg = "Malformed data at line " + lineNumber
                        + ", caused by " + e.getMessage();
                    System.out.println(msg);
                    System.out.println("Full stack trace:");
                    e.printStackTrace(System.out);
                    System.exit(0);
                }
                line = reader.readLine();
                lineNumber++;
            }
        } catch (IOException e) {
            String msg = "Unable to read line " + lineNumber
                + ", caused by " + e.getMessage();
            System.out.println(msg);
            System.out.println("Full stack trace:");
            e.printStackTrace(System.out);
            System.exit(0);
        }
    }

    private SalariedEmployee2 makeSalariedEmployee(String[] fields)
            throws ParseException {
        String name = fields[1].trim();
        LocalDate hireDate =  LocalDate.parse(fields[2].trim());
        double annualSalary = Double.parseDouble(fields[3].trim());
        return new SalariedEmployee2(name, hireDate, annualSalary);
    }

    private HourlyEmployee2 makeHourlyEmployee(String[] fields)
            throws ParseException {
        String name = fields[1].trim();
        LocalDate hireDate =  LocalDate.parse(fields[2].trim());
        double hourlyWage = Double.parseDouble(fields[3].trim());
        double monthlyHours = Double.parseDouble(fields[4].trim());
        return new HourlyEmployee2(name, hireDate, hourlyWage, monthlyHours);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Company2 c = new Company2("employees.data");
        System.out.println(c);
        System.out.printf("Monthly payroll: %.2f", c.monthlyPayroll());
    }
}
