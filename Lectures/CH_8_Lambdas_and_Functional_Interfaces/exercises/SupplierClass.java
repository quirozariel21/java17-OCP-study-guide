import java.util.List;
import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierClass {

    public static void main(String... args) {
        List<Alumno> list = new ArrayList<>();
        list.add(new Alumno(20, "Juan"));
        list.add(new Alumno(18, "Carlos"));
        list.add(new Alumno(10, "Pedro"));

        Supplier<Alumno> s1 = () -> list.get(0);
        Supplier<Alumno> s2 = () -> new Alumno(32, "Gael");
        Supplier<Alumno> s3 = () -> {
            list.get(0).nota = 22;
            return list.get(0);
        };
        Supplier<String> s4 = () -> { return list.get(1).nombre; };

        System.out.println("===>> Supplier <<===");
        System.out.println(setAlumno(s1));
        System.out.println(setAlumno(s2));
        System.out.println(setAlumno(s3));
        System.out.println(getAlumnoName(s4));
    }

    public static Alumno setAlumno(Supplier<Alumno> supplier) {
        return supplier.get();
    }

    public static String getAlumnoName(Supplier<String> supplier) {
        return supplier.get();
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