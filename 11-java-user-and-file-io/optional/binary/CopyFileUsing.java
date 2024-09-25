import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileUsing {
    public static void main(String args[]) throws IOException {
        if(args.length != 2) {
            System.err.println("usage: java CopyFile [sourcefile] [destinationFile]");
            System.exit(-1);
        }
      
        try (
            FileInputStream in = new FileInputStream(args[0]);
            FileOutputStream out = new FileOutputStream(args[1]);
        ) { 
            int c;
            while ((c = in.read()) != -1) out.write(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

