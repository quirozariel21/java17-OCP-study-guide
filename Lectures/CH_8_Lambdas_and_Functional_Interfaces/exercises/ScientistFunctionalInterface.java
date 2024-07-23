
public class ScientistFunctionalInterface {

    public static void main(String... args) {
        //final Study s = new BiologyMaterial();      //h1
        //final Study s = (a, b) -> 1; // Compiles but it produces another result = 1
        final Study s = (x, y) -> { return x == null ? y : y + 1; }; // It produces same result as BiologyMaterial method
        System.out.println(s.learn(args[0], Integer.parseInt(args[1])));
    }
}

@FunctionalInterface
interface Study {
    abstract int learn(String subject, int duration);
}

class BiologyMaterial implements Study {

    @Override
    public int learn(String subject, int duration) {
        if(subject == null)
            return duration;
        else
            return duration + 1;
    }
}