import java.util.ArrayList;

public class ArrayListTypesDemo {

    static abstract class Gnome {
        public String name;
        public Gnome(String name) {
            this.name = name;
        }
    }

    static class GardenGnome extends Gnome {
        public GardenGnome(String name) { super(name); }
    }

    static class UnderwearGnome extends Gnome {
        public UnderwearGnome(String name) { super(name); }
    }

    public static void main(String[] args) {
        ArrayList<Gnome> gnomes = new ArrayList<>();
        ArrayList<GardenGnome> gardenGnomes = new ArrayList<>();
        ArrayList<UnderwearGnome> underwearGnomes = new ArrayList<>();

        // Fine:  Gnome is a superclass
        gnomes.add(new GardenGnome("Corny"));
        gnomes.add(new UnderwearGnome("Jaques"));

        // Nuh, uh! Type incompatibility.
        underwearGnomes.add(new GardenGnome("Carrot Top"));
    }

}
