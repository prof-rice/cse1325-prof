import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Objects;

public class Triangle extends Shape {
    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }
    public Triangle(BufferedReader br) throws IOException {
        this(Double.parseDouble(br.readLine()),
             Double.parseDouble(br.readLine()));
    }
    @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + height + "\n");
        bw.write("" + base + "\n"); 
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
     // if(o == null || o instanceof Triangle) return false; // also acceptable
        Triangle r = (Triangle) o;
        return (height == r.height) && (base == r.base);
    }
    @Override
    public int hashCode() {
        return Objects.hash(height, base);
        // return (int) (height * 7 + base * 31 * 7); // or similar OK
    }
    @Override
    public String toString() {
        return "Triangle (" + base + "," + height + ")";
    }
    private double base;
    private double height;
}
