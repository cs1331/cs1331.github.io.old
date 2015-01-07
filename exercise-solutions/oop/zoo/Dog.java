public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    public String speak() {
        return getName() + " says woof, woof!";
    }
}
