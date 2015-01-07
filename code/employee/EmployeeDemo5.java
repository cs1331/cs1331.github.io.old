import java.time.LocalDate;

public class EmployeeDemo5 {

    /**
     * Demonstrates the use of Employee and sublclasses thereof.
     */
    public static void main(String[] args) {
        HourlyEmployee5 eva = new HourlyEmployee5("Eva L. Uator",
                                                  LocalDate.of(2013, 6, 10),
                                                  20.00, 160);
        System.out.println(eva.getName() + " was hired on " +eva.getHireDate());
    }
}
