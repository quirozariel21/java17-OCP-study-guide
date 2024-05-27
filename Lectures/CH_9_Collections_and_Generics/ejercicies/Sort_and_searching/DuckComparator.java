import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DuckComparator implements Comparable<DuckComparator> {
    private String name;
    private int weight;

    public DuckComparator(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "DuckComparator{" +
            "name='" + name + '\'' +
            '}';
    }

    @Override
    public int compareTo(DuckComparator d) {
        return name.compareTo(d.name);
    }

    public static void main(String... args) {
        // Comparator<DuckComparator> byWeight = (d1, d2) -> d1.getWeight() - d2.getWeight(); using function
        // Comparator<DuckComparator> byWeight = Comparator.comparing(DuckComparator::getWeight); using method reference
        Comparator<DuckComparator> byWeight = new Comparator<DuckComparator>() {
            @Override
            public int compare(DuckComparator d1, DuckComparator d2) {
                return d1.getWeight() - d2.getWeight();
            }
        };

        var ducks = new ArrayList<DuckComparator>();
        ducks.add(new DuckComparator("Quack", 7));
        ducks.add(new DuckComparator("Puddles", 10));
        System.out.println("----> Comparable");
        Collections.sort(ducks);
        System.out.println(ducks);

        System.out.println("----> Comparator");
        Collections.sort(ducks, byWeight);
        System.out.println(ducks);
    }
}