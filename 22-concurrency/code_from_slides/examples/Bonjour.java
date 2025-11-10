public class Bonjour {
    public static void greet(String message) {
        System.out.println(message);
    }
    public static void main(String[] args) throws InterruptedException {
        String[] messages = new String[]{"Hello", "Hola", "Bonjour", "你好", "नमस्ते"};
        Thread[] threads = new Thread[messages.length];
        for(int i=0; i<messages.length; ++i) {
            final int t = i;
            threads[t] = new Thread(() -> greet(messages[t]));
            threads[t].start();
        }
        for(Thread thread : threads) thread.join();
    }
}
