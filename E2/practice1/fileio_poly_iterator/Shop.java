import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Shop {
    public static void main(String[] args) {
        GroceryCart cart = new GroceryCart();
        cart.addItem(4011, new Fruit("Bananas", 0.69, 2.11));
        cart.addItem(68692400160L, new Dairy("Skim Milk (gallon)", 2.69, 1));
        cart.addItem(21000001927L, new Dairy("8 oz Medium Cheddar", 3.29, 2));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("list.txt"))) {
            cart.save(bw);
        } catch(IOException e) {
            System.err.println("Failed to save cart: " + e);
        }
        cart = null;
        try (BufferedReader br = new BufferedReader(new FileReader("list.txt"))) {
            cart = new GroceryCart(br);
        } catch(IOException e) {
            System.err.println("Failed to open cart: " + e);
        }
        cart.removeItem(68692400160L);
        System.out.println(cart);
    }
}
