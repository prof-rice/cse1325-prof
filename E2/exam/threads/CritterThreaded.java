 import java.util.List;
 import java.util.ArrayList;

 public class CritterThreaded {
    // private static Object mutex = new Object(); // OPTIONAL any variable name is OK
    private static List<String> sounds = new ArrayList<>();
    public static void chatter(String sound) {
        for(double f=0; f<Math.random()*6; ++f) 
        
            // Question 2.a: protect ArrayList sounds
            synchronized(sounds) {    // OPTIONALLY mutex above INSTEAD OF sounds
                sounds.add(sound);
            } 
    }
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        String[] says = {"arf", "meow", "chirp", "quack", "moo", 
                         "cluck", "hiss", "oink", "roar", "whinny"};
        
        // Question 2.b: Run each call to chatter(s) in a separate thread 
        for(String s: says) 
            threads.add(new Thread(() -> chatter(s))); // Anonymous class is OK
        for(Thread t: threads) 
            t.start();

        // Question 2.c: Join all threads before executing the following line
        try {
            for(Thread t : threads) t.join();
        } catch (InterruptedException e) { 
        }
        for(String s : sounds) System.out.println(s);
    }
 }

