import java.util.ArrayList;

class Book {
  public Book(int size) {
      // Composition: The paper is contained entirely within the Book
      for(int i=0; i<size; ++i) pages.add(new Paper());
  }
  private ArrayList<Paper> pages;
}
