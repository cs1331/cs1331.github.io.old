public class Animal {

    private String name;

    public Animal(String aName) {
        name = aName;
    }

    public String getName() {
        return name;
    }

    public String speak() {
        return "Grunt!";
    }

    public static void main(String[] args) {
        Animal house = new Animal("Belushi");
        System.out.println(house.getName());
        assert house.getName().equals("Belushi");
        System.out.println(house.speak());
        assert house.speak().equals("Grunt!");
    }
}
