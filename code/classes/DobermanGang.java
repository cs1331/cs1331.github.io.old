import java.util.Arrays;

public class DobermanGang {

    private final Doberman topDog;
    private Doberman[] gang;
    private int size;

    public DobermanGang(Doberman topDog) {
        this.topDog = topDog;
        gang = new Doberman[6];
        size = 0;
    }

    public Doberman getTopDog() {
        return topDog;
    }

    public Doberman[] getGang() {
        return gang;
    }

    public void add(Doberman famousBankRobber) {
        gang[size++] = famousBankRobber;
    }

    public Doberman get(int i) {
        return gang[i];
    }

    public String toString() {
        return "Top Dog: " + topDog.toString()
            + ", The Gang: "
            + Arrays.toString(gang);
    }
}
