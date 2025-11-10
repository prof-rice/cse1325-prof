public class BadIO {
    private static boolean go = false; // Printing begins once this is true
    public static void printByChar() {
        String s = "Welcome, warm and friendly Java!\n";
        go = true; // Tell main we're ready!
        for(char c : s.toCharArray()) {
            System.out.print(c); 
            System.out.flush();  // Force the character onto the terminal
        }
    }
    public static void main(String[] args) throws InterruptedException {
        String s = "Goodbye, cold cruel world!\n";
        Thread thread = new Thread(() -> printByChar());
        thread.start();
        while(!go) ;    // Wait until thread is ready
        for(char c : s.toCharArray()) {
            System.out.print(c); 
            System.out.flush();  // Force the character onto the terminal
        }
        thread.join();
    }
}
