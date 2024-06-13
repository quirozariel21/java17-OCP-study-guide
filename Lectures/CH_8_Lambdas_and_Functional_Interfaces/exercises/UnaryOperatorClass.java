import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;

public class UnaryOperatorClass {

    public static void main(String[] args) {

        System.out.println("===>> Unary Operator <<===");
        UnaryOperator<String> u1 = s -> s.concat(" JAVA");
        System.out.println(u1.apply("Languaje "));

        System.out.println("===>> Binary Operator <<===");
        BinaryOperator<String> b1 = (str, toAdd) -> str.concat(toAdd.toUpperCase());
        System.out.println(b1.apply("Languaje ", "COBOL"));
    }
}