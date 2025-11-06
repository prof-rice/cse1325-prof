import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class SimpleIterator {
    public static void main(String[] args) {
        Set<Fruit> hashFruits = new HashSet<>();
        Set<Fruit> treeFruits = new TreeSet<>();
        for(Set s : new Set[]{hashFruits, treeFruits}) {
            s.add(new Fruit("Banana"));
            s.add(new Fruit("Strawberry")); 
            s.add(new Fruit("Blackberry"));
            System.out.println("Fruits include ");

            // Obtain and use an iterator from the Set
            // This is similar to using a C pointer
            Iterator it = s.iterator();   // Fruit* fp = &s;
            //ListIterator it = s.listIterator(); // Will this work?
            while(it.hasNext())           // /* end-detect logic? */
                System.out.println("  " + it.next()); //   println("%??", *fp++);
        }
    }
}
