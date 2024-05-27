import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetExample {

    /*
    public Navigable<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)

    parameters:
        fromElement = This is the low endpoint of the returned set.
        fromInclusive = This is true if the low endpoint is to be included in the returned value.
        toElement = this is the high endpoint of the returned set.
        toInclusive = this is true of the high endpoint is to be included in the returned view.
     */
    public static void main(String... args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        TreeSet<Integer> treeSubSet = new TreeSet<>();

        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);
        treeSet.add(7);

        treeSubSet = (TreeSet) treeSet.subSet(3, true, 7, true);

        Iterator iterator = treeSubSet.iterator();

        System.out.println("TReeSet Data:");
        while(iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
        // OUTPUT: 3, 4, 5, 6, 7

    }
}