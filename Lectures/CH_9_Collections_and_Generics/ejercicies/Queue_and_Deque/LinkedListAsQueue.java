import java.util.LinkedList;
import java.util.Queue;

public class LinkedListAsQueue {

    public static void main(String... args) {
        Queue<Integer> queue = new LinkedList<>();

        System.out.println(queue.offer(10)); //true [10]
        System.out.println(queue.offer(4)); //true  [10 4]

        System.out.println(queue.peek()); //10 [10 4]
        System.out.println(queue.poll()); //10 [4]
        System.out.println(queue.poll()); // 4
        System.out.println(queue.peek()); //null
    }
}