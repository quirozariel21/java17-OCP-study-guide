import java.util.function.Supplier;

/*
 Suppler function useful to get data, it does not have input parameters
 */
public class SupplierExercise {
    public static void main(String... args) {
        int length = 3;

        for (int i = 0; i < 3; i ++) {
            if (i % 2 == 0) {
                Supplier<Integer> supplier = () -> length;
                System.out.println(supplier.get());
            } else {
                int j = i;
                Supplier<Integer> supplier = () -> j;
                System.out.println(supplier.get());
            }
        }
    }

}