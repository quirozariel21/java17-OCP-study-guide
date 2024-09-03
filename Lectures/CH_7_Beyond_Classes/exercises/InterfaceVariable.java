public class InterfaceVariable implements IInt {

    public static void main(String[] args) {
        InterfaceVariable s = new InterfaceVariable();
        int j = s.theValue;
        int k = IInt.theValue;
        int l = theValue;       // If you put this.theValue then it will fail

        // This will compile and run without any problem
        System.out.println("j = " + j + ", k = " + k + ", l = " + l + ", thevalue = " + thevalue);
    }
}

interface IInt {
    // By default this variable is public static final
    int theValue = 9;
}