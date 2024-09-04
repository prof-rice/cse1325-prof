import java.util.ArrayList;

class Library {
  // Aggregation: Each Book is created and exists external to Library
  public void add_book(Book book) {books.add(book);}
  
  private ArrayList<Book> books;
}
