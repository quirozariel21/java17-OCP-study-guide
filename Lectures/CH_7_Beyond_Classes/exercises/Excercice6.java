public class Excercice6 {
    void test(Integer x) {
        System.out.println("In Integer");
    }

    void test(Object x) {
        System.out.println("In Object");
    }

    void test(Long x) {
        System.out.println("In Long");
    }

    public static void main(String[] args) {
        Excercice6 obj = new Excercice6();
        obj.test("hello");      // Output: In Object
    }
}