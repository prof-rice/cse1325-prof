public class Iteration {
    public static void main(String[] args) {

        // Conditional BEFORE the loop
        int i=0;
        while(++i < 10) {
            System.out.println(i);
        }

        // Conditional AFTER the loop
        i = 1;
        do {
            System.out.println(i);
        } while (++i < 10);

        // Condition INSIDE the loop
        // Usually when reading inputs and
        //   exiting on a "magic value"
        i = 0;
        while(true) {
            if(++i >= 10) break;
            System.out.println(i);
        }

        // The classic 3-term for loop
        int[] ints = new int[10];
        for(int j=0; j<10; ++j) {
            System.out.println(j);
            ints[j] = j;
        }
        
        // The for-each loop evaluates
        //   each member of an array
        for(int j : ints)
            System.out.println(j);
    }
}
