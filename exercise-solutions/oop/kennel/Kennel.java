public class Kennel {

    private Dog[] dogs;

    public Kennel(Dog ... dogs) {
        this.dogs = dogs;
    }

    public void soundOff() {
        for (Dog dog: dogs) {
            System.out.println(dog.getName() + " says " + dog.speak());
        }
    }

    public static void main(String[] args) {
        Kennel kennel = new Kennel(
            new Dog("Chloe"),
            new Dog("Bailey"),
            new Dog("Sophie")
        );
        // What if Dog didn't override speak()?
        kennel.soundOff();
    }
}
