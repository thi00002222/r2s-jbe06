import com.example.model.Book;

public class Library {
    void displayBookinfo(Book book){
        System.out.println(book.title+ " " + book.author + " "+book.publicationYear);
    }

    public static void main(String[] args) {
    Book book1  = new Book("s1","T1",2024);
    Book book2  = new Book("s2","T2",2024);
    Book book3  = new Book("s3","T3",2024);
        Library library = new Library();
        library.displayBookinfo(book1);
        library.displayBookinfo(book2);
        library.displayBookinfo(book3);
    }
}
