import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Company6 {

    private Employee6[] employees;

    public Company6() throws Exception {
        Employee6[] theEmployees = {
            new SalariedEmployee6("Ada Lovelace",
                                 LocalDate.of(1815, 10, 25), 120000),
            new SalariedEmployee6("Alan M. Turing",
                                 LocalDate.of(1912, 6, 23), 120000),
            new SalariedEmployee6("John McCarthy",
                                 LocalDate.of(1927, 9, 4), 120000),
            new SalariedEmployee6("John Backus",
                                 LocalDate.of(1924, 12, 3), 120000),
            new SalariedEmployee6("John von Neumann",
                                 LocalDate.of(1903, 12, 29), 120000),
            new SalariedEmployee6("Donald Knuth",
                                 LocalDate.of(1938, 1, 10), 120000),
            new SalariedEmployee6("Guy Steele",
                                 LocalDate.of(1954, 10, 2), 120000),
            new SalariedEmployee6("Robin Milner",
                                 LocalDate.of(1934, 1, 13), 120000),
            new HourlyEmployee6("Eva L. Uator",
                               LocalDate.of(2013, 2, 13), 20.00, 200),
            new SummerIntern6("Wayne Garth",
                              LocalDate.of(2014, 2, 25), 20.00, 200),
        };
        employees = theEmployees;
    }

    public double monthlyPayroll() {
        LocalDate today = LocalDate.now();
        Month thisMonth = today.getMonth();
        return monthlyPayroll(thisMonth);
    }

    public double monthlyPayroll(Month month) {
        double payroll = 0.0;
        for (Employee6 employee: employees) {
            payroll +=  employee.monthlyPay(month);
        }
        return payroll;
    }

    public String toString() {
        String ret = "";
        for (Employee6 employee: employees) {
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
        Company6 c = new Company6();
        System.out.println("Monthly payroll this month: " + c.monthlyPayroll());
        System.out.printf("Monthly payroll for May: %.2f%n",
                  c.monthlyPayroll(Month.MAY));
        System.out.printf("Monthly payroll for June: %.2f%n",
                  c.monthlyPayroll(Month.JUNE));

        HourlyEmployee4 eva = new HourlyEmployee4("Eva L. Uator",
                           LocalDate.of(2013, 2, 13), 20.00, 200);
        LocalDate evaVestDate = vestDate(eva);
        System.out.println(eva.getName() + " vests on " + evaVestDate);
        System.out.println(Month.valueOf("FEBRUARY"));
    }
}
