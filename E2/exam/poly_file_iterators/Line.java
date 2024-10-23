import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Objects;

public class Line extends Shape {
    public Line(double length) {
        this.length = length;
    }
    public Line(BufferedReader br) throws IOException {
        this(Double.parseDouble(br.readLine()));
    }
    @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + length + "\n"); 
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Line r = (Line) o;
        return (length == r.length);
    }
    @Override
    public int hashCode() {
        return Objects.hash(length);
    }
    @Override
    public String toString() {
        return "Line (" + length + ")";
    }
    private double length;
}
