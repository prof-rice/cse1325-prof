import java.util.List;       // The interface
import java.util.ArrayList;  // Implements List
import java.util.LinkedList; // Implements List

public class UsingList {
    private static void fillList(List<Double> list) {
        for(int i=0; i<20; ++i)
            list.add(Math.random() * 100);
    }
    public static void main(String[] args) {
        List<Double> anyList;         // anyList may reference ... well, ANY List

        anyList = new ArrayList<>();  // Variable type is INTERFACE List
        fillList(anyList);            // We can pass an ArrayList to method fillList
        System.out.println("As ArrayList: " + anyList);
        
        anyList = new LinkedList<>(); // ANY class implementing List may be used
        fillList(anyList);            // And we can pass a LinkedList, too!
        System.out.println("\nAs LinkedList: " + anyList);
    }
}
