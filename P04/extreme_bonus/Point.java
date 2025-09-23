import java.util.Objects;

public class Point {
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this(0,0);
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null ||
           o.getClass() != getClass()) return false;
        Point p = (Point) o;
        return Math.abs(p.x - x) < 0.000001 && 
               Math.abs(p.y - y) < 0.000001;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }
    @Override
    public String toString() {
        return String.format("(%.2f,%.2f)", x, y);
    }
    private double x;
    private double y;
}
