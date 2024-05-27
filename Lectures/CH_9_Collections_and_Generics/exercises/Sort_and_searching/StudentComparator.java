import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentComparator {

    private int id;
    private String name;

    public StudentComparator(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "id= "+ this.id + " name= " + this.name;
    }

    public static void main(String... args) {
        var e1 = new StudentComparator(10, "Gael");
        var e2 = new StudentComparator(3, "Alina");
        var e3 = new StudentComparator(5, "Julian");

        List<StudentComparator> students = Arrays.asList(e1, e2, e3);
        System.out.println("Original: \t" + students);

        /*
        // Optoin 1. Creating a nested class
        Comparator<StudentComparator> btId = new Comparator<StudentComparator>() {

            @Override
            public int compare(StudentComparator e1, StudentComparator e2) {
                return e1.id - e2.id;
            }
        };
        */

        //Option 2. Using methods of the class Comparator
        Comparator<StudentComparator> byId = Comparator.comparing(e -> e.id);
        // 2.1. Order by id and reversing(DESC)
        // Comparator<StudentComparator> byId = Comparator.comparing(e -> e.id).reversed();
        // 2.2. Multiple fields
        Comparator<StudentComparator> byIdThenName = Comparator.comparing(StudentComparator::getId)
                                                               .thenComparing(StudentComparator::getName);

        // Option 3. Collections methods
        Collections.sort(students, byId);
        Collections.sort(student, byIdThenName);
        System.out.println("OrderById: \t" + students);

        students.sort(byId);
        System.out.println("OrderById: \t" + students);
    }

}