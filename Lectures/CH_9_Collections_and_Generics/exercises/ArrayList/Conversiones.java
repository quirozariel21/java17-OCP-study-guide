import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Conversiones {

    public static void main(String[] args) {
        //From list to Array
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);

        Integer[] integerArraysFixed = numbers.toArray(new Integer[0]);
        Integer[] integerArraysNoFixed = numbers.toArray(new Integer[10]);

        System.out.println(integerArraysFixed.length);   //3
        System.out.println(integerArraysNoFixed.length); //10

        numbers.clear();
        System.out.println(Arrays.toString(integerArraysNoFixed)); //[1, 3, 5, null, null, null, null, null, null, null]

        System.out.println("===>> Listas Finales <<===");
        String[] stringArray = {"Ariel", "Alina"};
        List<String> names = Arrays.asList(stringArray);
        System.out.println("Original names: " + names);
        names.set(0, "Gael"); //Se modifica names pero tambien se modifica automaticamente stringArray
        System.out.println("Modified names: " + names);                              //[Gael, Alina]
        System.out.println("Modified stringArray: " + Arrays.toString(stringArray)); //[Gael, Alina]
        //names.add("Chi"); // Error al compilar UnsorpportedOperationException
        //names.clear(); // Error al compilar UnsorpportedOperationException

        List<String> cats = List.of("cody", "bola de pelos");
        //list2.add("Chi"); // Error al compilar UnsorpportedOperationException
        //list2.set(1, "Chi"); // Error al compilar UnsorpportedOperationException
        //list2.remove(1); // Error al compilar UnsorpportedOperationException


    }
}