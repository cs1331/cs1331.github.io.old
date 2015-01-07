import java.time.LocalDate;

public class HourlyEmployee2 extends Employee2 {

    private double hourlyWage;
    private double monthlyHours;

    public HourlyEmployee2(String aName, LocalDate aHireDate,
                          double anHourlyWage, double aMonthlyHours) {
        super(aName, aHireDate);
        disallowZeroesAndNegatives(anHourlyWage, aMonthlyHours);
        hourlyWage = anHourlyWage;
        monthlyHours = aMonthlyHours;
    }

    private void disallowZeroesAndNegatives(double ... args) {
        boolean shouldThrowException = false;
        String nonPositives = "";
        for (double arg: args) {
            if (arg <= 0.0) {
                shouldThrowException = true;
                nonPositives += arg + " ";
            }
        }
        if (shouldThrowException) {
            String msg = "Following arguments were <= 0: " + nonPositives;
            throw new IllegalArgumentException(msg);
        }
    }

    @Override
    public String getName() {
        // What if we left off super in super.getName()?
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

    @Override
    public String toString() {
        return getName() + "; Hire Date: " + getHireDate() + "; Hourly Wage: "
            + hourlyWage + "; Monthly Hours: " + monthlyHours;
    }
}
