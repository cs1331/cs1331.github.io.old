import java.time.LocalDate;

public class HourlyEmployee5 extends Employee5 {

    private double hourlyWage;
    private double monthlyHours;

    /**
     * Constructs an HourlyEmployee with hourly wage of 20 and
     * monthly hours of 160.
     */
    public HourlyEmployee5(String aName, LocalDate aHireDate) {
        this(aName, aHireDate, 20.00, 160.0);
    }

    public HourlyEmployee5(String aName, LocalDate aHireDate,
                          double anHourlyWage, double aMonthlyHours) {
        super(aName, aHireDate);
        disallowZeroesAndNegatives(anHourlyWage, aMonthlyHours);
        hourlyWage = anHourlyWage;
        monthlyHours = aMonthlyHours;
    }

    public String getName() {
        return "Hourly: " + super.getName();
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double newWage) {
        hourlyWage = newWage;
    }

    public double getMonthlyHours() {
        return monthlyHours;
    }

    public double monthlyPay() {
        return hourlyWage * monthlyHours;
    }

    public String toString() {
        return getName() + "; Hire Date: " + getHireDate() + "; Hourly Wage: "
            + hourlyWage + "; Monthly Hours: " + monthlyHours;
    }
}
