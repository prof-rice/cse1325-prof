import java.util.Scanner;

// YOU MAY IGNORE THIS PROGRAM

public class Hello_close {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = in.nextLine();
        System.out.println("Hello, " + name + "!");

        in.close();
        // System.in is now closed.
        
        Scanner in2 = new Scanner(System.in);

        // The program will abort here
        name = in2.nextLine();

        System.out.println("Hello, " + name + "!");
        in2.close();
    }
} 
