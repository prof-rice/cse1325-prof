public class HelloConsole {
    public static void main(String[] args) {
        System.out.println("Hello, " 
            + System.console().readLine("What is your name? ")
            + "!");
    }
}   
