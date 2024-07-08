import java.util.*;
public class ReduceOperation {
    public String concat1(List<String> values) {

        return values.parallelStream()
            // reduce(String identity, BinaryOperator<String> accumulator)
            .reduce("a",
                    (x, y) -> x+y,
                    String::concat
            );
    }

    public String concat2(List<String> values) {
        return values.parallelStream()
            // reduce(BinaryOperator<String> accumulator) // Los dos tipos de entrada son igual que de salida
            .reduce((w, z) -> z+w) // return Optional<Integer>
            .get();
    }

    public static void main(String... args) {
        ReduceOperation c = new ReduceOperation();
        var list = List.of("Cat", "Hat");
        String x = c.concat1(list); // a + Cat = aCat => aCat + Hat = aCatHat
        String y = c.concat2(list); // (Cat, Hat) -> Hat + Cat = HatCat
        System.out.println(x + " " + y);        //aCataHat HatCat
    }
}