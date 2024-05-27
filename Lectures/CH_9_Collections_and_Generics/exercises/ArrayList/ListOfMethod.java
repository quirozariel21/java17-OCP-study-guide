import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class ListOfMethod {

    public static void main(String... args) {
        var integerArray = new Integer[] {1, null, 2};
        //var integerList = List.of(integerArray);                //NullPointerException
        // List.of() and List.copyOf() does not support null elemnts

        var integerArray2 = new Integer[] {1, 2, 3};
        var integerList = List.of(integerArray2);
        var integerCollection = Collections.unmodifiableList(integerList);
        integerArray[1] = 0;
        //integerCollection.set(1, 0);        //UnsupportedOperationException
        System.out.println(Arrays.toString(integerArray) + "  " + integerCollection);
    }
}