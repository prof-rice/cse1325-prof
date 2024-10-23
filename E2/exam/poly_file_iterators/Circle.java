import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Objects;

public class Circle extends Shape {
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(BufferedReader br) throws IOException {
        this(Double.parseDouble(br.readLine()));
    }
    @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + radius + "\n"); 
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Circle r = (Circle) o;
        return (radius == r.radius);
    }
    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
    @Override
    public String toString() {
        return "Circle (" + radius + ")";
    }
    private double radius;
}
