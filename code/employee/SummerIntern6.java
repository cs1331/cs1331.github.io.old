import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;

public class SummerIntern6 extends HourlyEmployee6 {

    public SummerIntern6(String name, LocalDate hireDate) {
        this(name, hireDate, 20.00, 160.0);
    }

    public SummerIntern6(String name, LocalDate hireDate, double hourlyWage) {
        this(name, hireDate, hourlyWage, 160.0);
    }

    public SummerIntern6(String name, LocalDate hireDate,
                        double hourlyWage, double monthlyHours) {
        super(name, hireDate, hourlyWage, monthlyHours);
    }

    public double monthlyPay() {
        LocalDate today = LocalDate.now();
        Month thisMonth = today.getMonth();
        return monthlyPay(thisMonth);
    }

    public double monthlyPay(Month month) {
        super.disallowNullArguments(month);
        if (isSummer(month)) {
            return super.monthlyPay();
        }
        return 0.0;
    }

    private boolean isSummer(Month month) {
        return month == Month.JUNE
            || month == Month.JULY
            || month == Month.AUGUST;
    }

    public String toString() {
        return super.toString() + " (Summer Intern)";
    }

    public static void main(String[] args) throws Exception {

        SummerIntern6 fred = new SummerIntern6("Fred",
                                               LocalDate.of(2013, 2, 27),
                                               20.00, 100);

        System.out.println("This month's pay: " + fred.monthlyPay());
        System.out.println("May pay: " + fred.monthlyPay(Month.MAY));
        System.out.println("June pay: " + fred.monthlyPay(Month.JUNE));

        HourlyEmployee6 barney = (HourlyEmployee6) fred;
        System.out.println(barney);
    }
}
