public class BadSync {
    private final static Integer numThreads = 50;
    private final static Integer numDecrements = 5000;
    private static Integer counter = numThreads * numDecrements;
    
    // Our thread simply decrements counter numDecrements times
    public static void decrementer() {
        for(int i=0; i<numDecrements; ++i) {
            // NO! NEVER sync on an primitive-based type (like Integer) or String
            //   and NEVER use public objects which might be changed by other code
            synchronized(counter) {
                --counter;
            }
        }
    }
    
    // Main creates and starts numThreads threads.
    //   When they've all exited, it prints counter.
    public static void main(String[] args) 
            throws InterruptedException {
            
        // Create array to reference the threads
        Thread[] threads = new Thread[numThreads];
        
        // Start a thread for each array element
        for(int i=0; i<numThreads; ++i) {
            threads[i] = new Thread(() -> decrementer());
            threads[i].start();  // Start decrementing
        }
        
        // Join all threads
        for(int i=0; i<numThreads; ++i)
            threads[i].join();
        
        // Show counter - is it actually 0?
        System.out.println("Should be 0: " + counter);
    }
}
