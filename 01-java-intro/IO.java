class Console {
    public String readLine(String prompt) {
        System.out.print(prompt);
        return (new java.util.Scanner(System.in)).nextLine();
    }
    public void printf(String format, String data) {
        System.out.printf(format, data);
    }
}

public class IO {
    public static void option1() {
        java.io.Console io = System.console();
        String s = io.readLine("What's your name? ");
        io.printf("Hello, %s\n", s);
    }
    public static void option2() {
        Console io = new Console();
        String s = io.readLine("What's your name? ");
        io.printf("Hello, %s\n", s);
    }
    public static void main(String[] args) {
        System.out.println("\n---\nUsing java.io.Console\n");
        option1();

        System.out.println("\n---\nUsing my simple Console\n");
        option2();
        
    }
}
