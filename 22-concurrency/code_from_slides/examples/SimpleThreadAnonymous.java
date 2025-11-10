public class SimpleThreadAnonymous {
    public static void main(String args[]) throws InterruptedException {
        Runnable tmain = new Runnable() { // Anonymous class implements Runnable
            @Override
            public void run() {           // Override run(), the thread's "main"
                for(int i=0; i<10; ++i) 
                    System.out.println("Thread count " + i);
            }
        };
        Thread thread = new Thread(tmain); // Instance a thread to run main
        thread.start();                    // Begin running the thread
        for(int i=0; i<10; ++i)            // main continues running here
            System.out.println("Main count " + i);
        thread.join();                     // thread will rejoin main here
    }
}

