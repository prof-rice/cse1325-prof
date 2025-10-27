import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException { 
        Scanner scanner = new Scanner(new File(args[0]));
        while(scanner.hasNextLine()) 
            System.out.println(scanner.nextLine());
        scanner.close();
    }
}
