public class GtStudent extends Person {

    public enum Major {
        CS, CM, CMPE, EE, IE, ME, AE, ARCH, BME, STAC, MGT, EIA
    }

    private int year;
    private Major major;

    public GtStudent(String aName, int aYear, Major aMajor) {
        super(aName);
        year = aYear;
        major = aMajor;
    }

    public String toString() {
        return getName() + ", " + year + "-year " + major;
    }
}
