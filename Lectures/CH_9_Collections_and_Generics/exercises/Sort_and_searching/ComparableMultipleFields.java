import java.util.ArrayList;
import java.util.Collections;

public class ComparableMultipleFields {

    public static void main(String... args) {
        ArrayList<Address> al = new ArrayList<>();
        al.add(new Address("dupont", "281"));
        al.add(new Address("sharview", "281"));
        al.add(new Address("yorkmont", "112"));

        Collections.sort(al);

        for(Address a: al){
            System.out.println(a.street + " " + a.zip);
        }
		/*
			yorkmont 112
			dupont 281
			sharview 281
		*/

    }
}

class Address implements Comparable<Address> {
    String street;
    String zip;

    public Address(String street, String zip){
        this.street = street;
        this.zip = zip;
    }

    @Override
    public int compareTo(Address o) {
        int x = this.zip.compareTo(o.zip);
        return x == 0 ? this.street.compareTo(o.street) : x;
    }
}