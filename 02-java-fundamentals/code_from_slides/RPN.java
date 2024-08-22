// Example #4: Reverse Polish Notation (RPN) Calculator
//
// Techniques Illustrated
//
// Different in Java:
//   Importing a package
//   Global constants (called "final static fields" in Java)
//   Functions (called "static methods" in Java)
//   Arrays
//   Converting text ("String") to a double
//   Splitting a line of text into "words"
//   Reading text from the console (STDIN)
//   Printing to the console (STDOUT)
//
// Similar to C:
//   Initializing local primitives
//   3-term for loops
//   Simple if statements
//   Switch statements (but without the breaks!)
//   Formatted output with printf

import java.util.Scanner;

public class RPN {
    public final static int STACK_SIZE = 4;
    // typically named x y z w
    //  for subscripts 0 1 2 3
    private static double[] stack = new double[STACK_SIZE]; 

    // x y z w ->
    // x x y z
    public static void rollUp() {
        for(int i=STACK_SIZE-2; i>=0; --i) stack[i+1] = stack[i];
        // So for 4, stack[3] = stack[2]; stack[2] = stack[1]; stack[1] = stack[0];
    }
    // v -> x y z w ->
    //      v x y z
    public static void push(double value) {
        rollUp();
        stack[0] = value;
    }
    // x y z w ->
    // y z w w return x
    public static double pop() {
        double result = stack[0];
        for(int i=0; i<STACK_SIZE-1; ++i) stack[i] = stack[i+1];
        return result;
    }
    // x y z w ->
    // y x z w
    public static void swap() {
        double temp = stack[0];
        stack[0] = stack[1];
        stack[1] = temp;
    }
    // prints the 4 stack registers
    public static void printStack() {
        String registerName = "xyzwvutsrqponmlkjihgfedcba";
        for(int i=STACK_SIZE-1; i>=0; --i) 
            System.out.printf("%20.6f %c\n",  stack[i], 
                              registerName.charAt(i));
        System.out.print("> ");
    }
    public static void printHelp() {
       System.out.println("\nCommands\n--------");
       System.out.println("[double] : push");
       System.out.println("+ - * /  : math operators");
       System.out.println("^ v      : roll stack up or down");
       System.out.println("y        : swap x and y");
       System.out.println("?        : help");
       System.out.println("x        : exit\n");
    }
    // ////
    // MAIN
    // ////
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("==============\nRPN calculator\n==============");

        printHelp();
        printStack();
        
        // Main loop
        while(in.hasNextLine()) {
            String command = in.nextLine();
            for(String s : command.split(" ")) { // better, command.split("\\s+")
                switch(s.charAt(0)) {
                    case '+' ->          push(pop()+pop());
                    case '-' -> {swap(); push(pop()-pop());}
                    case '*' ->          push(pop()*pop());
                    case '/' -> {swap(); push(pop()/pop());}
                    case '^' ->  rollUp();
                    case 'v' ->  pop();
                    case 'y' ->  swap();
                    case '?' ->  printHelp();
                    case 'x' ->  System.exit(0);
                    default  ->  push(Double.parseDouble(s));
                }
            }
            printStack();
        }
    }
}
