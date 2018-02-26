public class Person {

    private String name;

    public Person(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("name can't be null or empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    public boolean equals(Object other) {
        if (this == other) { return true; }
        if (!(other instanceof Person)) { return false; }
        Person that = (Person) other;
        return this.name.equals(that.name);
    }

    public int hashCode() {
        return name.hashCode();
    }
}
