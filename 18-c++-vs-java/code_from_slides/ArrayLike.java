import java.util.ArrayList;

public class ArrayLike {
    public static void main(String[] args) {
        ArrayList<Integer> v = new ArrayList<>();
        // Remember, must be a class - NOT ArrayList<int> !!!
        v.add(42); v.add(17);v.add(255);  v.add(911); v.add(65535);
        for(var i : v) System.out.println(i);
    }
}
