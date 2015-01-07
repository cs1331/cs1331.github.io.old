public class Zoo {

    private Animal[] animals;
    private int animalCount;

    public Zoo() {
        animals = new Animal[10];
        animalCount = 0;
    }

    public void soundOff() {
        System.out.println("This zoo has " + animalCount + " animals.");
        for (int i = 0; i < animalCount; ++i) {
            animals[i].speak());
        }
    }

    public void add(Animal animal) {
        animals[animalCount++] = animal;
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.add(new Dog("Chloe"));
        zoo.add(new Cat("Fiona"));
        zoo.soundOff();
    }
}
