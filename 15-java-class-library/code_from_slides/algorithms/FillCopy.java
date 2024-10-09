import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class FillCopy {
    public static void main(String[] args) {
        if(args.length == 0) System.err.println("Provide some arguments to fill and copy!");
        List<String> list = Arrays.asList(args); // convert array to List
        List<String> etc = new ArrayList<>(list); // construct copy of list
        Collections.fill(etc, "etc");
        Collections.copy(etc, list.subList(0,list.size()/2));
        for(String s : etc) System.out.print(s + " ");
        System.out.println("");
    }
}
