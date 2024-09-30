import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileTry {
    public static void main(String[] args) throws IOException {
        BufferedWriter br = null;
        try {
            br = new BufferedWriter(new FileWriter(args[0]));
            br.write("Hello, world!\n");
        } catch (IOException e) {
            System.err.println("Failed to write: " + e);
        } finally {
            try {
                if(br != null) br.close(); // close if open
            } catch (IOException e) {
                System.err.println("Failed to close: " + e);
            }
        }
    }
}
