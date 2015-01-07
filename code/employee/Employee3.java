import java.time.LocalDate;

public class Employee3 {

    private String name;
    private LocalDate hireLocalDate;

    public Employee3(String aName, LocalDate aHireLocalDate) {
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
        boolean shouldThrowException = false;
        String nullArgs = "";
        for (Object arg: args) {
            if (arg == null) {
                shouldThrowException = true;
                nullArgs += arg + " ";
            }
        }
        if (shouldThrowException) {
            String msg = "null arguments not allowed. ";
            throw new IllegalArgumentException(msg);
        }
    }
}
