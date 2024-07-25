import java.io.FileinputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MultipleExceptions {

    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("file.txt");) {
            System.out.println("File opened");
            fis.read();
            System.out.println("Read file");
        } catch(FileNotFoundException e) {
            System.out.println("FileNotFoundException"); // Output
        } catch (IOException ioe) {
            System.out.println("IOException");
        }
    }
}