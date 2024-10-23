import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Objects;

public class Square extends Shape {
    public Square(double size) {
        this.size = size;
    }
    public Square(BufferedReader br) throws IOException {
        this(Double.parseDouble(br.readLine()));
    }
    @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + size + "\n"); 
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Square r = (Square) o;
        return (size == r.size);
    }
    @Override
    public int hashCode() {
        return Objects.hash(size);
    }
    @Override
    public String toString() {
        return "Square (" + size + ")";
    }
    private double size;
}
