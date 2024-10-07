public class BonjourSleep implements Runnable {
    String message;
    public BonjourSleep(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        System.out.println(message);
    }
    public static void main(String[] args) {
        (new Thread(new Bonjour("Hello"))).start();
        (new Thread(new Bonjour("Hola"))).start();
        (new Thread(new Bonjour("Bonjour"))).start();
        // Threads will auto-join on exit in Java
    }
}
