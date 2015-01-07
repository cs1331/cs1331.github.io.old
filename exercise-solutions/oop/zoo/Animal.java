public abstract class Animal {

    private String name;

    public Animal(String aName) {
        name = aName;
    }

    public String getName() {
        return name;
    }

    public abstract String speak();
}
