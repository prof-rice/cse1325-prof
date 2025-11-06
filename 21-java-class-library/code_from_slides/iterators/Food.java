import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class Food {
    // Lists of foods
    private List<Fruit> fruits = new ArrayList<>();
    private List<Veggie> veggies = new ArrayList<>();
    public Food() {
        fruits.add(new Fruit("Apple"));
        fruits.add(new Fruit("Pear")); 
        fruits.add(new Fruit("Grape"));
        veggies.add(new Veggie("Carrot"));
        veggies.add(new Veggie("Pea"));
        veggies.add(new Veggie("Tomato"));
    }
    
    // Iterators and ListIterators for the lists
    public Iterator<Fruit> iFruit() {
        return fruits.iterator();
    }
    public Iterator<Veggie> iVeggie() {
        return veggies.iterator();
    }
    public ListIterator<Fruit> liFruit() {
        return fruits.listIterator();
    }
    public ListIterator<Veggie> liVeggie() {
        return veggies.listIterator();
    }
}
