 import java.util.List;
 import java.util.ArrayList;

 public class Critter {
    private static List<String> sounds = new ArrayList<>();

    public static void chatter(String sound) {
        for(double f=0; f<Math.random()*6; ++f) 
            // Question 2.a: protect ArrayList sounds
            
            
            sounds.add(sound);
            
            
    }
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        String[] says = {"arf", "meow", "chirp", "quack", "moo", 
            "cluck", "hiss", "oink", "roar", "whinny"};
        
        // Question 2.b: Run each call to chatter(s) in a separate thread 
        for(String s: says) 
        
        
        
            chatter(s);
        
        
        
        
        // Question 2.c: Join all threads before executing the following line
        
        
        
        
        
        
        for(String s : sounds) System.out.println(s);
    }
 }
