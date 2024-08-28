import java.util.Scanner;

// YOU MAY IGNORE THIS PROGRAM

public class Hello_autoclose {
    public static void main(String[] args) {
    
        // This is called "try-with-resources"
        // It guarantees that System.in will close!
        
        try(Scanner in = new Scanner(System.in)) {
            System.out.print("What is your name? ");
            String name = in.nextLine();
            System.out.println("Hello, " + name + "!");
        } catch(Exception e) {
            System.err.println(e);
        }
        
        // System.in is now closed.
        
        Scanner in2 = new Scanner(System.in);

        // The program will abort here
        String name = in2.nextLine();

        System.out.println("Hello, " + name + "!");
        in2.close();

    }
} 
