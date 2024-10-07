public class Bonjour implements Runnable {
    String message;
    public Bonjour(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(100 + (int)(Math.random() * 300));
        } catch (InterruptedException e) {
            System.err.println(message + " abort: " + e);
        }
        System.out.println(message);
    }
    public static void main(String[] args) {
        (new Thread(new Bonjour("Hello"))).start();
        (new Thread(new Bonjour("Hola"))).start();
        (new Thread(new Bonjour("Bonjour"))).start();
        // Threads will auto-join on exit in Java
    }
}
