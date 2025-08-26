import java.util.Arrays;

public class Roll {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println("usage: java Roll <#dice> <#sides>");
            System.exit(-1);
        }
        
        Die die = new Die(Integer.parseInt(args[1]));
        final int numDice = Integer.parseInt(args[0]);
        
        int dice[] = new int[numDice];

        int sum = 0;
        for(int i=0; i<numDice; ++i) {
            dice[i] = die.roll();
            sum += dice[i];
        }
        
        Arrays.sort(dice);
        for(var d : dice)
            System.out.print(" " + d);
    
        System.out.println("\n Sum=" + sum);
        System.out.println(" Average=" + ((double) sum / (double) numDice));
    }
}
