import java.util.Random;

public class RandomNums {
    public static void main(String[] args) {
        Random random = new Random();
    
        // int numr = (args.length == 1) ? Integer.parseInt(args[0]) : 24;
        int numr = 24;
        if(args.length >= 1) numr = Integer.parseInt(args[0]);
        
        double min = Double.MAX_VALUE;
        double sum = 0;
        double max = Double.MIN_VALUE;
        
        for(int i = 0; i < numr; ++i) {
            // double d = Math.random();
            double d = random.nextDouble();
            if(d < min) min = d;
            sum += d;
            if(d > max) max = d;
            System.out.println(d);
        }
        
        System.out.println("Population: " + numr);
        System.out.println("Minimum:    " + min);
        System.out.println("Average:    " + (sum / numr));
        System.out.println("Maximum:    " + max);
        
    }
}
