import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Track {
    public final int HORSES; // Number of horses to race
    public Track(int numHorses) {
        this.HORSES = numHorses;
    
        // Randomly assign vaguely clever names to each horse
        names = new ArrayList<>();
        for(String s : new String[] {
            "Legs of Spaghetti", "Ride Like the Calm", "Duct-taped Lightning",
            "Flash Light", "Speedphobia", "Cheat Ah!", "Go For Broken",
            "Whining Racer", "Spectacle", "Cannons a'Boring", "Plodding Prince",
            "Lucky Snooze", "Wrong Way", "Fawlty Powers", "Broken Tip",
            "American Zero", "Exterminated", "Great Regret", "Manual", "Lockout"}) { 
                names.add(s);
        }
        Collections.shuffle(names);
        names.add("2 Biggaherd"); // If we have more horses than names
    
        // Instance the horses
        horses = new ArrayList<>();
        for (int i=0; i<HORSES; ++i)
            horses.add(new Horse(names.get(Math.min(i, names.size()-1)),
                                 100 + (int) (Math.random()*100)));
    
        // Create the threads
        threads = new ArrayList<>();
        for (int i=0; i<HORSES; ++i) {
            final int horseNumber = i;
            threads.add(new Thread(
                () -> horses.get(horseNumber).gallop() // This is the lambda
            ));
        }
    }
    
    public void startRace() {
        for(Thread t : threads) t.start();
    }
    
    public void showTrack() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        for(Horse horse : horses) {
            System.out.println(horse.view());
        }
    }
    
    public void endRace() {
        for(Thread t : threads) 
            try {t.join();}
            catch (InterruptedException e) {} // Remember the unchecked exception!
    }
    
    public static void main(String[] args) {
        Track track = new Track(20);
        track.showTrack();
        System.console().readLine("\n\nAwaiting the starting gun...\n");
        track.startRace(); // And they're off!!!
        
        while(Horse.winner().isEmpty()) {
            try {Thread.sleep(100);}
            catch (InterruptedException e) {}
            track.showTrack();        
            System.out.print("\n\n\n");
        }
        
        track.endRace(); 
        track.showTrack();
        System.out.println("\n### The winner is " + Horse.winner() + "!!!\n");
    }
        
    public List<String> names; 
    public List<Horse> horses;
    public List<Thread> threads;
}
