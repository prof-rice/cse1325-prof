import java.util.Arrays;
import java.util.ArrayList;
import java.util.Objects;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class WithArrays {
    public WithArrays(Simple[] simples, int numInts) {
        this.simples = simples;
        ints = new ArrayList<>();
        while(numInts-- > 0) ints.add((int) (Math.random() * 100));
    }

    public WithArrays(BufferedReader br) throws IOException {
        int size = Integer.parseInt(br.readLine()); // Length of array
        simples = new Simple[size];                 // Instance the array
        for(int i=0; i<size; ++i) simples[i] = new Simple(br);
        
        size = Integer.parseInt(br.readLine());     // Size of ArrayList
        ints = new ArrayList<>();                   // Instance the ArrayList
        while(size-- > 0) ints.add(Integer.parseInt(br.readLine()));
    }
    
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + simples.length + '\n');      // Length of array
        for(Simple s : simples) s.save(bw);        // Save the elements
        
        bw.write("" + ints.size() + '\n');         // Size of ArrayList
        for(int i : ints) bw.write("" + i + '\n'); // Save the elements
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

    private Simple[] simples;         // Classic array
    private ArrayList<Integer> ints;  // ArrayLists, too!
    
    public static void main(String[] args) {
        String filename = "witharrays.txt";
    
        // Create and print a simple object
        Simple[] simples = new Simple[]{
            new Simple("Hello, World!", 42, 3.14, 'x', true),
            new Simple("Aloha, World!", 97, 2.72, 'y', false),
            new Simple("Yasou, World!", 13, 1.41, 'z', true),
        };

        // Create and print a WithArrays instance
        WithArrays wa = new WithArrays(simples, 12);        
        System.out.println(wa.toString());

        // Save the object to a simple file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            wa.save(bw);
        } catch (Exception e) {
            System.err.println("Failed to write: " + e);
            System.exit(-1);
        }
        
        // Open the simple file and recreate the object
        WithArrays waRecreated = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            waRecreated = new WithArrays(br);
        } catch (Exception e) {
            System.err.println("Failed to read: " + e);
            System.exit(-2);
        }
        System.out.println(waRecreated.toString());
        
        if(wa.equals(waRecreated)) System.out.println("They match!");

    }
}
