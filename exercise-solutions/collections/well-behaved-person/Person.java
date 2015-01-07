public final class Person implements Comparable<Person> {

    private String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() { return name; }

    public int getBirthYear() { return birthYear; }

    public int compareTo(Person other) {
        if (this.birthYear != other.birthYear) {
            return this.birthYear - other.birthYear;
        } else {
            return this.name.compareTo(other.name);
        }
    }

    public boolean equals(Object other) {
        if (other == null) { return false; }
        if (this == other) { return true; }
        if (!(other instanceof Person)) { return false; }
        Person that = (Person) other;
        return this.name.equals(that.name) && this.birthYear == that.birthYear;
    }

    public int hashCode() {
        int result = 17;
        result += 31 * result + name.hashCode();
        result += 31 * result + birthYear;
        return result;
    }
}
