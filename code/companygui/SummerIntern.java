import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class SummerIntern extends HourlyEmployee {

    public SummerIntern(String name, Date hireDate) {
        this(name, hireDate, 20.00, 160.0);
    }
    
    public SummerIntern(String name, Date hireDate, double hourlyWage) {
        this(name, hireDate, hourlyWage, 160.0);
    }

    public SummerIntern(String name, Date hireDate,
                        double hourlyWage, double monthlyHours) {
        super(name, hireDate, hourlyWage, monthlyHours);
    }

    public double monthlyPay(Calendar month) {
        // Is this clear?  Could you rewrite this to be clearer?
        return isSummer(month) ? super.monthlyPay(month) : 0.0;
    }
    
    public String toString() {
        return super.toString() + " (Summer Intern)";
    }

    private boolean isSummer(Calendar calendar) {
        int month = calendar.get(Calendar.MONTH);
        System.out.println("In SummerIntern.isSummer(), month=" + month);
        return month == Calendar.JUNE
            || month == Calendar.JULY
            || month == Calendar.AUGUST;
    }

    public static void main(String[] args) throws Exception {
        DateFormat df = DateFormat.getDateInstance();
        SummerIntern fred = new SummerIntern("Fred",
                                             df.parse("February 27, 2013"),
                                             20.00, 100);
        Calendar may =  Calendar.getInstance();
        may.set(Calendar.MONTH, Calendar.MAY);
        Calendar june = Calendar.getInstance();
        june.set(Calendar.MONTH, Calendar.JUNE);
        System.out.println("May pay: " + fred.monthlyPay(may));
        System.out.println("June pay: " + fred.monthlyPay(june));

        HourlyEmployee barney = (HourlyEmployee) fred;
        System.out.println(barney);
    }
}
