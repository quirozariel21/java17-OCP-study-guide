import java.util.LinkedList;

public class DequePushClass {

    public static void main(String... args) {
        var x = new LinkedList<Integer>();
        // It is a stack FIFO
        x.offer(18); // offer() method inserts an element at the end of the List [19]
        x.offer(5); // [18, 5]
        x.push(13); // push() method inserts an element at the first of the List [13, 18, 5]
        System.out.println(x.poll() + " " + x.poll()); // prints 13 18
    }
}