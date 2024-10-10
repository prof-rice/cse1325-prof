import java.util.Objects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Fruit extends Item {
    public Fruit(String name, double price, double weight) {
        super(name, price);
        this.weight = weight;
    }
    public Fruit(BufferedReader br) throws IOException {
        super(br);
        this.weight = Double.parseDouble(br.readLine());
    }
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        bw.write("" + weight + '\n');
    }
    @Override
    public double cost() {
        return price * weight;
    }
    @Override 
    public int hashCode() {
        return Objects.hash(name, price, weight);
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || !(o instanceof Fruit)) return false;
        Fruit d = (Fruit) o;
        return name.equals(d.name)
            && price == d.price
            && weight == d.weight;
    }
    @Override 
    public String toString() {
        String product = String.format("%s (%3.1f # @ %5.2f  per)", name, weight, price);
        return String.format("%40s  $%-6.2f", product, cost());
    }
    private double weight;
}
