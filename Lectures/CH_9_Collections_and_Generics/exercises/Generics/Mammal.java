class Mammal {}
class Bat extends Mammal {}
class Cat extends Mammal {}
class Sat {}

class Fur<? extends Mammal> {   // FAILES HERE BECAUSE '?' IS NOT ALLOWED, IT SHOULD BE T

    void clean() {
        var bat = new Fur<Bat>();
        var cat = new Fur<Cat>();
        var sat = new Fur<Sat>();
    }
}
