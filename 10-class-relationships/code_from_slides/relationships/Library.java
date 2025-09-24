import java.util.ArrayList;

class Library {
  // Association
  public void addPatron() {
      patrons.add(new Patron(this));
  }
  public Patron getPatron(int index) {
      return patrons.get(index);
  }
  
  // Aggregation: Each Book is created and exists external to Library
  public void addBook(Book book) {
      books.add(book);
  }
  public Book getBook(int index) {
      return books.get(index);
  }
  
  private ArrayList<Book> books = new ArrayList<>();
  private ArrayList<Patron> patrons = new ArrayList<>();
}
