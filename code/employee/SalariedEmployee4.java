import java.time.LocalDate;

public class SalariedEmployee4 extends Employee4 {

    private static final int MONTHS_PER_YEAR = 12;

    private final double annualSalary;

    public SalariedEmployee4(String aName, LocalDate aHireDate,
                            double anAnnualSalary) {
        super(aName, aHireDate);
        disallowZeroesAndNegatives(anAnnualSalary);
        annualSalary = anAnnualSalary;
    }

    private void disallowZeroesAndNegatives(double ... args) {
        boolean shouldThrowException = false;
        String nonPositives = "";
        for (double arg: args) {
            if (arg <= 0.0) {
                shouldThrowException = true;
                nonPositives += arg + " ";
            }
        }
        if (shouldThrowException) {
            String msg = "Following arguments were <= 0: " + nonPositives;
            throw new IllegalArgumentException(msg);
        }
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

    public String toString() {
        return super.toString() + "; Annual Salary: " + annualSalary;
    }

    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (!(other instanceof SalariedEmployee3)) return false;
        SalariedEmployee4 that = (SalariedEmployee4) other;
        return super.equals(that) && (this.annualSalary == that.annualSalary);
    }

    public static void main(String[] args) throws Exception {
        SalariedEmployee4 eva = new SalariedEmployee4("Eva Luator",
                                                      LocalDate.of(2013, 6, 10),
                                                      1000000);
        System.out.println(eva.getName());
    }
}
