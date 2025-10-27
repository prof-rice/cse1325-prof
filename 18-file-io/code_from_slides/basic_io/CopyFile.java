import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        long numberOfCharacters = 0;
        // in and out will auto-close due to try-with-resources
        try (Scanner in = new Scanner(new File(args[0]));
             PrintStream out = new PrintStream(args[1])) { 
             
            // copy text file 1 line at a time
            while(in.hasNextLine()) {
                String s = in.nextLine();
                numberOfCharacters += s.length() + 1; // Don't forget \n!
                out.println(s); 
            }
        // IOException is checked, must "catch" or "throws"
        } catch (IOException e) { 
            System.err.println("Failed to copy " + args[0] + " to " + args[1] + ": " + e);
            System.exit(-1);
        } catch (Exception e) {
            System.err.println("Panic - unexpected error: " + e);
            System.exit(-2);
        }
        System.out.println("Copied " + numberOfCharacters + " characters");
    }
}

