import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatting {
    
    public static void main(String[] args) {
        NumberFormat us = NumberFormat.getCurrencyInstance();
        System.out.println(us.format(3.14));

        NumberFormat de =
            NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println(de.format(3.14));
    }
}