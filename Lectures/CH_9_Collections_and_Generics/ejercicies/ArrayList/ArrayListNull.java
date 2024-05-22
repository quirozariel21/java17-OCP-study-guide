import java.util.ArrayList;


public class ArrayListNull {

    public static void main(String... args) {
        ArrayList list = new ArrayList(); //ArrayList<Object> list = new ArrayList<>(); are the same
        list.add("text");
        list.add(12);
        list.add(1.5f);
        list.add('a');

        System.out.println("==>ArrayList<==");
        for (Object o : list) {
            System.out.println(o);
        }
    }
}