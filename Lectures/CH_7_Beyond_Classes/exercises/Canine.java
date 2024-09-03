public class Canine {

    public String woof(int bark) {
        /**
         * A primitive variable does not have the method toString()
         * return "1" + bark.toString() does not compile
         */
        System.out.println("Method 1");
        return "1" + bark;
    }

    public String woof(Integer bark) {
        System.out.println("Method 1");
        return "2" + bark.toString();
    }

    public String woof(Object bark) {
        return "3" + bark.toString();
    }

    public static void main(String... args) {
        /**
         * System.out.println(woof((short)5));  -> NO COMPILE
         * NO COMPILE, because a static method cannot access to a instance method, so you
         * have to create an instance of the class Canine and call the method woof.
         */
        Canine c = new Canine();
        System.out.println(c.woof((short)5));   // Output: 15
    }
}