public class DemoConsole {
    public static void main(String[] args) {
        int a = 42;
        System.console().printf("As easy as 1, 2, %d\n", a);
        String s = System.console().readLine("Don't you think? ");
        System.console().printf("You really think %s???\n", s);
    }
}
