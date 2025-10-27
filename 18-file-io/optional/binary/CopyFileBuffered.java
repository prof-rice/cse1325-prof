import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileBuffered {
    private static final int BUFFER_SIZE = 16384; // 16 kilobytes
 
    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println("usage: java CopyFileBuffered [sourcefile] [destinationFile]");
            System.exit(-1);
        }
 
        try (
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(args[0]));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(args[1]));
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];  // Buffer to hold block of data
            int length;                             // Number of bytes actually read
            while ((length = in.read(buffer)) > 0) out.write(buffer, 0, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
