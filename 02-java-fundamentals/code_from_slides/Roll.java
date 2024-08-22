// Example #3: Dice Roller
//
// Techniques Illustrated
//
// Different in Java:
//   Importing a package
//   System-independent line separators (for Mac, Linux, Windows)
//   Handling command line arguments (with usage statement)
//   Converting text ("String") to an integer
//   Arrays (including sorting an array)
//   Generating a random integer between 1 and a max value
//   Printing to the error stream (STDERR) and the console (STDOUT)
//
// Similar to C:
//   Initializing local primitives
//   3-term for loops
//   Simple if statements
//   Casting from one type to another

import java.util.Arrays;

public class Roll {
    public static void main(String[] args) {
        String nl = System.lineSeparator(); // System independent
    
        if(args.length != 2) {
            System.err.println("usage: java Roll [#dice] [#sides]");
            System.exit(-1);
        }
        
        int numSides = Integer.parseInt(args[1]);
        int numDice = Integer.parseInt(args[0]);
        
        int dice[] = new int[numDice];

        for(int i=0; i<numDice; ++i)
            dice[i] = 1 + (int) (numSides * Math.random());
        
        Arrays.sort(dice);
         
        int sum = 0;
        for(int d : dice) {
            System.out.print(" " + d);
            sum += d;
        }
    
        System.out.println(nl + " Sum=" + sum);
        System.out.println(" Average=" + ((double) sum / (double) numDice));
    }
}
