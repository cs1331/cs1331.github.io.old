import java.util.Calendar;
import java.time.LocalDate;

public abstract class Employee4 {

    private String name;
    private LocalDate hireDate;

    public Employee4(String aName, LocalDate aHireLocalDate) {
        disallowNullArguments(aName, aHireLocalDate);
        name = aName;
        hireDate = aHireLocalDate;
    }

    private void disallowNullArguments(Object ... args) {
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
        Employee4 that = (Employee4) other;
        return name.equals(that.name) && hireDate.equals(that.hireDate);
    }
}
