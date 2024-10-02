import java.util.ArrayList;
import java.util.List;

public class ArrayListDefault {
    public static void main(String[] args) {
    	List list = new ArrayList(); // Warning for unchecked operations
    	// List<Object> list = new ArrayList<>(); // Explicit avoids warnings
        list.add("The answer is ");
        list.add(42);
        String s = (String) list.get(0);
        int i = (Integer) list.get(1);
        System.out.println(s + i);
    }
}
