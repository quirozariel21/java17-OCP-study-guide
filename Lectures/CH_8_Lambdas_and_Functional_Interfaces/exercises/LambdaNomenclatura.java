public class LambdaNomenclatura {
    public static void main(String[] args) {
        print(() -> System.out.println("Primera forma de escribir un Lambda"));
    }

    public static void print(Template t) {
        t.print();
    }
}

@FunctionalInterface
interface Template {
    void print();
}