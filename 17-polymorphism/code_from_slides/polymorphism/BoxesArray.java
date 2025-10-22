import java.util.List;
import java.util.ArrayList;

public class BoxesArray {
    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box( 6,  7,  5));
        boxes.add(new Box(12, 13, 10));
        boxes.add(new TriBox( 6,  7,  5, TriBox.Shape.Right));
        boxes.add(new TriBox(12, 13, 10, TriBox.Shape.Equilateral));
                
        for(Box box : boxes) {
            System.out.println("Volume of " + box + " is " + box.volume());
            if(box instanceof TriBox t)
                System.out.println("  Box is of shape " + t.getShape());
        }
    }
}
