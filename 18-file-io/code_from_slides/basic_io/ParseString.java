import java.util.Scanner;

public class ParseString {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner("1 2 3 4");
            while(in.hasNextInt()) 
                System.out.println(in.nextInt());
        } catch(Exception e) {
            System.out.println("Failed to parse String: " + e);
        }
    }
}
