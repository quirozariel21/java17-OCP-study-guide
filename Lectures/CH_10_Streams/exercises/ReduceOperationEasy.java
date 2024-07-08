import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class ReduceOperationEasy {
    public static void main(String... args) {
        List<String> paises = List.of("Argentina", "Colombia", "Mexico", "Peru", "Nicaragua");
        Stream<String> str = paises.stream();

        //int total = str.map(String::length).reduce(0, (a, b) -> a + b);                   // OPTION 1
        //Optional<Integer> total = str.map(String::length).reduce((a, b) -> a + b);        // OPTION 2
        //int total = str.reduce(0, (id, s) -> id + s.length(), (a, b) -> a + b);           // OPTION 3
        int total = str.reduce(0, (id, s) -> id + s.length(), Integer::sum);                // OPTION 3.1
        System.out.println(total);
    }
}