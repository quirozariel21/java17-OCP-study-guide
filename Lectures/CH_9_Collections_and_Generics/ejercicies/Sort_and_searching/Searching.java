import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Searching {

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(6, 9, 1, 8);
        Collections.sort(numbers);
        System.out.println(numbers);

        System.out.println(Collections.binarySearch(numbers, 6));
        System.out.println(Collections.binarySearch(numbers, 3));

        System.out.println("\t\t\t  TRicky");
        var names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c = Comparator.reverseOrder();
        var index = Collections.binarySearch(names, "Hoppy", c);
        System.out.println("index: " + index); // -1

        /*
        Since the list is in ascending order, we do not meet the precondition for doing a search
         */

    }
}