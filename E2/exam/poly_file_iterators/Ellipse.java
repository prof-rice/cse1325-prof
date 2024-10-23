import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Objects;

public class Ellipse extends Shape {
    public Ellipse(double minorAxis, double majorAxis) {
        this.minorAxis = minorAxis;
        this.majorAxis = majorAxis;
    }
    public Ellipse(BufferedReader br) throws IOException {
        this(Double.parseDouble(br.readLine()),
             Double.parseDouble(br.readLine()));
    }
    @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + minorAxis + "\n");
        bw.write("" + majorAxis + "\n"); 
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
     // if(o == null || o instanceof Ellipse) return false; // also acceptable
        Ellipse r = (Ellipse) o;
        return (minorAxis == r.minorAxis) && (majorAxis == r.majorAxis);
    }
    @Override
    public int hashCode() {
        return Objects.hash(minorAxis, majorAxis);
        // return (int) (minorAxis * 7 + minorAxis * 31 * 7); // or similar OK
    }
    @Override
    public String toString() {
        return "Ellipse (" + majorAxis + "," + minorAxis + ")";
    }
    private double majorAxis;
    private double minorAxis;
}
