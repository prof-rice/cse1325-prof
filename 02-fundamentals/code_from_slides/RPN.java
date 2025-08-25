// Example #4: Reverse Polish Notation (RPN) Calculator
//
// Techniques Illustrated
//
// Different in Java:
//   Importing a package
//   Global constants (called "final static fields" in Java)
//   Functions (called "static methods" in Java)
//   "Private" functions (can't be seen in other files)
//   Arrays
//   Loop, reading text from console (STDIN) until end-of-file
//   Calculating the length of text in a String
//   Converting text ("String") to a double
//   Splitting a line of text into "words"
//   Using new to allocate an object from a type
//   Printing to the console (STDOUT) with print and println
//   Printing to the error console (STDERR) with println
//   Recovering from a "segfault" without aborting
//
// Similar to C:
//   Initializing local primitives
//   3-term for loops
//   Continue a loop
//   Simple if statements
//   Switch statements (but without the breaks!)
//   Formatted output with printf
//   Exit the program without a return statement

import java.util.Scanner;

public class RPN {
    // Equivalent to C's global const
    public final static int STACK_SIZE = 4; // Must be <= REGISTER_NAME.length()
    public final static String REGISTER_NAME = "xyzwvutsrqponmlkjihgfedcba";
    
    // /////////////////////////////////////////////////////////////////////////
    // This is the stack and the low-level functions that manipulate it
    
    // typically named x y z w
    //  for subscripts 0 1 2 3
    private static double[] stack = new double[STACK_SIZE]; 

    // x y z w ->
    // x x y z
    private static void rollUp() {
        for(int i=STACK_SIZE-2; i>=0; --i) stack[i+1] = stack[i];
        // So for 4, stack[3] = stack[2]; stack[2] = stack[1]; stack[1] = stack[0];
    }
    // x y z w ->
    // v x y z    (v is the pushed value)
    private static void push(double value) {
        rollUp();
        stack[0] = value;
    }
    // x y z w ->
    // y z w w return x
    private static double pop() {
        double result = stack[0];
        for(int i=0; i<STACK_SIZE-1; ++i) stack[i] = stack[i+1];
        return result;
    }
    // x y z w ->
    // y x z w
    private static void swap() {
        double temp = stack[0];
        stack[0] = stack[1];
        stack[1] = temp;
    }
    
    // /////////////////////////////////////////////////////////////////////////
    // These are the user interface functions
    
    // prints the 4 stack registers
    public static void printStack() {
        for(int i=STACK_SIZE-1; i>=0; --i) 
            System.out.printf("%20.6f %c\n",  stack[i], 
                              REGISTER_NAME.charAt(i));
        System.out.print("? for help >> ");
    }
    
    // Display the known commands
    public static void printHelp() {
       System.out.println("\nCommands\n--------");
       System.out.println("[double]    : push");
       System.out.println("+ - * /     : math operators");
       System.out.println("negate      : change the sign");
       System.out.println("[Enter] v   : roll stack up or down");
       System.out.println("y           : swap x and y");
       System.out.println("qrt exp     : square root, x^y");
       System.out.println("sin cos tan : trig functions");
       System.out.println("SIN COS TAN : arc trig functions");
       System.out.println("deg rad pi  : to degees or radians, π");
       System.out.println("?           : help");
       System.out.println("x           : exit\n");
    }
    
    // Execute the command given
    public static void executeCommand(String command) {
        for(String s : command.split(" ")) { // better, command.split("\\s+")
            if(s.length() == 0) {rollUp(); continue;}
            switch(s.charAt(0)) {
                case '+' ->          push(pop()+pop());
             // case '-' -> {swap(); push(pop()-pop());} // see default!
                case '*' ->          push(pop()*pop());
                case '/' -> {swap(); push(pop()/pop());}
                case 'n' ->          push(-pop());
                case 'v' ->          pop();
                case 'y' ->          swap();
                case '?' ->          printHelp();
                case 'x' ->          System.exit(0);

                case 'q' ->          push(Math.sqrt(pop()));
                case 'e' -> {swap(); push(Math.pow(pop(), pop()));}
                case 's' ->          push(Math.sin(pop()));
                case 'c' ->          push(Math.cos(pop()));
                case 't' ->          push(Math.tan(pop()));
                case 'S' ->          push(Math.asin(pop()));
                case 'C' ->          push(Math.acos(pop()));
                case 'T' ->          push(Math.atan(pop()));
                case 'd' ->          push(Math.toDegrees(pop()));
                case 'r' ->          push(Math.toRadians(pop()));
                case 'p' ->          push(Math.PI);

                // Because negative doubles start with -, 
                // just like the - operator does,
                // we must handle the - operator here!
                default  -> {
                    if(s.charAt(0) == '-' && s.length() == 1)  // - operator
                            {swap(); push(pop()-pop());}
                    else                                       // push double
                                     push(Double.parseDouble(s));
                }
            }
        }
    }

    // /////////////////////////////////////////////////////////////////////////
    // This is the main function

    public static void main(String[] args) {
        if(STACK_SIZE > REGISTER_NAME.length()) {
            System.err.println("PANIC: STACK_SIZE too large: " + STACK_SIZE);
            System.exit(-1);
        }
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("==============\nRPN calculator\n==============");

        printHelp();
        printStack();

        // Main loop
        while(scanner.hasNextLine()) { // Loop as long as we have new commands
            try {
                executeCommand(scanner.nextLine());
            } catch(Exception e) { // Executes if a "segfault" occurs :)
                System.err.println("Invalid function requested");
            }
            printStack();
        };
    }
}
