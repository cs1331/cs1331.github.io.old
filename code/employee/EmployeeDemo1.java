import java.time.LocalDate;

public class EmployeeDemo1 {

    /**
     * Demonstrates the use of Employee and sublclasses thereof.
     */
    public static void main(String[] args) {
        HourlyEmployee1 eva = new HourlyEmployee1("Eva L. Uator",
                                                LocalDate.of(2013, 6, 10));
        System.out.println(eva.getName() + " was hired on " +eva.getHireDate());
    }
}
