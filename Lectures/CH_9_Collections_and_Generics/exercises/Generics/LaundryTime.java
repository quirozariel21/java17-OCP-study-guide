
public class LaundryTime {
    public static void main(String... args) {
        /*
         ALL OF THESE CAN INITIALIZE THE WASH OBJECT
         */
        //var wash = new Wash<String>();
        //var wash = new Wash();
        //Wash wash = new Wash<String>();
        //Wash wash = new Wash();
        //Wash<String> wash = new Wash();
        Wash<String> wash = new Wash<String>();
        wash.clean("socks");
    }
}

class Wash<T> {
    T item;

    public void clean(T item) {
        System.out.println("Clean: " + item);
    }
}