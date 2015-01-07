public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }


    public String speak() {
        return "woof, woof!";
    }

    public static void main(String[] args) {
        Dog fido = new Dog("Fido");
        System.out.println(fido.getName()
            + " says " + fido.speak());

        Animal chloe = new Dog("Chloe");
        System.out.println(chloe.getName()
            + " says " + chloe.speak());

    }
}
