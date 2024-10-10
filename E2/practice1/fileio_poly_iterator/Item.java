import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public abstract class Item {
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Item(BufferedReader br) throws IOException {
        this(br.readLine(),
             Double.parseDouble(br.readLine()));
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + '\n');
        bw.write("" + price + '\n');
    }
    abstract public double cost();
    protected String name;
    protected double price;
}
