public class Enclosing {
    static class Nested {
        private int price = 6;
    }

    public static void main(String args[]) {
        Nested nested = new Nested();   // Since the class is static.
        /**
         * You do not need an instance of Enclosing to use it.
         * You are allowed to access private instance variable
         */
        System.out.println(nested.price);
    }
}