import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.time.LocalDate;

public class Company {

    private ArrayList<Employee> employees;


    public Company(String employeeDataFile) {
        try {
            employees = initFromFile(new File(employeeDataFile));
        } catch (FileNotFoundException e) {
            System.out.println("Can't run without an employee data file.");
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
            System.exit(0);
        } catch (ParseException e) {
            String msg = "Malformed data caused exception: " + e.getMessage();
            System.out.println(msg);
            System.out.println("Full stack trace:");
            e.printStackTrace(System.out);
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Something bad happened: " + e.getMessage());
            e.printStackTrace(System.out);
            System.exit(0);
        }
    }

    public void Company(String empDataFile) throws Exception {
        employees = initFromFile2(new File(empDataFile));
        if (null == employees) {
            System.out.println("There was an error initializing employees.");
            System.out.println("Perhaps " + empDataFile + " doesn't exist?");
            System.exit(1);
        }
    }

    public double monthlyPayroll() {
        double payroll = 0.0;
        int i = 0;
        for (Employee employee: employees) {
            payroll += employee.monthlyPay();
        }
        return payroll;
    }

    public String toString() {
        String ret = "";
        for (Employee employee: employees) {
            ret += employee + "\n";
        }
        return ret;
    }


    private ArrayList<Employee> initFromFile(File empData)
        throws FileNotFoundException, IOException, ParseException {
        ArrayList<Employee> emps = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(empData));
        String line = reader.readLine();
        while (line != null) {
            String[] fields = line.split(";");
            if (fields[0].trim().equalsIgnoreCase("Salaried")) {
                emps.add(makeSalariedEmployee(fields));
            } else {
                emps.add(makeHourlyEmployee(fields));
            }
            line = reader.readLine();
        }
        return emps;
    }


    private ArrayList<Employee> initFromFile2(File empData)
            throws FileNotFoundException {
        ArrayList<Employee> emps = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(empData));
        int lineNumber = 1;
        try {
            String line = reader.readLine();
            while (line != null) {
                try {
                    String[] fields = line.split(";");
                    if (fields[0].trim().equalsIgnoreCase("Salaried")) {
                        emps.add(makeSalariedEmployee(fields));
                    } else {
                        emps.add(makeHourlyEmployee(fields));
                    }
                } catch (ParseException e) {
                    String msg = "Malformed data at line " + lineNumber
                        + ", caused by " + e.getMessage();
                    System.out.println(msg);
                    System.out.println("Full stack trace:");
                    e.printStackTrace(System.out);
                    return null;
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

        }
        return emps;
    }

    private SalariedEmployee makeSalariedEmployee(String[] fields)
            throws ParseException {
        String name = fields[1].trim();
        LocalDate hireDate = LocalDate.parse(fields[2].trim());
        double annualSalary = Double.parseDouble(fields[3].trim());
        return new SalariedEmployee(name, hireDate, annualSalary);
    }

    private HourlyEmployee makeHourlyEmployee(String[] fields)
            throws ParseException {
        String name = fields[1].trim();
        LocalDate hireDate = LocalDate.parse(fields[2].trim());
        double hourlyWage = Double.parseDouble(fields[3].trim());
        double monthlyHours = Double.parseDouble(fields[4].trim());
        return new HourlyEmployee(name, hireDate, hourlyWage, monthlyHours);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Company c = new Company("employees.data");
        System.out.println(c);
        System.out.printf("Monthly payroll: %.2f", c.monthlyPayroll());
    }
}
