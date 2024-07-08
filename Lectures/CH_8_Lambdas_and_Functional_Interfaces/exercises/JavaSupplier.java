import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Supplier;

public class JavaSupplier {
    public static void main(String... args) {

        Developer obj = factory(Developer::new);
        System.out.println(obj);

        Developer obj2 = factory(()-> new Developer("TEST"));
        System.out.println(obj2);
    }

    public static Developer factory(Supplier<? extends Developer> s) {
        Developer developer = s.get();
        if(developer.name == null || "".equals(developer.name)) {
            developer.name = "Default";
        }
        developer.salary = BigDecimal.ONE;
        developer.start = LocalDate.of(2024, 8, 9);

        return developer;
    }
}

class Developer {
    String name;
    BigDecimal salary;
    LocalDate start;

    public Developer() {

    }

    public Developer(String name) {
        this.name = name;
    }
}