import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentComparableInterface implements Comparable<StudentComparableInterface> {

    int rollno;
    String name;
    int age;

    public StudentComparableInterface(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(StudentComparableInterface st) {
        if(this.age == st.age) return 0;

        if(this.age > st.age) // Order reverse must be this.age < st.age
            return 1;
        else
            retun -1;
    }

    public static void main(String... args) {
        StudentComparableInterface st1 = new StudentComparableInterface(101, "Juan", 23);
        StudentComparableInterface st2 = new StudentComparableInterface(106, "Alan", 27);
        StudentComparableInterface st3 = new StudentComparableInterface(105, "Rafael", 21);

        //List<StudentComparableInterface> list = List.of(new StudentComparableInterface[]{st1, st2, st3});
        ArrayList<StudentComparableInterface> list = new ArrayList<>();
        list.add(st1);
        list.add(st2);
        list.add(st3);

        Collections.sort(list);
        for(StudentComparableInterface st:list){
            System.out.println(st.rollno+" "+st.name+" "+st.age);
        }
    }
}