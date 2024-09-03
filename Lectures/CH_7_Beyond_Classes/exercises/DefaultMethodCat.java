/**
 * In order to don't compile the code you should remove or comment the lines between 6 and 9
 */

public class DefaultMethodCat implements Walk, Run{
    //Option 1
    //To compile we should override the method getSpeed(), it is MANDATORY because Walk and Run have the
    //same default method.
    @Override
    public int getSpeed() {
        return 1;
    }

    // Option 2
    public int getWalkSpeed() {
        return Walk.super.getSpeed();
        // return Walk.getSpeed(); // DOES NOT COMPILE error: non-static method getSpeed() cannot be referenced from a static context
    }

    public static void main(String[] args) {
        // System.out.println(new DefaultMethodCat().getSpeed());       // OPTION 1
        System.out.println(new DefaultMethodCat().getWalkSpeed());      // OPTION 2
    }
}

interface Walk {
    public default int getSpeed() { return 5; }
}

interface Run {
    // public is implicit so it can be removed.
    default int getSpeed() { return 10; }
}