public class BalletTicket {

    private String section;
    private double price;

    public BalletTicket(String section, int age) {
        if (!(section.equals("orchestra") || section.equals("mezzanine"))) {
            System.out.println(section +
                "is invalid.  Defaulting to orchestra.");
            section = "orchestra";
        }
        this.section = section;
        if (this.section.equals("orchestra")) { price = 50; }
        if (this.section.equals("mezzanine")) { price = 40; }
        if (age >= 65) { price *= .9; }
        price *= 1.05;
    }

    public String getSection() {
        return section;
    }

    public double getPrice() {
        return price;
    }

    public static void main(String[] args) {
        BalletTicket ticket = new BalletTicket("orchestra", 65);
        System.out.printf("Your %s ticket costs %.2f.%n", ticket.getSection(),
        ticket.getPrice());
    }
}
