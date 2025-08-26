import java.util.Random;
import java.util.Arrays;

public class Roll {
    public static void main(String[] args) {
        Random random = new Random();
        if(args.length != 2) {
            System.err.println("usage: java Roll <#dice> <#sides>");
            System.exit(-1);
        }
        
        int numDice = Integer.parseInt(args[0]);
        int numSide = Integer.parseInt(args[1]);
        
        int[] dice = new int[numDice];
        
        int sum = 0;
        for(int i=0; i<numDice; ++i) {
            dice[i] = random.nextInt(numSide) + 1;
            sum += dice[i];
        }
        
        Arrays.sort(dice);
        for(var d : dice) System.out.print(" " + d);
        System.out.println("\nSum = " + sum);
    }
}
