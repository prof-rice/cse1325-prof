import java.util.Iterator;
import java.util.ListIterator;

public class ListIteratorExample {
    private static void printIterator(String title, Iterator it) { // Any cast of Iterator works
        System.out.println("\n" + title + '\n' + "=".repeat(title.length()));
        String sep = "";
        while(it.hasNext()) {
            System.out.print(sep + it.next()); 
            sep = ", ";
        }
        System.out.println();
    }

   public static void main(String[] args) {
        Food food = new Food();
        printIterator("Fruits", food.liFruit());
        printIterator("Veggies", food.liVeggie());
        
        System.out.println("\nWait - isn't tomato a fruit???");
        
        Veggie tomato = new Veggie("Tomato");    // Create a Veggie(“Tomato”)
        ListIterator<Veggie> vi=food.liVeggie(); // Iterate through the veggies
        while(vi.hasNext()) if(vi.next().equals(tomato)) vi.remove();
        ListIterator<Fruit> fi = food.liFruit(); // Point to start of fruits
        fi.add(new Fruit("Tomato"));             // Insert Fruit(“Tomato”) at start
    
        printIterator("Fruits", food.liFruit());
        printIterator("Veggies", food.liVeggie());
    }
}
