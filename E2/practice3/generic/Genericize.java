import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Genericize {
    public static void print(Collection<?> c) {
        for(var v : c) System.out.println(v);
    }
    public static void sort(List<? extends Comparable> c) {
        Collections.sort(c);
    }
    public static <T extends Comparable> void printMax(T t1, T t2) {
        System.out.println((t1.compareTo(t2) < 0) ? t2 : t1);
    }
    public static void main(String[] args) {
        Double pi = 3.1415926;
        Double e = 2.71828;
        printMax(pi, e);
        
        ArrayList<Double> squares = new ArrayList<>(Arrays.asList(
              9.0, pi, 4.0, e, 3.0, 1.41421, 2.0
        ));
        Iterator<Double> it = squares.iterator();
        while(it.hasNext()) {
            Double d = it.next();
            if((Math.sqrt(d) % 1) != 0) it.remove();
        }
        sort(squares);
        print(squares);
    }
}
