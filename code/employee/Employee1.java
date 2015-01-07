import java.time.LocalDate;

public class Employee1 {

    private String name;
    private LocalDate hireLocalDate;

    public Employee1(String aName, LocalDate aHireLocalDate) {
        disallowNullArguments(aName, aHireLocalDate);
        name = aName;
        hireLocalDate = aHireLocalDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getHireDate() {
        return hireLocalDate;
    }

    @Override
    public String toString() {
        return name + "; " + hireLocalDate;
    }

    private void disallowNullArguments(Object ... args) {
        for (Object arg: args) {
            if (arg == null) {
                String msg = "Null arguments not allowed.";
                throw new IllegalArgumentException(msg);
            }
        }
    }
}
