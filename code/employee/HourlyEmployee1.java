import java.time.LocalDate;

public class HourlyEmployee1 extends Employee1 {

    private double hourlyWage;
    private double monthlyHours;

    public HourlyEmployee1(String aName, LocalDate aHireDate) {
        super(aName, aHireDate);
    }
}
