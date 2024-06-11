import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.BiPredicate;

public class PredicateClass {

    public static void main(String... args) {

        List<Alumno> list = new ArrayList<>();
        list.add(new Alumno(20, "Juan"));
        list.add(new Alumno(18, "Carlos"));
        list.add(new Alumno(10, "Pedro"));

        Predicate<Alumno> p1 = a -> a.nota > 11;
        Predicate<Alumno> p2 = a -> a.nombre.startsWith("J");
        Predicate<Alumno> p3 = (Alumno a) -> { return a.nota > 9 && a.nota < 15; };
        Predicate<Alumno> p4 = (var a) -> a.nombre.startsWith("C");
        Predicate<Alumno> p5 = a -> { return a.nota > 15; };

        System.out.println("=======>>> Predicate 1 <<<========");
        imprimirListado(list, p1);
        System.out.println("=======>>> Predicate 3 <<<========");
        imprimirListado(list, p3);
        System.out.println("=======>>> Predicate 4 <<<========");
        imprimirListado(list, p4);
        System.out.println("=======>>> Predicate  5 <<<========");
        imprimirListado(list, p5);

        System.out.println("===>> Bi Predicate <<===");
        BiPredicate<Alumno, Integer> bp1 = (alum, inc) -> alum.nota + inc > 11;
        BiPredicate<Alumno, String> bp2 = (var a, var inicial) -> a.nombre.startsWith(inicial); // COMPILE and WORKS!

        System.out.println("===>> Bi Predicate 1 <<===");
        imprimirListado(list, bp1, 2);
        System.out.println("===>> Bi Predicate 2 <<===");
        imprimirListado(list, bp2, "P");
    }

    public static void imprimirListado(List<Alumno> alumnos, Predicate<Alumno> predicate) {
        for (Alumno a: alumnos) {
            if(predicate.test(a)) {
                System.out.println(a);
            }
        }
    }

    public static void imprimirListado(List<Alumno> alumnos,
                                       BiPredicate<Alumno, Integer> predicate,
                                       Integer incremento) {
        for (Alumno a: alumnos) {
            if(predicate.test(a, incremento)) {
                System.out.println(a);
            }
        }
    }

    public static void imprimirListado(List<Alumno> alumnos,
                                       BiPredicate<Alumno, String> predicate,
                                       String inicial) {
        for (Alumno a: alumnos) {
         if (predicate.test(a, inicial)) {
             System.out.println(a);
         }
        }
    }
}

class Alumno {
    public int nota;
    public String nombre;

    public Alumno(int nota, String nombre){
        this.nota = nota;
        this.nombre = nombre;
    }

    public int getNota(){
        return this.nota;
    }

    public String getNombre(){
        return this.nombre;
    }

    @Override
    public String toString(){
        return this.nombre + "=" + this.nota;
    }
}