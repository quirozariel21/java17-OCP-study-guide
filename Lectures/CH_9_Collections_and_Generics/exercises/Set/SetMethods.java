import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class SetMethods {

    public static void main(String... args) {

        System.out.println("===>> SET <<===");
        Set<Character> letter = Set.of('a', 'b');
        Set<Character> copy = Set.copyOf(letter);
        System.out.println(copy);

        System.out.println("\n===>> HASHSET <<===");
        Set<String> names = new HashSet<>();
        System.out.println(names.add("Ariel"));
        names.add("Alina");
        names.add("Gael");
        names.add("Boris");
        System.out.println(names.add("Ariel")); // false
        names.forEach(n -> System.out.println(n));// It prints Ariel, Alina, Gael because set not allow duplicate values

        System.out.println("\n===>> TREESET <<===");
        // List ordenada de manera natural, en este caso imprime Alina, Ariel, Boris, Gael
        Set<String> name2 = new TreeSet<>();
        Set<String> names2 = new TreeSet<>();
        System.out.println(names2.add("Ariel"));
        names2.add("Alina");
        names2.add("Gael");
        names2.add("Boris");
        System.out.println(names2.add("Ariel"));
        names2.forEach(n -> System.out.println(n)); // It prints Ariel, Alina, Gael because set not allow duplicate values

    }
}