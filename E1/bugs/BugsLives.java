import java.util.ArrayList;

public class BugsLives {
    private static ArrayList<Bug> bugs = new ArrayList<>();
    public static void main(String[] args) {
        int numExceptions = 0;
        for(String arg : args) {
            try {
                Insect bug = new Insect(Stage.EGG);
             // Spider bug = new Spider(Stage.EGG);
             // Centipede bug = new Centipede(Stage.EGG);
             // WaterFlea bug = new WaterFlea(Stage.EGG);
             
                while(bug.getStage() != Stage.ADULT) bug.nextStage();
                
                bug.fly(Integer.parseInt(arg));     // Insect
             // bug.spin(Double.parseDouble(arg));  // Spider
             // bug.hunt(arg.charAt(0));            // Centipede
             // bug.swim(Double.parseDouble(arg));  // WaterFlea
             
                bugs.add(bug);
            } catch(Exception e) {
                System.err.println("Invalid arg: " + e.getMessage());
                ++numExceptions;
            }
        }
        System.exit(numExceptions);
    }
}
