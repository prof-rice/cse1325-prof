import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Arrays;

class Shushables {

    private static void shush(Shushable e) {e.shush();}

    private static void shush(ArrayList<? extends Shushable> list) {
        for(var e : list) shush(e); // yes, e.shush() would work, too :-)
    }
    private static void unshush(ArrayList<? extends Shushable> list) {
        for(var e : list) e.unshush();
    }
    public static void main(String[] args) {
        ArrayList<Critter> critters = new ArrayList<>(
            Arrays.asList(new Cow(13),    new Dog(11), new Dog(9),  new Cow(7),
                          new Chicken(5), new Dog(3),  new Chicken(2)));
        
        TimeUnit ms = TimeUnit.MILLISECONDS;

        System.out.println("W E L C O M E   T O   T H E   B A R N Y A R D !");
        for (int i=0; i<120; ++i) {
            for (Critter c: critters) { c.count(); c.speak(); }
            if(i%20 == 0) {
                System.out.println("==> Unshushing the barnyard animals! Earplugs in!");                
                unshush(critters);
            } else if ((i+10)%20 == 0) {
                System.out.println("==> Shushing the barnyard animals... zzz...");                
                shush(critters);
            }
            try {ms.sleep(50L);} catch (InterruptedException e) { }
        }
    }
}
