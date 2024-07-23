import java.util.function.*;
import java.util.Map;
import java.util.HashMap;

public class BiFunctionExample {
    public static void main(String... args) {

        Map<String, String> map = new HashMap<>();
        map.put("a", "x");
        map.put("b", "x");

        //INSERT CODE HERE
        BiFunction<String, String, String> f = String::concat;

        map.merge("b", "y", f);
        map.merge("c", "y", f);

        System.out.println(map); // { a=x, b=xy, c=y }
    }
}