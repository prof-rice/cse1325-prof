import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Random;

public class GenericFarm {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Critter> critters = new ArrayList<> ();
        critters.add(new Critter(13));
        critters.add(new Critter(9));
        critters.add(new Critter(3));
        critters.add(new Critter(2));
        
        TimeUnit ms = TimeUnit.MILLISECONDS;

        System.out.println("W E L C O M E   T O   T H E   B A R N Y A R D !");
        for (int i=0; i<120; ++i) {
            for (Critter c: critters) { 
                 c.count(); 
                 c.speak();
             }
            try {
                // ms.sleep(200L + (long) (200L * Math.random()));
                ms.sleep(200L + random.nextInt(200));
            } catch (InterruptedException e) { 
            }
        }
    }
}
