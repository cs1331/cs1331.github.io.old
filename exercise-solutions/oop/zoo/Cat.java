public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    public String speak() {
        return getName() + " says meow!";
    }
}
