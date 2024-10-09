import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Reverse {
    public static void main(String[] args) {
        if(args.length == 0) System.err.println("Provide some arguments to reverse!");
        List<String> list = new ArrayList<>();
        for(String s : args) list.add(s);
        Collections.reverse(list);
        for(String s : list) System.out.print(s + " ");
        System.out.println("");
    }
}
