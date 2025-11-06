import java.util.Iterator;

public class IteratorExample {
    private static void printIterator(Iterator it) {
        String sep = "";
        while(it.hasNext()) {
            System.out.print(sep + it.next()); 
            sep = ", ";
        }
    }
    public static void main(String[] args) {
        Food food = new Food();
        System.out.print("Fruits include ");
        printIterator(food.iFruit());
        System.out.print("\nVeggies include ");
        printIterator(food.iVeggie());
        System.out.println("");
    }
}
