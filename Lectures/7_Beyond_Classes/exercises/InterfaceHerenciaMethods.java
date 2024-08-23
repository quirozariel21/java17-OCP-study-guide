public class InterfaceHerenciaMethods {
    public static void main(String... args) {
        // Office off = new HoleOffice();
        House off = new HomeOffice();
        off.lockTheGates();
        // In both cases Office and House It will compile fine and print 'Locking HomeOffice' when it runs
    }
}

interface House {
    public default void lockTheGates() {        // public is redundant
        System.out.println("locking House");
    }
}

interface Office {
    public void lockTheGates(); // public is redundant because y default this method is public abstract
}

class HomeOffice implements House, Office {

    public void lockTheGates() {
        System.out.println("Locking HomeOffice");
    }
}