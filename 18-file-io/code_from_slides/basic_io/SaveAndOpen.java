import java.io.PrintStream;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;

// This is our data class
class Trivial {
    // Encapsulated data to be saved and restored
    private String greeting;
    private double lucky;
    
    public Trivial(String greeting) {
        this.greeting = greeting;
        this.lucky = Math.random();
    }
    
    public void save(PrintStream out) {
        out.println(greeting);
        out.println(lucky);
    }
    
    public Trivial(Scanner in) {
        this.greeting = in.nextLine();
        this.lucky = in.nextDouble(); in.nextLine();
    }
    
    @Override
    public String toString() {
        return greeting + "\nYour lucky number is " + lucky + "!";
    }
}

public class SaveAndOpen {
    private static Scanner scanner = new Scanner(System.in);
    private static Trivial trivial;
    
    private static void generate() {
        System.out.print("How would you prefer to be greeted? ");
        String greeting = scanner.nextLine();
        trivial = new Trivial(greeting);
    }

    private static void save() {
        System.out.print("\nWhat filename shall we save? ");
        String filename = scanner.nextLine();
        
        try(PrintStream out = new PrintStream(new File(filename))) {
            trivial.save(out);
        } catch(Exception e) {
            System.err.println("Save failed: " + e);
            System.exit(-1);
        }
    }

    private static void open() {
        System.out.print("\nWhat filename shall we open? ");
        String filename = scanner.nextLine();
        
        try(Scanner in = new Scanner(new File(filename))) {
            trivial = new Trivial(in);
        } catch(Exception e) {
            System.err.println("Open failed: " + e);
            System.exit(-2);
        }
    }

    public static void main(String[] args) {
        generate();     // Create Trivial object
        System.out.println("\nPrior to save:\n" + trivial);
        
        save();         // save Trivial object
        trivial = null; // discard Trivial object
        System.out.println("\nAfter save and null:\n" + trivial);

        open();         // restore Trivial object
        System.out.println("\nAfter open:\n" + trivial);
    }
}
