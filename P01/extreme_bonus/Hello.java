// This is the quick-and-easy answer: Get the $USER environment variable
// Should work on any system

public class Hello {
    public static void main(String[] args) {
        String name = System.getenv("USER");
        System.out.println("Hello, " + name + "!");
    }
}   
