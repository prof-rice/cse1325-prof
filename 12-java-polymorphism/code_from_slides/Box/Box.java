import java.util.Objects;

public class Box {
    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;  
    }
    public double volume() {return length * width * height;}
    
    @Override
    public String toString() {
        return "Rectangular box ("
            + length + " x " + width + " x " + height + ")";
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(length, width, height);
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;
        Box b = (Box) o;
        return (b.length == length) 
            && (b.width  == width)
            && (b.height == height);
    }
    
    protected double length;
    protected double width;
    protected double height;
}
