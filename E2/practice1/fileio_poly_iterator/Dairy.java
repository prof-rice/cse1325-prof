import java.util.Objects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Dairy extends Item {
    public Dairy(String name, double price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }
    public Dairy(BufferedReader br) throws IOException {
        super(br);
        this.quantity = Integer.parseInt(br.readLine());
    }
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        bw.write("" + quantity + '\n');
    }
    @Override
    public double cost() {
        return price * quantity;
    }
    @Override 
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || !(o instanceof Dairy)) return false;
        Dairy d = (Dairy) o;
        return name.equals(d.name)
            && price == d.price
            && quantity == d.quantity;
    }
    @Override 
    public String toString() {
        String product = String.format("%s (%2d @ %5.2f each)", name, quantity, price);
        return String.format("%40s  $%-6.2f", product, cost());
    }
    private int quantity;
}
