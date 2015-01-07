import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTroopers {

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

        long mustaches =
            troopers.stream().filter(Trooper::hasMustache).count();

        long nonMustaches =
            troopers.stream().filter(e -> !e.hasMustache()).count();

        System.out.println("Mustaches: " + mustaches);
        System.out.println("Non-Mustaches: " + nonMustaches);

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
