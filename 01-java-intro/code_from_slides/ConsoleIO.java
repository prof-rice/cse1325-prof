public class ConsoleIO {
    public static void main(String[] args) {
        java.io.Console console = System.console();
        int a = 42;
        console.printf("As easy as 1, 2, %d\n", a);
        String s = console.readLine("Don't you think? ");
        console.printf("You really think %s???\n", s);
    }
}
