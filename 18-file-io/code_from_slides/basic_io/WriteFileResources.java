import java.io.PrintStream;
import java.io.File;
import java.io.IOException;

public class WriteFileResources {
    public static void main(String[] args) {
        try (PrintStream ps = new PrintStream(new File(args[0]))) {
            ps.println("Hello, world!");
        } catch (IOException e) {
            System.err.println("Failed to print: " + e);
        }
    }
}
