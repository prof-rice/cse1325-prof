import java.util.Objects;

public class TriBox extends Box {
    public enum Shape {Right, Equilateral, Isosceles, Scalene}
    
    public TriBox(double length, double width, double height, Shape shape) {
        super(length, width, height);
        this.shape = shape;
    }
    @Override
    public double volume() {
        return 0.5 * length * width * height;
    }
    
    public Shape getShape() {
        return shape;
    }
    
    @Override
    public String toString() {
        return "Triangular " + shape + " box ("
            + length + " x " + width + " x " + height + ")";
    }
    
    // Box.equals and Box.hashCode also work for TriBox
    //   (assume here volume but not shape define equality)
    //   although to make the hashes for a TriBox and Box
    //   different even for identical sizes you could use 
    //   something like this:
    
    @Override
    public int hashCode() {
        return Objects.hash(3, length, width, height);
    }
    
    private Shape shape;

}
