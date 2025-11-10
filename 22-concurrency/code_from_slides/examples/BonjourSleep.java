import java.util.Random;

public class BonjourSleep {
    private static Random random = new Random();
    public static void greet(String message) {
        try {
            Thread.sleep(random.nextInt(1000));
            System.out.println(message);
        } catch(InterruptedException e) {
        }
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
