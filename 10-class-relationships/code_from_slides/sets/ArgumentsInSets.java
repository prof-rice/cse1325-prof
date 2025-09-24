import java.util.HashSet;  // Unsorted
import java.util.TreeSet;  // Sorted

public class ArgumentsInSets {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.err.println("Give me some arguments for the sets!");
            System.exit(-1);
        }
        
        // BOTH sets will remove duplicate words from the argument list
        HashSet<String> unsortedSet = new HashSet<>();  // This will NOT sort the arguments
        TreeSet<String> sortedSet   = new TreeSet<>();  // This will sort the arguments
        
        for(String s : args) {
            unsortedSet.add(s);
            sortedSet.add(s);
        }
        
        System.out.println("\n\nThese are the unique arguments in no particular order:");
        // for(int i=0; i<unsortedSet.size(); ++i) // NO - sets have no indices or get method!
        for(String s : unsortedSet)                // YES - you must use for-each on a set
            System.out.print(s + ' ');
        
        System.out.println("\n\nThese are the SORTED unique arguments:");
        for(String s : sortedSet)                  // YES - you must use for-each on a set
            System.out.print(s + ' ');
        System.out.println("\n\n");
    }
}
