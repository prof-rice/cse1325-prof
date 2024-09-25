import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class WriteFile {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[0]));
        bw.write("Hello, world!\n");
        bw.close();
    }
}
