import java.util.TreeSet;

public class TreeSetSubset {

    public static void main(String[] args) {
        TreeSet<Integer> s = new TreeSet<Integer>();
        TreeSet<Integer> subs = new TreeSet<Integer>();

        for(int i = 324; i<=328; i++) {
            s.add(i);
        }

         /*
         The returned subset is backed by the original set. So if you insert or remove an element
         from the subset, the same will be reflected on the original set.  Further, since the
         subset is created using a range (fromElement to toElement), the element that you are
         inserting must fall within that range. Otherwise an IllegalArgumentException is thrown
         with a message "key out of range.". This is what is happening in this question. The range
         of subs is 326 to 328 and 329 is out of that range. Therefore, an
         IllegalArgumentException is thrown at runtime.
         */
        subs = (TreeSet) s.subSet(326, true, 328, true );
        subs.add(329); // ERROR at runtime
        // Exception in thread "main" java.lang.IllegalArgumentException: key out of range
        System.out.println(s+" "+subs);
    }
}
