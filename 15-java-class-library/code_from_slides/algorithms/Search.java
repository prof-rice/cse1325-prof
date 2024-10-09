import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        if(args.length == 0) System.err.println("Provide some arguments to search!");
        List<String> list = Arrays.asList(args); // convert array to List
        
        Collections.sort(list); // binary searches only work on sorted lists
        System.out.println("Your arguments have been sorted to support binarySearch!");
        
        for(String s : list) System.out.print(s + " ");
        System.out.println();
        for(int i=0; i<list.size(); ++i) System.out.print("" + i + " ".repeat(list.get(i).length()));
        System.out.println();
        
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("Search key: ");
            String key = in.nextLine(); if(key.isEmpty()) break;
            int index = Collections.binarySearch(list, key);
            if(index >= 0) System.out.println(key + " found at index " + index);
            else System.out.println(key + " not found");
        }        
    }
}
