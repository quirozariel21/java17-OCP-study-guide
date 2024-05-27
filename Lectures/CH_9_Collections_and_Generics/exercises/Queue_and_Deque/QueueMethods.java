import java.util.Queue;
import java.util.LinkedList;

public class QueueMethods {

    public static void main(String... args) {
        Queue<Integer> queue = new LinkedList<>();
        //System.out.println(queue.element()); // This method throws an exception(NoSuchElementException) because there are no elements
        System.out.println(queue.peek()); // null

        System.out.println("\n===>> Adding <<===");
        System.out.println(queue.offer(100));   // true [100]
        System.out.println(queue.offer(4));     // true [100 4]
        System.out.println(queue.offer(40));    // true [100 4 40]
        System.out.println(queue.add(50));      // true [100 4 40 50]
        System.out.println(queue.add(500));     // true [100 4 40 50 500]

        System.out.println(queue);

        System.out.println("\n===>> Reading from the head <<===");
        System.out.println(queue.element());    // 100 [100 4 40 50 500]
        System.out.println(queue.peek());       // 100 [100 4 40 50 500]
        System.out.println(queue);

        System.out.println("\n===>> Removing from the head <<===");
        System.out.println(queue.poll());       // 100 [4 40 50 500]
        System.out.println(queue.peek());       // 4 [4 40 50 500]
        System.out.println(queue.remove());     // 4 [40 50 500]
        System.out.println(queue.peek());       // 40 [40 50 500]
        System.out.println(queue);

        System.out.println(queue.poll());       // 40 [50 500]
        System.out.println(queue.poll());       // 50 [500]
        System.out.println(queue.poll());       // 500 []
        System.out.println(queue.poll());       // null
        System.out.println(queue);

        System.out.println(queue.remove()); //If there is no elments then it returns java.util.NoSuchElementException
    }
}