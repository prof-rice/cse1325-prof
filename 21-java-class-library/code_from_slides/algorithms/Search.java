import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        if(args.length == 0) System.err.println("Provide some arguments to search!");
        System.out.println("Your arguments have been sorted to support binarySearch!");
        Arrays.sort(args);                       // binary searchs require sorting!

        List<String> list = Arrays.asList(args); // wrap array in fixed-length List
        
        Printer.showIndices = true;
        Printer.print(list);
        
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("Search key: ");
            String key = in.nextLine(); if(key.isEmpty()) break;

            // Searching the array
            System.out.print("Array: " + key);
            int arrayIndex = Arrays.binarySearch(args, key);
            if(arrayIndex >= 0) System.out.println(" found at index " + arrayIndex);
            else System.out.println(" not found");

            // Searching the list
            System.out.print("List:  " + key);
            int listIndex = Collections.binarySearch(list, key);
            if(listIndex >= 0) System.out.println(" found at index " + listIndex);
            else System.out.println(" not found");
        }        
    }
}
