import java.time.LocalDate;
import java.time.Month;

public abstract class Employee6 {

    private String name;
    private LocalDate hireDate;

    public Employee6(String aName, LocalDate aHireDate) {
        disallowNullArguments(aName, aHireDate);
        name = aName;
        hireDate = aHireDate;
    }

    protected void disallowNullArguments(Object ... args) {
        boolean shouldThrowException = false;
        for (Object arg: args) {
            if (arg == null) {
                shouldThrowException = true;
            }
        }
        if (shouldThrowException) {
            String msg = "null arguments not allowed. ";
            throw new IllegalArgumentException(msg);
        }
    }

    public abstract double monthlyPay();

    public abstract double monthlyPay(Month month);

    public String getName() {
        return name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return name + "; " + hireDate;
    }

    // --------------------------------------------------------

    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (!(other instanceof Employee)) return false;
        Employee6 that = (Employee6) other;
        return name.equals(that.name) && hireDate.equals(that.hireDate);
    }

    protected void disallowZeroesAndNegatives(double ... args) {
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
}
