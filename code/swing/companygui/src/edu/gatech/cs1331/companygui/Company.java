package edu.gatech.cs1331.companygui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Company {

    private ArrayList<Employee> employees;

    public Company(String employeeDataFile) {
        this(new File(employeeDataFile));
    }

    public Company(File dataFile) {
        employees = new ArrayList<Employee>(10);
        try {
            initFromFile(dataFile);
        } catch (FileNotFoundException e) {
            System.out.println("Can't run without an employee data file.");
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (ParseException e) {
            String msg = "Malformed data caused exception: " + e.getMessage();
            System.out.println(msg);
            System.out.println("Full stack trace:");
            e.printStackTrace(System.out);
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Something bad happened: " + e.getMessage());
        }

    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public double monthlyPayroll() {
        Calendar rightNow = Calendar.getInstance();
        return monthlyPayroll(rightNow);
    }

    public double monthlyPayroll(Calendar month) {
        double payroll = 0.0;
        for (Employee employee: employees) {
            payroll += employee.monthlyPay(month);
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

    private void initFromFile(File empData) throws FileNotFoundException,
                                                   IOException,
                                                   ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(empData));
        int lineNumber = 1;
        String line = reader.readLine();
        while (line != null) {
            String[] fields = line.split(";");
            if (fields[0].trim().equalsIgnoreCase("SalariedEmployee")) {
                employees.add(makeSalariedEmployee(fields));
            } else if (fields[0].trim().
                       equalsIgnoreCase("HourlyEmployee")) {
                employees.add(makeHourlyEmployee(fields));
            } else {
                employees.add(makeSummerIntern(fields));
            }
            line = reader.readLine();
            lineNumber++;
        }
    }

    private SalariedEmployee makeSalariedEmployee(String[] fields)
            throws ParseException {
        String name = fields[1].trim();
        Date hireDate = DateFormat.getDateInstance().parse(fields[2].trim());
        double annualSalary = Double.parseDouble(fields[3].trim());
        return new SalariedEmployee(name, hireDate, annualSalary);
    }

    private HourlyEmployee makeHourlyEmployee(String[] fields)
            throws ParseException {
        String name = fields[1].trim();
        Date hireDate = DateFormat.getDateInstance().parse(fields[2].trim());
        double hourlyWage = Double.parseDouble(fields[3].trim());
        double monthlyHours = Double.parseDouble(fields[4].trim());
        return new HourlyEmployee(name, hireDate, hourlyWage, monthlyHours);
    }

    private HourlyEmployee makeSummerIntern(String[] fields)
            throws ParseException {
        String name = fields[1].trim();
        Date hireDate = DateFormat.getDateInstance().parse(fields[2].trim());
        double hourlyWage = Double.parseDouble(fields[3].trim());
        double monthlyHours = Double.parseDouble(fields[4].trim());
        return new SummerIntern(name, hireDate, hourlyWage, monthlyHours);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Company c = new Company("employees.data");
        System.out.println(c);
        Calendar may =  Calendar.getInstance();
        may.set(Calendar.MONTH, Calendar.MAY);
        Calendar june = Calendar.getInstance();
        june.set(Calendar.MONTH, Calendar.JUNE);
        System.out.println(c.employees.get(0).monthlyPay());
        System.out.printf("Monthly payroll for May: %.2f%n",
                          c.monthlyPayroll(may));
        System.out.printf("Monthly payroll for June: %.2f%n",
                          c.monthlyPayroll(june));
    }
}
