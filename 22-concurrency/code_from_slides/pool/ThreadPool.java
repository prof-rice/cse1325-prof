import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ThreadPool {
    public static final int WORK_SIZE = 100; // How many tasks to create
    
    public ThreadPool() {
        for(int i=0; i<WORK_SIZE; ++i) 
            tasks.addFirst(new Work());    // pre-load the work queue
    }
    public void worker(int threadID) {     // This is the thread "main"
        System.out.println("Thread " + threadID + " ready to work!");
        Work w = null;  // Reference to a unit of work (a "task")
        do {
            try {
                synchronized(lock) {       // Avoid thread contention getting a task
                    w = tasks.pollLast();  // Returns Work or null if tasks.isEmpty()
                }
                if(w != null) w.doWork(threadID); // Do the task (if one is available)

            } catch(Exception e) {         // Unexpected exception - report and continue
                System.err.println("ABORT: ThreadID " + threadID +
                    " doing WorkID " + w.getWorkID() + ": " + e);
            }
        } while(w != null);
        System.out.println("Thread " + threadID + " exits");
    }
    
    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("usage: java ThreadPool <numThreads>");
            System.exit(0);
        }
        int numThreads = Integer.parseInt(args[0]);
        
        ThreadPool pool = new ThreadPool();
        Thread[] threads = new Thread[numThreads];
        
        for(int i=0; i<numThreads; ++i) {
            final int threadID = i; // Just a simple unique thread identifier
            threads[i] = new Thread(() -> pool.worker(threadID));
            threads[i].start();
        }
        for(int i=0; i<numThreads; ++i) {
            try {
                threads[i].join();
            } catch(InterruptedException e) {
            }
        }
    }
    
    private static final Object lock = new Object();
    private Deque<Work> tasks = new LinkedList<>();
}
