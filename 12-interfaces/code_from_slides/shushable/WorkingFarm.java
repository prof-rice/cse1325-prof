import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class WorkingFarm {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Critter> critters = new ArrayList<>();
        Collections.addAll(critters,   new Cow(13),    new Dog(11), new Dog(9), 
                           new Cow(7), new Chicken(5), new Dog(3),  new Chicken(2)); 
        Tractor tractor = new Tractor();
        
        // Noisemakers is a list of everything that can be shushed - critters and tractors
        ArrayList<Shushable> noisemakers = new ArrayList<>(critters);
        noisemakers.add(tractor);
        
        TimeUnit ms = TimeUnit.MILLISECONDS;

        System.out.println("W E L C O M E   T O   T H E   B A R N Y A R D !");
        for (int i=0; i<120; ++i) {
            tractor.operate();  // Oh, great - MORE noise!
            for (Critter c: critters) { 
                c.count(); 
                c.speak();
            }
            if(i%20 == 0) {
                System.out.println("==> Unshushing everything! Earplugs in!");                
                for (Shushable s: noisemakers) { s.unshush(); }
            } else if ((i+10)%20 == 0) {
                System.out.println("==> Shushing everything... zzz...");                
                for (Shushable s: noisemakers) { s.shush(); }
            }
            try {
                ms.sleep(200L + (long) (200L * Math.random())); // milliseconds
            } catch (InterruptedException e) { 
            }
        }
    }
}
