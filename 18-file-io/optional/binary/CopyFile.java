import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
   public static void main(String args[]) throws IOException {
      if(args.length != 2) {
          System.err.println("usage: java CopyFile [sourcefile] [destinationFile]");
          System.exit(-1);
      }
      
      // Must be declared here to be in scope for both try and finally!
      FileInputStream in = null;
      FileOutputStream out = null;

      try {
         in = new FileInputStream(args[0]);
         out = new FileOutputStream(args[1]);
         
         int c;
         while ((c = in.read()) != -1) out.write(c);
      } finally {  // Executed regardless of how try was terminated
         if (in != null) in.close();
         if (out != null) out.close();
      }
   }
}

