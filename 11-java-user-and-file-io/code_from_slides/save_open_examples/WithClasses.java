import java.math.BigInteger;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Objects;

public class WithClasses {
    public WithClasses(Simple simple, BigInteger bi) {
        this.simple = simple;
        this.bi = bi;
    }
    
    public WithClasses(BufferedReader br) throws IOException {
        simple = new Simple(br);
        // bi = new BigInteger(br.readLine()); 
        int size = Integer.parseInt(br.readLine());
        byte[] bytes = new byte[size];
        for(int i=0; i<size; ++i) bytes[i] = Byte.parseByte(br.readLine());
        bi = new BigInteger(bytes);
    }
    
    public void save(BufferedWriter bw) throws IOException {
        simple.save(bw);
        // This would work, but we will break it into byte[] as an example
        // bw.write("" + bi + '\n');
        byte[] bytes = bi.toByteArray();
        bw.write("" + bytes.length + "\n");
        for(Byte b : bytes) bw.write("" + b + "\n");
    }

    public String toStringAndByteArray() {
        String s = "";
        for(byte b : bi.toByteArray())
            s += Byte.toString(b) + " ";
        return simple + "\n" + s;
    }


    @Override
    public String toString() {
        return simple + "\n" + bi;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        WithClasses s = (WithClasses) o;
        return simple.equals(s.simple)
            && bi.equals(s.bi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simple, bi);
    }

    private Simple simple;  // A class we wrote
    private BigInteger bi;  // A class we did NOT write
    
    public static void main(String[] args) {
        String filename = "withclasses.txt";
    
        // Create and print a simple object
        Simple simple = new Simple(
            "Hello, World!", 42, 3.14, 'x', true);
        System.out.println(simple.toString());

        // long trillionth_prime = 29_996_224_275_833; // ERROR: Too big!
        BigInteger bi = new BigInteger("29996224275833"); // 29_996_224_275_833
        System.out.println(bi.toString());
        
        // Create and print a WithClasses instance
        WithClasses wc = new WithClasses(simple, bi);
        System.out.println(wc.toString());
        
        // Save the object to a simple file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            wc.save(bw);
        } catch (Exception e) {
            System.err.println("Failed to write: " + e);
            System.exit(-1);
        }
        
        // Open the simple file and recreate the object
        WithClasses wcRecreated = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            wcRecreated = new WithClasses(br);
        } catch (Exception e) {
            System.err.println("Failed to read: " + e);
            System.exit(-2);
        }
        System.out.println(wcRecreated.toString());
        
        if(wc.equals(wcRecreated)) System.out.println("They match!");
    }
}
