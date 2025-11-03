import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class UnboundedGeneric {
    public static <T> void printAll(List<T> list) {
        String sep = "";
        for(var e : list) {System.out.print(sep + e); sep = ", ";}
        System.out.println("");
    }
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        strings.addAll(Arrays.asList("one", "two", "three"));
        printAll(strings);
        
        ArrayList<Integer> ints = new ArrayList<>();
        ints.addAll(Arrays.asList(42, 17, 255));
        printAll(ints);
    }
}
