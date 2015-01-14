public class GtStudent {

    private String name;
    private Major major;

    public GtStudent(String aName, Major aMajor) {
        name = aName;
        major = aMajor;
    }
    public String getName() {
        return name;
    }

    public Major getMajor() {
        return major;
    }

    public String toString() {
        return name + " (" + major + ")";
    }
}
