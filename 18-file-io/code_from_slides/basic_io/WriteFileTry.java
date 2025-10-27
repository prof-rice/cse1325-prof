import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;

public class WriteFileTry {
    public static void main(String[] args) {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new File(args[0]));
            ps.println("Hello, world!");
        } catch (FileNotFoundException e) {
            System.err.println("Failed to print: " + e);
        } finally {
            try {
                ps.close(); // close if open
            } catch (Exception e) {
                System.err.println("Failed to close: " + e);
            }
        }
    }
}
