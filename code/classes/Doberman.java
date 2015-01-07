public class Doberman {

    public static final String
    STD_DOBIE_SIZE = "large";

    private static int dobieCount = 0;

    private String name;

    public Doberman(Doberman other) {
        this(other.name);
    }

    public Doberman(String name) {
        this.name = name;
        dobieCount++;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return getName();
    }

    public String reportDobieCount() {
        return name + " says there are "
        + dobieCount + " dobies.";
    }
}
