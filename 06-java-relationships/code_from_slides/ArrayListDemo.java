import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Declaring an array and array list is similar
        Integer[] array;         // Could also be int
        ArrayList<Integer> ali;  // MUST be class type such as Integer
    
        // In Java, both must be initialized using new
        array = new Integer[10];   // Size must be specified when allocated
        ali   = new ArrayList<>(); // Size can change dynamically!
                               // Also note the empty <> - Java knows the type!
    
        // Filling the array and array list
        for(int i=0; i<array.length; ++i) {
            array[i] = (int) (100.0 * Math.random()); // Must specify the subscript
            ali.add((int) (100.0 * Math.random()));   // The add method appends to the list
        }
    
        // Printing the size of the array and array list
        System.out.println("Array size is " + array.length); // fixed property
        System.out.println("ArrayList size is " + ali.size()); // changeable method
        
        // Printing the array and array list using indexing
        for(int i=0; i<ali.size(); ++i) {
            System.out.printf("  array[%d] = %2d, ", i, array[i]);
            System.out.printf("ali.get(%d) = %2d\n", i, ali.get(i));
        }
        
        // Or use the for-each loop on either
        for(int i : array) System.out.printf(" %2d", i);
        System.out.println();
        for(int i : ali)   System.out.printf(" %2d", i);
        System.out.println();  
        
        if(ali.contains(42)) System.out.println("It's here!");
    }
}
