import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Overloading {
    public static void print(Integer i) {System.out.println(i);}
    public static void print(ArrayList<Integer> is) {
        for(Integer i : is) print(i);
    }
    public static void main(String[] args) {
        //print(ThreadLocalRandom.current().nextInt(0, 100));
        print((int) (Math.random() * 100));
        ArrayList<Integer> is = new ArrayList<>();
        for(int i=0; i<10; ++i) is.add((int) (Math.random() * 100));
            // ThreadLocalRandom.current().nextInt(0, 100));
        print(is);
    }
}
