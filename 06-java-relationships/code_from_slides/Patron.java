import java.util.ArrayList;

class Patron {
  // Association (unidirectional): Each Patron knows to which Library they belong
  public void add_library(Library library) {libraries.add(library);}
  
  private ArrayList<Library> libraries;
}
