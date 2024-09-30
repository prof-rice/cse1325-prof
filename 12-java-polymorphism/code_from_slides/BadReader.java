import java.util.Scanner;
import java.util.ArrayList;
import java.net.URLConnection;
import java.net.URL;
import java.net.URISyntaxException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

class BookFetcher {
    public BookFetcher(String url) {
        this.url = url;
    }
    public String fetch() throws IOException, URISyntaxException {
        String str = "";
        URLConnection conn 
            = new URL(url).openConnection();
        BufferedReader br = new BufferedReader(
            new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
    
        while (br.readLine() != null)
            str += br.readLine();
        
        return str;
    } 
    private String url;
}

public class BadReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Press Enter to continue:");
        String wait = sc.nextLine();   // Wait for user to press Enter

        {
            BookFetcher remote = new BookFetcher("http://norvig.com/big.txt");
            try {
                String book = remote.fetch();
            } catch (Exception e) {
            }
            
            System.out.print("Press Enter to continue:");
            wait = sc.nextLine();   // Wait for user to press Enter
        }
        
        System.out.print("Press Enter to continue:");
        wait = sc.nextLine();   // Wait for user to press Enter
    }
}


