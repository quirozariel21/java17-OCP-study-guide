public class Stool extends Chair {
    @Override
    public void sit() throws RuntimeException {
        System.out.print("thud");
    }

    public static void main(String... args) {
        try {
            new Stool().sit();
        } finally {
            System.out.print("?");
        }
    }
}

class Chair {
    public void sit() throws IllegalArgumentException {
        System.out.println("creek");
        throw new RuntimeException();
    }
}

// It will print: thud?