public class ClimberFunctionalInterface {
    public static void main(String... args) {
        check((h, m) -> h.append(m).isEmpty(), 5); // Compiler ERRor
    }

    private static void check(Climb climb, int height) {
        if (climb.isTooHigh(height, 10)) {
            System.out.println("too hight");
        }else {
            System.out.println("OK");
        }

    }
}

@FunctionalInterface
interface Climb {
    boolean isTooHigh(int height, int limit);
}