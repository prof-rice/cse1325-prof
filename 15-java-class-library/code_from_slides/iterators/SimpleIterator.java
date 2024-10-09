import java.util.Iterator;

public class SimpleIterator {
    public static void main(String[] args) {
        Food food = new Food();
        System.out.println("Fruits include ");
        Iterator<Fruit> it = food.iFruit();
        while(it.hasNext()) System.out.println("  " + it.next());
    }
}
