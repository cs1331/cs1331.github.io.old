import java.util.*;

public class HashTroopers {

    static class HashTrooper extends Trooper {

        public HashTrooper(String name, boolean hasMustache) {
            super(name, hasMustache);
        }

        // This class has a properly overriden hashCode
        @Override public int hashCode() {
            int result = 17;
            result = 31 * result + getName().hashCode();
            result = 31 * result + (hasMustache() ? 1 : 0);
            return result;
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

        System.out.println("\nUsing Trooper without properly overriden"
            + " hashCode()");

        // Notice that you can create a new collection by passing an
        // existing collection to the constructor.  This is a
        // convention in the collections framework, but is not
        // guaranteed by any language feature of Java.
        Set<Trooper> trooperSet = new HashSet<>(troopers);

        // Notice that duplicates aren't removed because Trooper doesn't
        // properly override hashCode()
        System.out.println("\nAs a set:\n" + trooperSet);

        // Mac gets different hashcodes for distinct instances -
        // not what we want
        System.out.println("Mac's hashCode: "
            + new Trooper("Mac", true).hashCode());
        System.out.println("Mac's hashCode: "
            + new Trooper("Mac", true).hashCode());

        // Mac is in the set, but we don't find him because we didn't
        // override hashCode().
        System.out.println("\nOops!  Didn't override hashCode():");
        System.out.println("trooperSet.contains(new Trooper(\"Mac\", true))="
            + trooperSet.contains(new Trooper("Mac", true)));

        System.out.println("\nNow using HashTrooper with properly overriden"
            + " hashCode()");

        List<HashTrooper> hTroopers = new ArrayList<>();
        hTroopers.add(new HashTrooper("Thorny", true));
        hTroopers.add(new HashTrooper("Farva", true));
        hTroopers.add(new HashTrooper("Farva", true));
        hTroopers.add(new HashTrooper("Ursula", false));
        hTroopers.add(new HashTrooper("Rabbit", false));
        hTroopers.add(new HashTrooper("Mac", true));
        hTroopers.add(new HashTrooper("Foster", true));

        Set<HashTrooper> hTrooperSet = new HashSet<>(hTroopers);

        // Notice that duplicates are removed, which is good, 'cuz who
        // needs two Farvas?
        System.out.println("\nAs a set:\n" + hTrooperSet);

        // Mac now has same hashcode for distinct instances, as he should
        System.out.println("Mac's hashCode: "
            + new HashTrooper("Mac", true).hashCode());
        System.out.println("Mac's hashCode: "
            + new HashTrooper("Mac", true).hashCode());

        // Mac is in the set, we find him because HashTrooperj properly
        // overrides hashCode().
        System.out.println("hTrooperSet.contains("
            + "new HashTrooper(\"Mac\", true))="
            + hTrooperSet.contains(new HashTrooper("Mac", true)));
    }

}
