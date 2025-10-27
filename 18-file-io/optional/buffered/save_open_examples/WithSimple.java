import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Scanner;

public class WithSimple {
    private String filename = "Untitled.simple";
    private Simple simple = null;
    private Simple simpleRecreated = null;
    
    private Scanner in = new Scanner(System.in);
    
    private void open() {
        System.out.print("Enter a Simple filename to open (Enter for '" 
                       + filename + "'): ");
        String s = in.nextLine();
        if(!s.isEmpty()) filename = s;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            simpleRecreated = new Simple(br);
            System.out.println("Opened simpleRecreated from " + filename);

        } catch (Exception e) {
            System.err.println("Failed to read: " + e);
            simpleRecreated = null;
        }
    }
    
    private void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            simple.save(bw);
            System.out.println("Wrote simple to " + filename);
        } catch (Exception e) {
            System.err.println("Failed to save: " + e);
        }
    }
    
    private void saveAs() {
        System.out.print("Enter a Simple filename to save: ");
        String s = in.nextLine();
        if(s.isEmpty()) return;
        filename = s;
        save();
    }

    public void mdi() {
       // Create and print a simple object
        simple = new Simple(
            "Hello, World!", 42, 3.14, 'x', true);
        System.out.println(simple.toString());
        
        // Save the object to a simple file
        System.out.println("\nWriting Simple data to " + filename);
        save();
        
        // Save as a new filename
        System.out.println("\nWriting Simple data to a new filename");
        saveAs();
        
        // Open to a new Simple object
        System.out.println("\nOpening a Simple file");
        open();
        System.out.println(simpleRecreated.toString());
        
        if(simple.equals(simpleRecreated))
            System.out.println("\nSaved and opened Simple objects are equal!");
    }
    
    public static void main(String[] args) {
        WithSimple ws = new WithSimple();
        ws.mdi();
    }
}
