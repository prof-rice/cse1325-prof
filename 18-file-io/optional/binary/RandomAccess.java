import java.io.*;

public class RandomAccess {
    public static void main(String[] args) throws IOException {
        RandomAccessFile io = new RandomAccessFile("random_io.txt", "rw");
        io.writeUTF("Hello, world!");
        io.seek(0);
        System.out.println(io.readUTF());
    }
}
