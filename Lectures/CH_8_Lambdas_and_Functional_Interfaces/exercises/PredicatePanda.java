import java.util.function.Predicate;

public class PredicatePanda {
    int age;

     public static void main(String... args) {
           PredicatePanda p1 = new PredicatePanda();
           p1.age = 1;
           check(p1, p -> p.age < 5);
     }

     private static void check(PredicatePanda panda, Predicate<PredicatePanda> pred) {
         String result = pred.test(panda) ? "match" : "not match";
         System.out.println(result); // match
     }
}