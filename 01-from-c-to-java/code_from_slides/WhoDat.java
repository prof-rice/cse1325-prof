import java.util.Scanner;

public class WhoDat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String s = scanner.nextLine();
        System.out.println("Your name‘s " + s);
    }
}

