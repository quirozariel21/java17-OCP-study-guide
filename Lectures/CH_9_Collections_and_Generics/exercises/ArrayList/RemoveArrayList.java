import java.util.ArrayList;

public class RemoveArrayList {

    public static void main(String... args) {
        ArrayList<Integer> enteros = new ArrayList<>();
        enteros.add(Integer.valueOf(0));
        enteros.add(Integer.valueOf(4));
        enteros.add(Integer.valueOf(6));

        System.out.println(enteros);
        System.out.println("remove pos 0:" + enteros.remove(0));                        // removing by pos
        System.out.println("remove value 4: " + enteros.remove(Integer.valueOf(4)));    // removing by value
        System.out.println(enteros);
    }
}