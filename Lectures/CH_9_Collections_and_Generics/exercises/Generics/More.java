import java.util.List;
public class More {

    public static <T> void sink(T t) {
        System.out.println("My generic: " + t);
    }

    public static <T> T identity(T t) {
        System.out.println("Identity: " + t);
        return t;
    }

    public static void main(String... args) {
        More.sink("Hola");
        More.identity(new Integer(10));

        // ANOTHER SINTAX TO CALL GENERIC METHOD
        More.<String>sink("Another syntax");
        More.<Integer>identity(new Integer(4));
    }
}