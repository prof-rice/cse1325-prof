import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Objects;

public class Rectangle extends Shape {
    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }
    public Rectangle(BufferedReader br) throws IOException {
        this(Double.parseDouble(br.readLine()),
             Double.parseDouble(br.readLine()));
    }
    @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + height + "\n");
        bw.write("" + width + "\n"); 
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
     // if(o == null || o instanceof Rectangle) return false; // also acceptable
        Rectangle r = (Rectangle) o;
        return (height == r.height) && (width == r.width);
    }
    @Override
    public int hashCode() {
        return Objects.hash(height, width);
        // return (int) (height * 7 + width * 31 * 7); // or similar OK
    }
    @Override
    public String toString() {
        return "Rectangle (" + width + "," + height + ")";
    }
    private double width;
    private double height;
}
