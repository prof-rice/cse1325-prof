import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import java.io.PrintStream;
import java.io.File;

import java.util.Scanner;
import java.util.Random;

public class WithArrays {
    public WithArrays(Simple[] simples, int numInts) {
        this.simples = simples;
        Random random = new Random();
        ints = new ArrayList<>();
        while(numInts-- > 0) ints.add(random.nextInt(100));
    }

    public WithArrays(Scanner in) {
        int size = in.nextInt(); in.nextLine();     // Length of array
        simples = new Simple[size];                 // Instance the array
        for(int i=0; i<size; ++i) simples[i] = new Simple(in);
        
        size = in.nextInt(); in.nextLine();         // Size of ArrayList
        ints = new ArrayList<>();                   // Instance the ArrayList
        while(size-- > 0) {
            ints.add(in.nextInt()); in.nextLine();
        }
    }
    
    public void save(PrintStream out) {
        out.println("" + simples.length);     // Length of array
        for(Simple s : simples) s.save(out);  // Save the elements
        
        out.println("" + ints.size());        // Size of ArrayList
        for(int i : ints) out.println(i);     // Save the elements
    }

    @Override
    public String toString() {
        return Arrays.toString(simples) + "\n" + ints;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        WithArrays s = (WithArrays) o;
        if(simples.length != s.simples.length) return false;
        for(int i=0; i<simples.length; ++i) 
            if(!simples[i].equals(s.simples[i])) return false;
        return ints.equals(s.ints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simples, ints);
    }

    private Simple[] simples;    // Classic array
    private List<Integer> ints;  // ArrayLists, too!
    
    public static void main(String[] args) {
        File file = new File("witharrays.txt");
    
        // Create a simple object
        Simple[] simples = new Simple[]{
            new Simple("Hello, World!", 42, 3.14, 'x', true),
            new Simple("Aloha, World!", 97, 2.72, 'y', false),
            new Simple("Yasou, World!", 13, 1.41, 'z', true),
        };

        // Create and print a WithArrays instance
        WithArrays wa = new WithArrays(simples, 12);        
        System.out.println("Created the following WithArray object:");
        System.out.println(wa.toString());

        // Save the object to a simple file
        try (PrintStream out = new PrintStream(file)) {
            wa.save(out);
            System.out.println("\n\nSaved " + file.getName());
        } catch (Exception e) {
            System.err.println("Failed to write: " + e);
            System.exit(-1);
        }
        
        // Open the simple file and recreate the object
        WithArrays waReconstructed = null;
        try (Scanner in = new Scanner(file)) {
            waReconstructed = new WithArrays(in);
            System.out.println("\n\nRe-constructed WithArray object from " + 
                               file.getName());
        } catch (Exception e) {
            System.err.println("Failed to read: " + e);
            System.exit(-2);
        }
        System.out.println(waReconstructed.toString());
        
        System.out.println(wa.equals(waReconstructed) ? "\n\nThey match!"
                                                  : "\n\nERROR: NO MATCH!");
    }
}
