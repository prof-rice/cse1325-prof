import java.util.Scanner;
import java.util.ArrayList;
import java.net.URLConnection;
import java.net.URL;
import java.net.URISyntaxException;
import java.net.MalformedURLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

class BookFetcher {
    public BookFetcher(String url) throws MalformedURLException {
        this.url = new URL(url);
    }
    public String fetch() throws IOException, URISyntaxException {
        String str = "";

        BufferedReader br = new BufferedReader(
            new InputStreamReader(url.openConnection().getInputStream(), StandardCharsets.UTF_8));
    
        while (br.readLine() != null)
            str += br.readLine();
        
/*      // Equivalent to this, but using BufferedReader
        Scanner in = new Scanner(url.openStream());
        while(in.hasNextLine()) str += in.nextLine();
        return str;
*/

        return str;
    } 
    private URL url;
}

public class BadReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press Enter to continue:");
        String wait = scanner.nextLine();   // Wait for user to press Enter

        try {
            BookFetcher bookFetcher = new BookFetcher("http://norvig.com/big.txt");
            String book = bookFetcher.fetch();
            
            System.out.print("Press Enter to continue:");
            wait = scanner.nextLine();   // Wait for user to press Enter
        } catch(Exception e) {
            System.err.print("Exception fetching book: " + e);
        }
        
        System.out.print("Press Enter to continue:");
        wait = scanner.nextLine();   // Wait for user to press Enter
    }
}


