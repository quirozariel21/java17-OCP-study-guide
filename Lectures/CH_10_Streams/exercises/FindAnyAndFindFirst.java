import java.util.List;

public class FindAnyAndFindFirst {
  public static void main(String... args) {
      var list = List.of('c', 'b', 'a');

      list.stream()
          .sorted()
          .findAny()
          .ifPresent(System.out::println);

      System.out.println(list.stream().sorted().findFirst());
  }
}