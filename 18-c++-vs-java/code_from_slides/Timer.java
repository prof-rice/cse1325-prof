import java.util.ArrayList;
import java.util.Scanner;

import java.time.Instant;
import java.time.Duration;

class Timer {
    private static double elapsedTime(Instant start, Instant finish) {
        return ((double) Duration.between(start, finish).toMillis()) / 1000.0;
    }
    public static void main(String[] args) {
        System.out.println("Enter some event names, and I'll time them!"); 
        System.out.println("Press Control-d to exit");
    
        Scanner in = new Scanner(System.in);
        String line = "";
        
        ArrayList<Instant> times = new ArrayList<>();
        ArrayList<String> events = new ArrayList<>();
        times.add(Instant.now());
        events.add("Begin");
        
        while(in.hasNextLine()) {
            line = in.nextLine();
            times.add(Instant.now());
            events.add((line != null) ? line : "End");
        }
        
        System.out.printf("%20s %15s %15s\n", 
                           "Event Description", "From Start", "From Previous");
        for(int i=1; i<times.size(); ++i) {
            System.out.printf("%20s %15.3f %15.3f seconds\n", events.get(i),
                elapsedTime(times.get(0),   times.get(i)),
                elapsedTime(times.get(i-1), times.get(i)));
        }   
    }
}
