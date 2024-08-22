// This is (for now) the name of the Java file - TestJavaArgs.java
public class TestJavaArgs {

    // This is where 'java TestJavaArgs' begins running (like C's int main() function)
    public static void main(String[] args) {
    
        // Print a message with newline to the console display (System.out)
        System.out.println("Your args (command line parameters) were:");
        
        // Loop through all of the program arguments (args), printing each with newline
        for(String s : args) System.out.println("  " + s);
    }
}
