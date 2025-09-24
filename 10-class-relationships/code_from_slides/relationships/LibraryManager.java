import java.util.ArrayList;

public class LibraryManager {
  private static Library library;
  public static void main(String[] args) {
    // LibraryManager -> Library
    // Manage 1 library (association)
    library = new Library();
    
    // Library o- Book and Book *- Paper
    // Instance a book and put it in the library
    library.addBook(new Book(42));
    
    // LibraryManager -> Patron and Library *-o Patron
    // Add a new patron to the library
    library.addPatron();
    
    // Patron -- [Checkout] -- Book
    // Patron checks out the book
    ArrayList<Checkout> checkouts = new ArrayList<>();
    checkouts.add(new Checkout(library.getBook(0), library.getPatron(0)));
    
    // Check in the book and see if any fine is owed
    if(checkouts.get(0).getFine() != null) System.err.println("Fine on checked out book!");
    checkouts.get(0).checkIn();
    System.out.printf("Patron fine: $%.2f\n", checkouts.get(0).getFine());
  }
}
