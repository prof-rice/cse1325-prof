import java.util.List;
import java.util.ArrayList;

import java.util.Arrays;

public class ArraysToLists {
    public static void main(String[] args) {
        Integer[] ints = new Integer[]{42, 27, 99, 128};
        List<Integer> intList = Arrays.asList(ints); // Wrap a List AROUND the array
        // intList.add(1024); // NO - intList and ints are the same, so size can't change
        intList.set(0, -1);   // YES - values can be changed via the array OR List
        ints[3] = 256;   
        Printer.print(ints);  // Print array as a comma-separated list (next)
    
        List<String> stringList = new ArrayList<>();
        stringList.add("popular");
        stringList.add("flexible");
        stringList.add("Java");
        // Copy the List values into the array. Because of Java's generic type erasure,
        // we must pass an empty String array for the toArray method to fill!
        String[] strings = stringList.toArray(new String[stringList.size()]);
        stringList.add("rocks!"); // YES - strings and stringList are independent!
        Printer.print(strings);   // "rocks" was NOT added to the array, just the List
    }
}
