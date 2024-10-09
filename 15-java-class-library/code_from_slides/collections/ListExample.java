import java.util.List;       // The interface
import java.util.ArrayList;  // The implementations
import java.util.LinkedList;
import java.util.Vector;

public class ListExample {
    public static void main(String[] args) {
        for(List<String> list : new List[] {new ArrayList<>(), new LinkedList<>(), new Vector<>()}) {
            list.add("UTA");               // Append
            list.add("Town");              // Append
            list.add(0, "Hello");          // Insert before UTA
            list.set(2, "World");          // Overwrite Town
            list.add("Forever!");          // Append after World
            list.remove(2);                // Remove World
            System.out.println("Size = " 
                           + list.size()   // Number of elements
                + ", UTA is index "
                + list.indexOf("UTA"));    // Search (-1 if not found)
            for(var s : list) 
                System.out.print(s + " "); // Iteration
            list.clear();                  // Clear
            System.out.println("list is now " 
               + (list.isEmpty() ? "empty" // isEmpty?
                                 : "not empty"));
        }
    }
}
