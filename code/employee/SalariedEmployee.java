import java.text.DateFormat;
import java.util.Calendar;
import java.time.LocalDate;

public class SalariedEmployee extends Employee {

    private static final int MONTHS_PER_YEAR = 12;

    private final double annualSalary;

    public SalariedEmployee(String aName, LocalDate aHireLocalDate,
                            double anAnnualSalary) {
        super(aName, aHireLocalDate);
        ValidationUtils.disallowZeroesAndNegatives(anAnnualSalary);
        annualSalary = anAnnualSalary;
    }

    public String getName() {
        return "Salaried: " + super.getName();
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    @Override
    public double monthlyPay() {
        return annualSalary / MONTHS_PER_YEAR;
    }

    public String toString() {
        return super.toString() + "; Annual Salary: " + annualSalary;
    }

    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (!(other instanceof SalariedEmployee)) return false;
        SalariedEmployee that = (SalariedEmployee) other;
        return super.equals(that) && (this.annualSalary == that.annualSalary);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(HourlyEmployee.YAY);
        SalariedEmployee eva = new SalariedEmployee("Eva Luator",
                                                    LocalDate.of(2013, 6, 10),
                                                    1000000);
        System.out.println(eva.getName());
    }
}
