import java.util.Scanner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WriteString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter some text and I'll write it to a String stream!"
            + "\n    (Press eof when done - Control-d or (on Windows) Control-z)\n");

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             PrintStream ps = new PrintStream(out)) {
            while(in.hasNextLine()) ps.println(in.nextLine());
            System.out.println("\n\nHere's the contents of the String:\n" + out);
            
        } catch(Exception e) {
            System.err.println("\nFailed to stream your text to a String. :(");
            e.printStackTrace();
        }
        
    }

}
