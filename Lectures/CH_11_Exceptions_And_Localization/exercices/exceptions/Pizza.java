//java.lang.IllegalArgumentException is printed.

public class Pizza {

    Exception order(RuntimeException e) {
        throw e;
    }

    public static void main(String args[]) {
        var p = new Pizza();

        try {
            p.order(new IllegalArgumentException());
        } catch(RuntimeException e) {
            System.out.print(e);
        }
    }
}