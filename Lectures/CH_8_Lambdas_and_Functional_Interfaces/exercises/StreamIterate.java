import java.util.stream.*;
import java.util.*;

public class StreamIterate {
    public static void main(String... args) {
        Stream.iterate(1, x -> x + 1)   //1, 2, 3, 4, 5, 6, 7, 8, ...
            .limit(5)   // 1, 2, 3, 4, 5
            .skip(2)    // 3, 4, 5
            .peek(System.out::print)    //345
            .collect(Collectors.toList()) // [3,4,5]
            .forEach(System.out::print); //345345
    }
}