import java.io.PrintStream;
import java.io.FileNotFoundException;

public class WriteFile {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream(args[0]);
        ps.println("Hello, world!");
    }
}
