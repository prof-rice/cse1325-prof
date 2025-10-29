import java.awt.Color;

import java.math.BigInteger;

import java.io.PrintStream;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;
import java.util.Objects;

public class WithClasses {
    public WithClasses(Simple simple, Color color, BigInteger bi) {
        this.simple = simple;
        this.color = color;
        this.bi = bi;
    }
    
    public WithClasses(Scanner in) throws IOException {
        this.simple = new Simple(in);
        this.color = new Color(in.nextInt()); in.nextLine();
        this.bi = new BigInteger(in.nextLine()); 
    }
    
    public void save(PrintStream out) throws IOException {
        simple.save(out);
        out.println(color.getRGB());
        out.println("" + bi);
    }

    @Override
    public String toString() {
        return simple + 
               "\nRBG = " + Integer.toHexString(color.getRGB()) + 
               "\nBigInteger = " + bi;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null ||
           o.getClass() != getClass()) return false;
        WithClasses s = (WithClasses) o;
        return s.simple.equals(simple)
            && s.color.equals(color)
            && s.bi.equals(bi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simple, color, bi);
    }

    private Simple simple;  // A class we wrote
    private Color color;    // A class we did NOT write
    private BigInteger bi;  // A class we did NOT write
    
    public static void main(String[] args) {
        File file = new File("withclasses.txt");
        System.out.println("Creating objects\n================\n");
    
        // Create and print a simple object
        Simple simple = new Simple("Hello, World!", 42, 3.14, 'x', true);
        System.out.println("  " + simple.toString());
        
        // UTA Orange
        Color color = new Color(245, 128, 37);
        System.out.println("  " + Integer.toHexString(color.getRGB()));

        // long trillionth_prime = 29_996_224_275_833; // ERROR: Too big!
        BigInteger bi = new BigInteger("29996224275833"); // 29_996_224_275_833
        System.out.println("  " + bi.toString());
        
        // Create and print a WithClasses instance
        System.out.println("\nAnd WithClasses has been created as:");
        WithClasses wc = new WithClasses(simple, color, bi);
        System.out.println(wc.toString());
        
        // Save the object to a simple file
        System.out.print("\nWriting WithClasses file " + file.getName() + "... ");
        try (PrintStream out = new PrintStream(file)) {
            wc.save(out);
            System.out.println("Written!");
        } catch (Exception e) {
            System.err.println("Failed to write: " + e);
            System.exit(-1);
        }
        
        // Open the simple file and recreate the object
        System.out.print("\nReconstructing WithClasses from file " + file.getName() + "... ");
        WithClasses wcReconstructed = null;
        try (Scanner in = new Scanner(file)) {
            wcReconstructed = new WithClasses(in);
            System.out.println("Reconstructed!");
        } catch (Exception e) {
            System.err.println("Failed to read: " + e);
            System.exit(-2);
        }
        System.out.println("\nReconstructed as \n" + wcReconstructed.toString() + "\n");
        
        System.out.println((wc.equals(wcReconstructed)) ? "They match!"
                                                        : "FAIL: NO MATCH!");
    }
}
