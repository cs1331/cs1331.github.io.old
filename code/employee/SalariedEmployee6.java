import java.time.LocalDate;
import java.time.Month;

public class SalariedEmployee6 extends Employee6 {

    private static final int MONTHS_PER_YEAR = 12;

    private final double annualSalary;

    public SalariedEmployee6(String aName, LocalDate aHireDate,
                            double anAnnualSalary) {
        super(aName, aHireDate);
        disallowZeroesAndNegatives(anAnnualSalary);
        annualSalary = anAnnualSalary;
    }

    @Override
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

    @Override
    public double monthlyPay(Month month) {
        return monthlyPay();
    }

    public String toString() {
        return super.toString() + "; Annual Salary: " + annualSalary;
    }

    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (!(other instanceof SalariedEmployee3)) return false;
        SalariedEmployee6 that = (SalariedEmployee6) other;
        return super.equals(that) && (this.annualSalary == that.annualSalary);
    }

    public static void main(String[] args) throws Exception {
        SalariedEmployee6 eva = new SalariedEmployee6("Eva Luator",
                                                      LocalDate.of(2013, 6, 10),
                                                      1000000);
        System.out.println(eva.getName());
    }
}
