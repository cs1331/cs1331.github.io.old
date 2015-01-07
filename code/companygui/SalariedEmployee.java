import java.util.Calendar;
import java.util.Date;

public final class SalariedEmployee extends Employee {

    private static final int MONTHS_PER_YEAR = 12;

    private final double annualSalary;

    public SalariedEmployee(SalariedEmployee other) {
        super(other);
        this.annualSalary = other.annualSalary;
    }

    public SalariedEmployee(String aName) {
        this(aName, new Date(), 60000);
    }


    public SalariedEmployee(String aName, Date aHireDate,
                            double anAnnualSalary) {
        super(aName, aHireDate);
        disallowZeroesAndNegatives(anAnnualSalary);
        annualSalary = anAnnualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public double monthlyPay(Calendar cal) {
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
}
