public class SimpleThreadLambda {
    private static void count() {
        for(int i=0; i<10; ++i) 
            System.out.println("Thread count " + i);
    }
    public static void main(String args[]) throws InterruptedException {
        Thread thread = new Thread(() -> count());
        thread.start();
        for(int i=0; i<10; ++i) 
            System.out.println("Main count " + i);
        thread.join();
    }
}
