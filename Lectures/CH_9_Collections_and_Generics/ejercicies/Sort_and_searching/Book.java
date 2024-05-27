import java.util.*;

public class Book {
    private String title;
    private String genre;

    public Book(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle(){
        return this.title;
    }

    public String getGenre(){
        return this.genre;
    }

    @Override
    public String toString(){
        return this.genre + ":" + this.title;
    }

    public static void main(String[] args) {
        var books = new ArrayList<Book>(
            List.of(
                new Book("The Outsider", "fiction"),
                new Book("Becoming", "non-fiction"),
                new Book("Alaska", "non-fiction"),
                new Book("Hitler", "non-fiction"),
                new Book("Poseidon", "non-fiction")
            )
        );

        books.sort(
            Comparator.comparing(Book::getGenre)
                .thenComparing(Book::getTitle)
                .reversed()
        );
        //The thenComparing method adds on a Comparator to the existing Comparator. This additional  Comparator is used only when two objects are determined
        //to be equal by the ffrist Comparator. This, i the gicen question, the bboks will be sorted by their genre and title (i.e if the
        // genre of the two books is same, then they willl be sorted as per their title.)
        System.out.println(books); //Print [non-fiction:Poseidon, non-fiction:Hitler, non-fiction:Becoming, non-fiction:Alaska, fiction:The Outsider]
    }
}