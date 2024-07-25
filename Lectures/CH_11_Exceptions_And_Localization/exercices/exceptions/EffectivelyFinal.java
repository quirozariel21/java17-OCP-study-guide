/*
Output:
Try block
Closed: 5
Closed: 6
Closed: 4
Finally block
 */


public class EffectivelyFinal {

    public static void main(String[] args) {
        final var bookReader = new MyFileReader("4"); // It is final
        MyFileReader movieReader = new MyFileReader("5"); // it is effectively final

        try(bookReader; var tvReader = new MyFileReader("6"); movieReader) {
            // The close of the resources is after to enter to try block
            System.out.println("Try block");
        } finally {
            System.out.println("Finally block");
        }

        //movieReader = null; // It will become in a not effective final variable and it won't compile

    }
}

class MyFileReader implements AutoCloseable {
    private String tag;

    public MyFileReader(String tag) {
        this.tag = tag;
    }

    @Override
    public void close() {
        System.out.println("Closed: " + tag);
    }
}