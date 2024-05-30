import java.util.List;

public class LowerBoundExample {

    // COMPILE
    public static void addSoundSuper(List<? super String> list) {
        list.add("quack");
    }

    // NO COMPILE
    public static void addSoundQuestionMark(List<?> list) {
        list.add("quack");
    }

    // NO COMPILE
    public static void addSoundExtends(List<? extends Object> list) {
        list.add("quack");
    }

    // COMPILE
    public static void addSoundObject(List<Object> list) {
        list.add("quack");
    }
}