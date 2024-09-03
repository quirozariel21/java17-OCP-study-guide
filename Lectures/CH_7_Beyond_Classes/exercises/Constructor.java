public class Constructor {
    private int myValue = 0;        // member field

    public void showOne(int myValue) {
        /**
         * If you declare a local varaible with the same name as the instance field name,
         * the local variable "shadows" the memeber field
         */
        myValue = myValue;
    }

    public void showTwo(int myValue) {
        this.myValue = myValue;
    }

    public static void main(String... args) {
        var ct = new Constructor();
        ct.showTwo(200);
        System.out.println("showTwo: " + ct.myValue);   // it won't fail despite to the variable myValue is private

        ct.showOne(100);
        System.out.println("showOne: " + ct.myValue);

        // Output: 200 and 200
    }
}