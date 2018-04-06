import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTroopers {

    static class HasMustache implements Predicate<Trooper> {

        public boolean test(Trooper t) {
            return t.hasMustache();
        }
    }


    public static void main(String[] args) {
        List<Trooper> troopers = new ArrayList<>();
        troopers.add(new Trooper("Thorny", true));
        troopers.add(new Trooper("Farva", true));
        troopers.add(new Trooper("Farva", true));
        troopers.add(new Trooper("Ursula", false));
        troopers.add(new Trooper("Rabbit", false));
        troopers.add(new Trooper("Mac", true));
        troopers.add(new Trooper("Foster", true));

        System.out.println("Before sorting:\n" + troopers);

        // Mustache counting ...

        // using named class:
        long mc1 =
            troopers.stream().filter(new HasMustache()).count();

        System.out.println("Mustaches: " + mc1);

        // using anonymous inner class:
        long mc2 =
            troopers.stream().filter(new Predicate<Trooper>() {
                    public boolean test(Trooper t) {
                        return t.hasMustache();
                    }
                }).count();

        System.out.println("Mustaches: " + mc2);

        // using lambda expression:
        long mc3 =
            troopers.stream().filter(t -> t.hasMustache()).count();

        System.out.println("Mustaches: " + mc3);

        // using method reference:
        long mc4 =
            troopers.stream().filter(Trooper::hasMustache).count();

        System.out.println("Mustaches: " + mc4);


        Comparator<Trooper> byMustacheThenName =
            Comparator.comparing(Trooper::hasMustache)
            .thenComparing(Trooper::getName);

        // A sorted list of all-caps names of mustached troopers
        List<String> mustachedTroopers =
            troopers.stream()
            .filter(Trooper::hasMustache)
            .sorted(byMustacheThenName)
            .map(e -> e.getName().toUpperCase())
            .collect(Collectors.toList());

        System.out.println("Yay mustaches! " + mustachedTroopers);

        List<Integer> squares =
            Stream.of(1, 2, 3, 4)
            .map(e -> e * e)
            .collect(Collectors.toList());
        System.out.println("Squares: " + squares);
    }
}
