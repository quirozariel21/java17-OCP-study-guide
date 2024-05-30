public class MyGenericAndMethodClass {

    public static void main(String... args) {
        MyGenericClass gc = new MyGenericClass();
        System.out.println(gc.transform(1));
        System.out.println(gc.transform("hello"));


        MyGenericClass<String> gcStr = new MyGenericClass<>();
        System.out.println(gcStr.transform(1.1));

    }
}

class MyGenericClass<T> {
    public <T> String transform(T t) {
        return t.toString() + "-" + t.hashCode();
    }
}