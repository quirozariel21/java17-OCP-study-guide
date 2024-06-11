import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

/*
    The method andThen only works in a Consumer and in a Function
 */
public class AndThenMethod {

    public static void main(String... args) {

        List<Alumno> list = new ArrayList<>();
        list.add(new Alumno(20, "Juan", true));
        list.add(new Alumno(15, "Carlos", false));
        list.add(new Alumno(11, "Pedro", true));
        list.add(new Alumno(8, "Olga", false));

        Consumer<Alumno> actNota = a -> a.nota = a.nota + 2;
        Consumer<Alumno> imprimir = a -> System.out.println(a);
        Consumer<Alumno> actNotaAndImprimir = actNota.andThen(imprimir);

/*        for(Alumno a: list) {
            actNotaAndImprimir.accept(a);
        }*/

        Function<Alumno, String> actNota2 = a -> {
            a.nota++;
            return a;
        };

        Function<Alumno, String> imprimir2 = a -> a.toString();
        Function<Alumno, String> compuesto = imprimir2.compose(actNota2);

        for(Alumno a: list) {
            System.out.println(compuesto.apply(a));
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
        return "Nombre:" + this.nombre + ", " + "Nota:" + this.nota + ", " + " Habilitado:" + this.habilitado;
    }
}