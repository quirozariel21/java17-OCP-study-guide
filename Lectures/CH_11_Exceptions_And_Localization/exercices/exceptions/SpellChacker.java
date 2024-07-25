/*
Output:
DONE!
*/
public class SpellChacker {
    public static void main(String[] args) {

        try {
            if(!"cat".equals("kat")) {
                new SpellingException();
            }
        } catch (SpellingException | NullPointerException e) {
            System.out.println("Spelling problem!");
        } catch(Exception e) {
            System.out.println("Unknown problem!");
        } finally {
            System.out.println("DONE!");
        }
    }
}

class SpellingException extends RuntimeException {

}