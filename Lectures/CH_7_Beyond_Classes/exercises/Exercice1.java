public class Exercice1 {
    public static void main(String... args) {
        Movable m = new Donkey();
        m.move(10);
        m.moveBack(20);
        System.out.println(m.location); // Output: 0 because the variable "m" is the type Movable
    }

}

interface Movable {
    int location = 0;
    void move(int a);
    public void moveBack(int b);
}

class Donkey implements Movable {
    int location = 200;

    public void move(int a) {
        System.out.println("1. location: " + location);
        location = location + a;        // 200 + 10 = 210
        System.out.println("1. res: " + location);
    }

    public void moveBack(int a) {
        System.out.println("2.locatoin: " + location);
        location = location - a;        // 210 - 20 = 190
        System.out.println("2. res: " + location);
    }
}