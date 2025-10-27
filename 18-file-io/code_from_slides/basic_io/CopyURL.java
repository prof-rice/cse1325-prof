import java.net.URL;
import java.util.Scanner;

public class CopyURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.testingmcafeesites.com/");
            Scanner urlScanner = new Scanner(url.openStream());
            while(urlScanner.hasNextLine()) 
                System.out.println(urlScanner.nextLine());
        } catch(Exception e) {
            System.out.println("Failed to read website: " + e);
        }
    }
}
