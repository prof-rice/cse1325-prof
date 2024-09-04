import java.util.Stack;

public class StackExplorer {
    private static java.io.Console console = System.console();
    public static void main(String[] args) {
        // Declare a Stack like an ArrayList
        Stack<String> stack = new Stack<>();
        String command = "";
        String value = "";
        String prompt = "\nCommand (quit, empty, push, peek, pop, search)? ";
        
        while(true) {
            // Print the stack
            System.out.println("\n====== " + stack.size() + " String elements ======");
            for(String s : stack) System.out.println("  " + s);
            
            // Read a command and optional value
            String line = console.readLine(prompt).trim();
            try {
                command = line.split("\\s+", 2)[0];
            } catch(Exception e) {
                System.err.println("##### Invalid Command");
                continue;
            }
            try {

                value = line.split("\\s+", 2)[1];
            } catch(Exception e) {
                value = "";
            }
            
            // Process the command
            try {
                if(command.startsWith("quit")) break;
                else if(command.startsWith("empty")) {
                    System.out.println(">> Empty is " + stack.empty());
                }
                else if(command.startsWith("push")) {
                    stack.push(value); 
                    System.out.println(">> Pushed " + value);
                }
                else if(command.startsWith("peek")) {
                    value = stack.peek();
                    System.out.println(">> Peek is " + value);
                }
                else if(command.startsWith("pop")) {
                    value = stack.pop();
                    System.out.println(">> Popped " + value);
                }
                else if(command.startsWith("search")) {
                    System.out.println(">> Found at " + stack.search(value));
                }
                else {
                    System.err.println("##### Invalid Command: " + command);
                }
            } catch(Exception e) {
                System.err.println("##### Exception: " + e + " > " + e.getMessage());
            }
        }
    }
}
