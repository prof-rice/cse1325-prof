import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ReadFileResources {
    public static void main(String[] args) { 
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) 
                System.out.println(scanner.nextLine());
        } catch(IOException e) {
            System.err.println("Error reading file: " + e);
        }
    }
}
