import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Company4 {

    private Employee4[] employees;

    public Company4() throws Exception {
        Employee4[] theEmployees = {
            new SalariedEmployee4("Ada Lovelace",
                                 LocalDate.of(1815, 10, 25), 120000),
            new SalariedEmployee4("Alan M. Turing",
                                 LocalDate.of(1912, 6, 23), 120000),
            new SalariedEmployee4("John McCarthy",
                                 LocalDate.of(1927, 9, 4), 120000),
            new SalariedEmployee4("John Backus",
                                 LocalDate.of(1924, 12, 3), 120000),
            new SalariedEmployee4("John von Neumann",
                                 LocalDate.of(1903, 12, 29), 120000),
            new SalariedEmployee4("Donald Knuth",
                                 LocalDate.of(1938, 1, 10), 120000),
            new SalariedEmployee4("Guy Steele",
                                 LocalDate.of(1954, 10, 2), 120000),
            new SalariedEmployee4("Robin Milner",
                                 LocalDate.of(1934, 1, 13), 120000),
            new HourlyEmployee4("Eva L. Uator",
                               LocalDate.of(2013, 2, 13), 20.00, 200),
        };
        employees = theEmployees;
    }

    public double monthlyPayroll() {
        double payroll = 0.0;
        for (Employee4 employee: employees) {
            payroll +=  employee.monthlyPay();
        }
        return payroll;
    }

    public String toString() {
        String ret = "";
        for (Employee4 employee: employees) {
            ret += employee + "\n";
        }
        return ret;
    }

    public static LocalDate vestDate(Employee4 employee) {
        LocalDate hireDate = employee.getHireDate();
        int vestYear = hireDate.getYear() + 2;
        return LocalDate.of(vestYear, hireDate.getMonth(),
                            hireDate.getDayOfMonth());
    }

    public static void main(String[] args) throws Exception {
        Company4 c = new Company4();
        System.out.println(c);
        System.out.println("Monthly payroll: " + c.monthlyPayroll());

        HourlyEmployee4 eva = new HourlyEmployee4("Eva L. Uator",
                           LocalDate.of(2013, 2, 13), 20.00, 200);
        LocalDate evaVestDate = vestDate(eva);
        System.out.println(eva.getName() + " vests on " + evaVestDate);
    }
}
