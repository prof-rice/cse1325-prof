// This is kinda like C's #include
import java.util.Scanner;

// This is (for now) the name of the Java file - TestJavaIO.java
public class TestJavaIO {

    // This is where 'java TestJavaIO' begins running (like C's int main() function)
    public static void main(String[] args) {
    
        // Create a scanner (kinda like scanf) that reads the keyboard (System.in)
        Scanner in = new Scanner(System.in);
        
        // Create a String (kinda like a char*) containing all valid grades
        String grades = "ABCDFI";
        
        // Create a char (just like in C) to hold the grade entered by the user
        char grade = '\0';
        
        // Loop until break
        while(true) {
        
            // Unformatted print without newline to the console display (System.out)
            System.out.print("What grade would you like in CSE1325? ");
            
            // If an exception (a type of error) occurs, jump to the catch statement
            try {
            
                // Read a line of text (in.nextLine()), get the first char (charAt(0)),
                //   and make it upper case (Character.toUpperCase)
                grade = Character.toUpperCase(in.nextLine().charAt(0));
                
                // If the grade entered is part of the grades String, break out of the while loop
                if(grades.indexOf(grade) >= 0) break;
                
                // Otherwise, print an error message and newline to the error console (System.err)
                System.err.println("Sorry, we have no " + grade + " grade!");
                
            // If an error occurred, just run the while loop again
            } catch (Exception e) {
            }
        }
        
        // Print an encouraging message with newline to the console display (System.out)
        System.out.println("Here's hoping for your " + grade + "!");
    }
}
