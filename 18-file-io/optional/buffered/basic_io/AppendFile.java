import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class AppendFile {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[0], true));
        bw.write("Hello AGAIN, world!\n");
        bw.close();
    }
}
