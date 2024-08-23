public class Dinosaur {

    class Pterodactyl extends Dinosaur {}

    public void roar() {
        var dino = new Dinosaur();

        /**
         * The code compiles with these options
         */
        dino.new Pterodactyl();         // Option 1

        new Dinosaur.Pterodactyl();     // Option 2
    }
}
