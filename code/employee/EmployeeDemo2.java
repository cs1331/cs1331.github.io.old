import java.time.LocalDate;

public class EmployeeDemo2 {

    public static void main(String[] args) {
        HourlyEmployee2 eva = new HourlyEmployee2("Eva L. Uator",
                                                LocalDate.of(2013, 6, 10),
                                                200, 160);
        System.out.println(eva.getName() + " was hired on " +eva.getHireDate());
    }
}
