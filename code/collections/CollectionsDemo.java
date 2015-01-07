import java.util.*;

public class CollectionsDemo {

    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Alan", "Ada", "Alan");
        Set<String> nameSet = new HashSet<>(nameList);
        System.out.println("nameSet:" + nameSet);

        Map<String, String> capitals = new HashMap<>();
        capitals.put("Georgia", "Atlanta");
        capitals.put("Alabama", "Montgomery");
        capitals.put("Florida", "Tallahassee");
        for (String state: capitals.keySet()) {
            System.out.println("Capital of " + state + " is "
                               + capitals.get(state));
        }
    }
}
