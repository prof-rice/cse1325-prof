import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;

public class WriteFileFile {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream(new File(args[0]));
        ps.println("Hello, world!");
    }
}
