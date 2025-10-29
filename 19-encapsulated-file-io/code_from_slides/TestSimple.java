import java.io.PrintStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestSimple {
    private static final String filename = "testfile.simple";
    public static void main(String[] args) {
        int results = 0;
        int vector = 1;
        
        // Write simple to a file
        Simple simple = new Simple("Hello, World!", 42, 3.14, 'x', true);
        try(PrintStream out = new PrintStream(new File(filename))) {
            simple.save(out);
        } catch(IOException e) {
            System.err.println("FAIL: Simple save failed: " + e);
            results |= vector;
        }
        vector <<= 1;
        
        // Reconstruct simple in a new Object
        Simple newSimple = null;
        try(Scanner in = new Scanner(new File(filename))) {
            newSimple = new Simple(in);
        } catch(IOException e) {
            System.err.println("FAIL: Simple reconstruction failed: " + e);
            results |= vector;
        }
        vector <<= 1;
        
        // Verify correct reconstruction
        if(!simple.equals(newSimple)) {
            System.err.println("FAIL: Reconstructed simple different from original: " +
                             "\n  Original:      " + simple +
                             "\n  Reconstructed: " + newSimple);
            results |= vector;
        }
        vector <<= 1;
        
        // Report results
        if(results != 0) System.err.println("FAIL: Error code " + results);
        System.exit(results);
    }
}

