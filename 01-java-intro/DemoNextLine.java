import java.util.Scanner;

public class DemoNextLine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine())
            System.out.println(in.nextLine());
    }
}
