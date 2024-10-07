public class Horse {
    private static final int furlongs = 30;
    
    public Horse(String name, int speed) {
        this.name = name;
        this.speed = speed;
        this.position = furlongs;
    }
    
    String view() { // text for this horse's row in the Track
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; ++i) result.append((i%5 == 0) ? ':' : '.');
        result.append(" " + name);
        return result.toString();    
    }

    String name() {return name;}
    public static String winner() {
        String result;
        synchronized(lock) {
            result = winner;
        }
        return result;
    }

    // This is the code that runs within each Horse thread    
    public void gallop() {
        while(winner().isEmpty()) { // Nobody has won yet            
            if(position > 0) --position;
            if(position > 0) {
                try {Thread.sleep(speed + (int) (200 * Math.random()));}
                catch (InterruptedException e) {} // Remember the unchecked exception!
            } else {
                synchronized(lock) {
                    if(winner.isEmpty()) winner = name;
                }
            }
        }
    }
    
    private final String name;    // What the horse is called on the Track
    private int position;         // Distance from the finish line
    private int speed;            // Rough time between steps (in ms)
    
    private static Object lock = new Object();   // Controls write access to winner
    private static String winner = "";  // Name of 1st horse across the finish line
}
