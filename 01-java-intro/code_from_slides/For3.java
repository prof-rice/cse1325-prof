import java.util.Scanner;

public class For3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        for(String line = ""; in.hasNextLine() ; ) {
            line = in.nextLine();
            System.out.println(line);
        }
    }
}
