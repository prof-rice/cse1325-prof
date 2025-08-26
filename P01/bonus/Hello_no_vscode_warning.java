import java.util.Scanner;

public class Hello_no_vscode_warning {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = in.nextLine();
        System.out.println("Hello, " + name + "!");
    }
} 
