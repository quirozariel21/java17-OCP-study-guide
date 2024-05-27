import java.util.Map;
//import java.util.HashTable;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.function.BiFunction;

public class MapMethods {

    public static void main(String... args) {
        // Create a Map
        Map<String, String> map1 =
            Map.of("key1", "val1", "key2", "val2");
        System.out.println("1. Using Map.of: " + map1);

        Map<String, String> map2 = Map.ofEntries(
            Map.entry("Key1", "value1"),
            Map.entry("Key2", "value2")
        );
        System.out.println("2. Using Map.ofEntries: " + map2);

        Map<String, String> map3 = Map.copyOf(map2);
        System.out.println("3. Using Map.copyOf: " + map3);

        // map2.put("key3", "value3"); // DOES NOT COMPILE because map2 is final
        Map<String, String> map = new HashMap<>();
        map.put(null, null); // COMPILE

        System.out.println("===>> Map Basic Methods <<===");
        Map<String, String> animals = new HashMap<>();
        animals.put("koala", "bamboo");
        animals.put("lion", "meat");
        animals.put("giraffe", "leaf");
        animals.put(null, "CBA");
        animals.put("Tiger", null);

        String food = animals.get("koala");// bamboo
        System.out.println("Keys");
        for(String key: animals.keySet())
            System.out.print(key + ", ");

        System.out.println("\nValues");
        for(String value: animals.values())
            System.out.print(value + ", ");

    }

}