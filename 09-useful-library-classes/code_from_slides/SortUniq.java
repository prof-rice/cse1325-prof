import java.util.ArrayList;

public class SortUniq {
    public static void main(String[] args) {
        // Instance a new ArrayList to hold Integers
        ArrayList<Integer> ints = new ArrayList<>();
        
        // Generate 100 random integers
        for(int i = 0; i<100; ++i) {
            int nextInt = (int) (100.0 * Math.random());
            
            // Iterate through the ArrayList
            // When you find an int smaller than nextInt, insert there
            for(int j = ints.size() - 1; j >= 0 ; --j) {
                if(nextInt >= ints.get(j)) {
                    ints.add(j + 1, nextInt);
                    nextInt = Integer.MAX_VALUE;
                    break;
                }
            }
            
            // If none of the ints are smaller than this one, insert it first!
            if(nextInt != Integer.MAX_VALUE) {
                ints.add(0, nextInt);
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
