import java.util.ArrayList;

public class SortUniqReverse {
    public static void main(String[] args) {
        // Instance a new ArrayList to hold Integers
        ArrayList<Integer> ints = new ArrayList<>();
        
        // Generate 100 random integers
        for(int i = 0; i<100; ++i) {
            int nextInt = (int) (100.0 * Math.random());
            
            // iterate through the ArrayList
            // When you find an int smaller than nextInt, insert there
            for(int j = 0; j < ints.size(); ++j) {
                if(ints.get(j) < nextInt) {
                    ints.add(j, nextInt);
                    nextInt = Integer.MAX_VALUE;
                    break;
                }
            }
            
            // If none of the ints are smaller than this one, append it
            if(nextInt != Integer.MAX_VALUE) {
                ints.add(nextInt);
            }
        }
        // Now go through all the ints and remove any duplicates
        for(int i = 1; i<ints.size(); ) {
            if(ints.get(i-1) == ints.get(i)) ints.remove(i);
            else ++i;
        }
        
        // Finally, print all of the surviving ints, (hopefully) in order
        System.out.println("Survivors = " + ints.size());
        for(int i : ints) System.out.print(" " + i);
        System.out.println();
    }
}
