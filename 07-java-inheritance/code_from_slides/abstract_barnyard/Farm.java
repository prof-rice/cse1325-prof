import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Arrays;

public class Farm {
    public static void main(String[] args) {
        // We have a couple of options for initializing our ArrayList.
        // The shortest is to use Arrays.asList, which creates a List from any
        // parameter type, which ArrayList will accept as its constructor parameter.
        // But it's also fine to just create the ArrayList and the use the add
        // method to populate it!
        ArrayList<Critter> critters = new ArrayList<>(
            Arrays.asList(new Cow(13),    new Dog(11), new Dog(9),  new Cow(7),
                          new Chicken(5), new Dog(3),  new Chicken(2)));
        /* or
        ArrayList<Critter> critters = new ArrayList<>();        critters.add(new Cow(13));
        critters.add(new Dog(11));    critters.add(new Dog(9)); critters.add(new Cow(7));
        critters.add(new Chicken(5)); critters.add(new Dog(3)); critters.add(new Chicken(2)); 
        */
        
        TimeUnit ms = TimeUnit.MILLISECONDS;

        System.out.println("W E L C O M E   T O   T H E   B A R N Y A R D !");
        for (int i=0; i<120; ++i) {
            for (Critter c: critters) { 
                 c.count(); 
                 c.speak();
             }
            try {
                ms.sleep(200L + (long) (200L * Math.random()));
            } catch (InterruptedException e) { 
            }
        }
    }
}
