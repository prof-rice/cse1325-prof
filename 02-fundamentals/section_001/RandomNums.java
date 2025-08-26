import java.util.Random;

public class RandomNums {
    public static void main(String[] args) {
        int numr = (args.length > 0) ? Integer.parseInt(args[0]) : 24;
        // int numr = 24;
        // if(args.length > 0) numr = Integer.parseInt(args[0]);
        
        double min = Double.MAX_VALUE;
        double sum = 0;
        double max = Double.MIN_VALUE;
        
        Random random = new Random();
        
        for(int i=0; i<numr; ++i) {
            double d = random.nextDouble(); //Math.random();
            if(d < min) min = d;
            if(d > max) max = d;
            sum += d;
            System.out.println(d);
        }
        
        System.out.println("Minimum:    " + min);
        System.out.println("Average:    " + (sum/numr));
        System.out.println("Maximum:    " + max);
        System.out.println("Population: " + numr);
    }
}
