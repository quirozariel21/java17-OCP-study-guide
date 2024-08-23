public class InterfacePrivateMethodSchedule {

    // We can have many default methods
    default void wakeUp() { checkTime(7); }
    default void haveBreakfast() { checkTime(9); }
    default void haveLunch() { checkTime(12); }
    default void workOut() { checkTime(18); }

    /**
     * Private methods are new since Java 9
     *  and it has created to reduce the duplicated code
     */
    private void checkTime(int hour) {
        if ( hour > 17 ) {
            System.out.println("you are late!");
        } else {
            System.out.println("you have bla bla bla");
        }
    }

    private static void methodTest() {
        System.out.println("Method test works!");
    }
}