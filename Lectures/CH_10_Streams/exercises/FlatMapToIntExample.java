import java.util.*;
import java.util.stream.IntStream;

/*
Strean flatMapToInt(Function mapper) returns an IntStream consisting of the results of replacing each
element of this stream with the contents of a mapped stream produced by applying the provided
mapping function to each element.
 */
public class FlatMapToIntExample {

    public static void main(String... args) {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");

        System.out.println("\n\n ====== EXAMPLE 1");
        list.stream().flatMapToInt(num -> IntStream.of(Integer.parseInt(num)))
            .forEach(System.out::println);

        System.out.println("\n\n ====== EXAMPLE 2");
        // Creating a List of Strings
        list = Arrays.asList("Geeks", "GFG",
            "GeeksforGeeks", "gfg");

        list.stream().flatMapToInt(str -> IntStream.of(str.length()))
            .forEach(System.out::println);
    }
}