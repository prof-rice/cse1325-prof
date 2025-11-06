import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Arrays;

import java.util.Comparator;

class SortByLength implements Comparator<String> {
    @Override
    public int compare(String lhs, String rhs) {
        int result = Integer.compare(lhs.length(), rhs.length());
        return (result != 0) ? result : lhs.compareTo(rhs);
    }
}

public class Sort {
    public static void main(String[] args) {
        if(args.length == 0) System.err.println("Provide some arguments to sort!");

        // Duplicate the args array, sort, and print
        String[] array = new String[args.length];
        System.arraycopy(args, 0, array, 0, args.length);  // Copy args to array!
        if(!Arrays.equals(args, array)) // Not necessary, just demonstrating equals
            throw new RuntimeException("Copy args failed!");
        Arrays.sort(array);
        System.out.print("Array:  ");
        Printer.print(array);
        
        // Copy args to a new List, sort, and print
        List<String> list = new ArrayList<>();
        for(String s : args) list.add(s);
        
        Collections.sort(list);
        System.out.print("List:   ");
        Printer.print(list);

        // Custom sort order via SortByLength class which implements Comparator<String>
        // This same comparator could be used with Arrays.sort as well!
        Collections.sort(list, new SortByLength());

        // Same custom sort order via a (rather long) lambda, for one-shot use
        // Collections.sort(list, (String lhs, String rhs) -> {
        //     int result = Integer.compare(lhs.length(), rhs.length());
        //     return (result != 0) ? result : lhs.compareTo(rhs);});
        
        // More advanced solution NOT on the exam(!), using (free!) JCL Comparator generators
        // Collections.sort(list, Comparator.comparingInt(String::length)
        //                                  .thenComparing(Comparator.naturalOrder()));

        System.out.print("Length: ");
        Printer.print(list);
    }
}
