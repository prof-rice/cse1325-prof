import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Scanner;
import java.util.Objects;

enum Color {BLUE, RED, WHITE}

class Flag {
    Color color1;
    Color color2;
    Color color3;

    public Flag(Color color1, Color color2, Color color3) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
    }
    public Flag(BufferedReader br) throws IOException {
        color1 = Color.valueOf(br.readLine());
        color2 = Color.valueOf(br.readLine());
        color3 = Color.valueOf(br.readLine());
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + color1.name() + '\n');
        bw.write("" + color2.name() + '\n');
        bw.write("" + color3.name() + '\n');
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        Flag that = (Flag) o;
        return this.color1 == that.color1
            && this.color2 == that.color2
            && this.color3 == that.color3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color1, color2, color3);
    }

    @Override
    public String toString() {
        return "" + color1 + ", " + color2 + ", and " + color3;
    }
}

public class WithEnum {
    
    private String filename = "Untitled.flag";
    private Flag flag = null;
    private Flag flagRecreated = null;
    
    private Scanner in = new Scanner(System.in);
    
    private void open() {
        System.out.print("Enter a Flag filename to open (Enter for '" 
                       + filename + "'): ");
        String s = in.nextLine();
        if(!s.isEmpty()) filename = s;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            flagRecreated = new Flag(br);
            System.out.println("Opened flagRecreated from " + filename);

        } catch (Exception e) {
            System.err.println("Failed to read: " + e);
            flagRecreated = null;
        }
    }
    
    private void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            flag.save(bw);
            System.out.println("Wrote flag to " + filename);
        } catch (Exception e) {
            System.err.println("Failed to save: " + e);
        }
    }
    
    private void saveAs() {
        System.out.print("Enter a Flag filename to save: ");
        String s = in.nextLine();
        if(s.isEmpty()) return;
        filename = s;
        save();
    }

    public void mdi() {
       // Create and print a Flag object
        flag = new Flag(Color.RED, Color.WHITE, Color.BLUE);
        System.out.println(flag.toString());
        
        // Save the object to a Flag file
        System.out.println("\nWriting Flag data to " + filename);
        save();
        
        // Save as a new filename
        System.out.println("\nWriting Flag data to a new filename");
        saveAs();
        
        // Open to a new Flag object
        System.out.println("\nOpening a Flag file");
        open();
        System.out.println(flagRecreated.toString());
        
        if(flag.equals(flagRecreated))
            System.out.println("\nSaved and opened Flag objects are equal!");
    }
    
    public static void main(String[] args) {
        WithEnum we = new WithEnum();
        we.mdi();
    }
}
