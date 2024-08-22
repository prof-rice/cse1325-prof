// These are kinda like C's #include
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;

// This is (for now) the name of the Java file - TestJavaFileIO.java
public class TestJavaFileIO {

    // This is similar to a global const in C
    // A String is kinda like C's char*
    public static final String filename = "TestJavaFileIO.java";

    // This is where 'java TestJavaFileIO' begins running (like C's int main() function)
    public static void main(String[] args) { 
    
        // If an exception (a type of error) occurs, jump to the matching catch statement
        try {
            
            // Open filename for reading, using a buffer for better performance
            BufferedReader br = new BufferedReader(new FileReader((filename)));
            
            // Create an empty String (kinda like C's char*)
            String line;
            
            // Print an informational message with newline
            System.out.println("Here's the contents of my source file (" + filename + "):\n");
            
            // Read each line from the file (line=br.readLine()) until the end (!= null)
            // Print each line that is read with newline
            while((line=br.readLine()) != null) System.out.println("  " + line); 
            
        // If an error occurred, just print a message to the error console (System.err) with newline
        } catch (FileNotFoundException e) {
            System.err.println("File " + filename + " can't be opened!\n" + e);
        } catch (EOFException e) {
            System.err.println("Tried to read past the end of " + filename + "!\n" + e);
        } catch (IOException e) {            
            System.err.println("File " + filename + " can't be read!\n" + e);
        }
    }
}

