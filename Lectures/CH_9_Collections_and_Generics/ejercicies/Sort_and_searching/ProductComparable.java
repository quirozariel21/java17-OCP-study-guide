import java.util.Collections;
import java.util.ArrayList;

public class ProductComparable implements Comparable<ProductComparable> {
    private int id;
    private String name;

    public int hashCode() {
        return id;
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof ProductComparable)) return false;
        var other = (ProductComparable) obj;
        return this.id == other.id;
    }

    @Override
    public int compareTo(ProductComparable o1) {
        //return this.name.compareTo(o1.name); //ASC
        return o1.name.compareTo(this.name); //DESC
    }

    public static void main(String... args) {
        ProductComparable obj1 = new ProductComparable();
        obj1.id = 3;
        obj1.name = "C";

        ProductComparable obj2 = new ProductComparable();
        obj2.id = 1;
        obj2.name = "A";

        ProductComparable obj3 = new ProductComparable();
        obj3.id = 2;
        obj3.name = "B";

        ProductComparable obj4 = new ProductComparable();
        obj4.id = 1;
        obj4.name = "A";

        ArrayList<ProductComparable> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);

        Collections.sort(list);
        for (ProductComparable p : list) {
            System.out.println(p.id + " "+ p.name);
        }
    }
}