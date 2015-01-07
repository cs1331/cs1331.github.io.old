public class Trooper implements Comparable<Trooper> {

    private String name;
    private boolean mustached;

    public Trooper(String name, boolean hasMustache) {
        this.name = name;
        this.mustached = hasMustache;
    }

    public String getName() { return name; }
    public boolean hasMustache() { return mustached; }

    public String toString() {
        return getName() + (hasMustache() ? " :-{" : " :-|");
    }

    public boolean equals(Object other) {
        if (null == other) return false;
        if (this == other) return true;
        if (!(other instanceof Trooper)) return false;
        Trooper that = (Trooper) other;
        return this.name.equals(that.name)
            && this.mustached == that.mustached;
    }

    public int compareTo(Trooper other) {
        return this.name.compareTo(other.name);
    }
}
