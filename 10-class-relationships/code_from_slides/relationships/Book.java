import java.util.ArrayList;

class Book {
  public Book(int numPages) {
      pages = new ArrayList<>();
      // Composition: The paper is contained entirely within the Book
      for(int i=0; i<numPages; ++i) pages.add(new Paper());
  }
  private ArrayList<Paper> pages;
}
