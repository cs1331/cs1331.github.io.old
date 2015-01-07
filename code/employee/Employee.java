import java.util.Calendar;
import java.time.LocalDate;
import java.time.Month;

public abstract class Employee {

    private String name;
    private LocalDate hireDate;

    public Employee(String aName, LocalDate aHireDate) {
        ValidationUtils.disallowNullArguments(aName, aHireDate);
        name = aName;
        hireDate = aHireDate;
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

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (!(other instanceof Employee)) return false;
        Employee that = (Employee) other;
        return name.equals(that.name) && hireDate.equals(that.hireDate);
    }
}
