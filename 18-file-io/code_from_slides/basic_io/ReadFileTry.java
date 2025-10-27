import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ReadFileTry {
    public static void main(String[] args) { 
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(args[0]));
            while(scanner.hasNextLine()) 
                System.out.println(scanner.nextLine());
        } catch (IOException e) {
            System.err.println("Failed to read file: " + e);
        } finally {
            try {
                scanner.close();
            } catch (Exception e) {
                System.err.println("Failed to close file: " + e);
            }
        }
    }
}
