import java.util.Arrays;

public class Roll {
    public static void main(String[] args) {
        String nl = System.lineSeparator(); // System independent
    
        if(args.length != 2) {
            System.err.println("usage: java Roll [#dice] [#sides]");
            System.exit(-1);
        }
        
        int numDice = Integer.parseInt(args[0]);
        Die die = new Die(Integer.parseInt(args[1]));
        
        int dice[] = new int[numDice];

        for(int i=0; i<numDice; ++i)
            dice[i] = die.roll();
        
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
