/*
In Java, the IntToLongFunction interface is a functional interface that represents a funtion that
accepts an int valued argument and produces a long result.
 */
import java.util.function.*;


public class IntToLongFunctionExample {

    public static void main(String... args) {

        System.out.println("====== EXAMPLE 1");
        IntToLongFunction intToLong = (value) -> (long) value;
        long result = intToLong.applyAsLong(5);
        System.out.println("Converted Value: " + result);

        System.out.println("\n\n ====== EXAMPLE 2");
        IntToLongFunction multiplyByFactor = (value) -> value * 1000L;
        result = multiplyByFactor.applyAsLong(3);
        System.out.println("Multiplied Value: " + result);

        System.out.println("\n\n ====== EXAMPLE  3 - Real-World Use Case: Converting Seconds to Milliseconds");
        IntToLongFunction secondsToMillis = (seconds) -> seconds * 1000L;
        long milliseconds = secondsToMillis.applyAsLong(60);
        System.out.println("Milliseconds: " + milliseconds);




    }
}