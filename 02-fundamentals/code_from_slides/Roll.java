// Example #3: Dice Roller
//
// Techniques Illustrated
//
// Different in Java:
//   Importing a package
//   Handling command line arguments (with usage statement)
//   Converting text ("String") to an integer
//   Arrays (including new to allocate the array and sorting an array)
//   Generating a random integer between 1 and a max value
//   Use of var to instruct compiler to infer a type
//   Use of final to declare a constant 
//   Use of a for-each loop
//   Printing to the error stream (STDERR) and the console (STDOUT)
//
// Similar to C:
//   Initializing local primitives
//   3-term for loops
//   Simple if statements
//   Casting from one type to another

import java.util.Arrays;
import java.util.Random;

public class Roll {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println("usage: java Roll <#dice> <#sides>");
            System.exit(-1);
        }
        
        final int numSides = Integer.parseInt(args[1]);
        final int numDice = Integer.parseInt(args[0]);
        
        int dice[] = new int[numDice];

        int sum = 0;
        Random random = new Random();
        for(int i=0; i<numDice; ++i) {
            // dice[i] = 1 + (int) (numSides * Math.random());
            dice[i] = 1 + random.nextInt(numSides);
            sum += dice[i];
        }
        
        Arrays.sort(dice);
        for(var d : dice)
            System.out.print(" " + d);
    
        System.out.println("\n Sum=" + sum);
        System.out.println(" Average=" + ((double) sum / (double) numDice));
    }
}
