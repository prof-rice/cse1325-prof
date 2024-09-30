import java.util.Objects;

public class TriBox extends Box {
    public TriBox(double length, double width, double height) {
        super(length, width, height);
    }
    @Override
    public double volume() {return 0.5 * length * width * height;}
    
    @Override
    public String toString() {
        return "Triangular box ("
            + length + " x " + width + " x " + height + ")";
    }
    
    // Box.equals and Box.hashCode also work for TriBox
    //   although to make the hashes for a TriBox and Box
    //   different even for identical sizes you could use 
    //   something like this:
    
    @Override
    public int hashCode() {
        return Objects.hash(3, length, width, height);
    }
    

}
