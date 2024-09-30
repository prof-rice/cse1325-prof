import java.util.ArrayList;

public class BoxesArray {
    public static void main(String[] args) {
        ArrayList<Box> boxes = new ArrayList<>() {{
            add(new Box( 6,  7,  5));
            add(new Box(12, 13, 10));
            add(new TriBox( 6,  7,  5));
            add(new TriBox(12, 13, 10));
        }};
        
        for(Box box : boxes)
            System.out.println("Volume of " + box + " is " + box.volume());
    }
}
