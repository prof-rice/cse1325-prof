import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileResources {
    public static void main(String[] args) throws IOException {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(args[0]))) {
            br.write("Hello, world!\n");
        } catch (Exception e) {
            System.err.println("Failed to write: " + e);
        }
    }
}
