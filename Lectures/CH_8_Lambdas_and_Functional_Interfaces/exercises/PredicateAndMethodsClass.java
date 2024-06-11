import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateAndMethodsClass {

    public static void main(String... args) {

        List<Alumno> list = new ArrayList<>();
        list.add(new Alumno(20, "Juan", true));
        list.add(new Alumno(15, "Carlos", false));
        list.add(new Alumno(11, "Pedro", true));
        list.add(new Alumno(8, "Olga", false));

        Predicate<Alumno> nota = (Alumno a) -> { return a.nota > 11; };
        Predicate<Alumno> habilitacion = (var a) -> a.habilitado;
        Predicate<Alumno> notaAndHabilitado = nota.and(habilitacion);
        Predicate<Alumno> notaAndNotHabilitado = nota.and(habilitacion.negate());
        Predicate<Alumno> notaOrHabilitado = nota.or(habilitacion);

        for(Alumno a: list) {
            if(notaAndNotHabilitado.test(a)) {
                System.out.println(a);
            }
        }
    }
}

class Alumno {
    public int nota;
    public String nombre;
    public boolean habilitado;

    public Alumno(int nota, String nombre, boolean habilitado){
        this.nota = nota;
        this.nombre = nombre;
        this.habilitado = habilitado;
    }

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

    public boolean getHabilitado(){
        return this.habilitado;
    }

    @Override
    public String toString(){
        return this.nombre + "=" + this.nota + " - " + this.habilitado;
    }
}