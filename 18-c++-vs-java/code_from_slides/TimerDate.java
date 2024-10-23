import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

import java.text.SimpleDateFormat;

class TimerDate {
    private static String elapsedTime(Date d1, Date d2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss.S");
        return dateFormat.format(new Date(d2.getTime() - d1.getTime()));
    }
    public static void main(String[] args) {
        System.out.println("Enter some event names, and I'll time them!"); 
        System.out.println("Press Control-d to exit");
    
        Scanner in = new Scanner(System.in);
        String line = "";
        
        ArrayList<Date> times = new ArrayList<>();
        ArrayList<String> events = new ArrayList<>();
        times.add(new Date());
        events.add("Begin");
        
        while(in.hasNextLine()) {
            line = in.nextLine();
            times.add(new Date());
            events.add((line != null) ? line : "End");
        }
        
        System.out.printf("%20s %15s %15s\n", 
                           "Event Description", "From Start", "From Previous");
        for(int i=1; i<times.size(); ++i) {
            System.out.printf("%20s %15s %15s seconds\n", events.get(i),
                elapsedTime(times.get(0),   times.get(i)),
                elapsedTime(times.get(i-1), times.get(i)));
        }   
    }
}
