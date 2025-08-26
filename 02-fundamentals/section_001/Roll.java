import java.util.Random;
import java.util.Arrays;

public class Roll {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println("usage: java Roll <#dice> <#sides>");
            System.exit(-1);
        }
        
        Random random = new Random();
        
        int numDice = Integer.parseInt(args[0]);
        int numSide = Integer.parseInt(args[1]);
        
        int[] dice = new int[numDice];
        int sum = 0;
        
        for(int i=0; i<numDice; ++i) {
            dice[i] = random.nextInt(numSide) + 1;
        }
        
        Arrays.sort(dice);
        
        for(var d : dice) System.out.print(" " + d);
        System.out.println();
    }
}
