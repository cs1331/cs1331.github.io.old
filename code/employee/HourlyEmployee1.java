import java.time.LocalDate;

public class HourlyEmployee1 extends Employee1 implements Named {

    private double hourlyWage;
    private double monthlyHours;

    public HourlyEmployee1(String aName, LocalDate aHireDate) {
        super(aName, aHireDate);
    }

    public static void main(String[]  args) {
        HourlyEmployee1 emp = new HourlyEmployee1("Alyssa P. Hacker",
                                                  LocalDate.now());
        System.out.println(emp.getName());
    }
}
