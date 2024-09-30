import java.util.ArrayList;

public class BoxesDowncast {
    public static void main(String[] args) {
        ArrayList<Box> boxes = new ArrayList<>() {{
            add(new Box( 6,  7,  5));
            add(new Box(12, 13, 10));
            add(new TriBox( 6,  7,  5));
            add(new TriBox(12, 13, 10));
        }};
        
        for(Box box : boxes) {
            try {
                TriBox tb = (TriBox) box;
                System.out.println("Downcast " + tb);
            } catch(Exception e) {
                System.err.println("Failed to downcast " + box + ": " + e.getMessage());
            }
        }
    }
}
