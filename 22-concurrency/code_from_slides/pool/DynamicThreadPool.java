import java.util.Deque;
import java.util.LinkedList;

import java.util.List;
import java.util.ArrayList;

import java.util.Random;

public class DynamicThreadPool {
    public static void source(int sourceID) {  // Thread "main" that generates work
        System.out.println("Source " + sourceID + " ready to create work!");
        while(running) {
            try {
                Thread.sleep(random.nextInt(sourcePeriod));
                synchronized(lock) {
                    tasks.addFirst(new Work());
                }
            } catch(Exception e) {
                System.err.println("ABORT: sourceID " + sourceID);
            }
        } 
        System.out.println("Source " + sourceID + " exits");
    }
    public static void worker(int workerID) {     // This is the thread "main"
        System.out.println("Thread " + workerID + " ready to work!");
        Work w = null;  // Reference to a unit of work (a "task")
        while(running) {
            try {
                synchronized(lock) {       // Avoid thread contention getting a task
                    w = tasks.pollLast();  // Returns Work or null if tasks.isEmpty()
                }
                if(w != null) w.doWork(workerID); // Do the task (if one is available)
                else Thread.sleep(100);           // Otherwise pause 0.1 sec and try again
            } catch(Exception e) {         // Unexpected exception - report and continue
                System.err.println("ABORT: workerID " + workerID +
                    " doing WorkID " + w.getWorkID() + ": " + e);
            }
        } 
        System.out.println("Thread " + workerID + " exits");
    }
    
    public static void main(String[] args) throws InterruptedException {        
        // DynamicThreadPool pool = new DynamicThreadPool();
        List<Thread> sources = new ArrayList<>();  // These threads generate work
        List<Thread> workers = new ArrayList<>();  // These threads do the work
        int nextSourceID = -1;
        int nextWorkerID = 1;
        
        for(int loop = 0; loop < 120; ++loop) {
            // System.out.printf("\n\nLoop %3d: Sources: %4d  Workers: %4d  Queue: %4d\n", 
            //     loop, sources.size(), workers.size(), tasks.size());
            System.out.printf("\n\nLoop %3d:\nSources: %s %d\nWorkers: %s %d\nQueue:   %s %d\n", 
                loop, "+".repeat(sources.size()), sources.size(),
                      "=".repeat(workers.size()), workers.size(),
                      "*".repeat(tasks.size()),   tasks.size());
            if((tasks.size() < 1 && loop%5 == 0) || (loop%40 == 39)) {
                final int id = nextSourceID--;
                Thread source = new Thread(() -> source(id));
                source.start();
                sources.add(source);
            }
            if((tasks.size() > 32 && loop%3 == 1) || (loop == 0)) {
                final int id = nextWorkerID++;
                Thread worker = new Thread(() -> worker(id));
                worker.start();
                workers.add(worker);
            }
            sourcePeriod = 50 + 2 * tasks.size();
            Thread.sleep(1000);  // Wait a second
        }
        running = false; // command all threads to shut down
        for(Thread thread : sources) thread.join();
        for(Thread thread : workers) thread.join();
    }
    
    private static final Object lock = new Object();
    private static Deque<Work> tasks = new LinkedList<>();
    private static Random random = new Random();
    private static boolean running = true;  // Shut down all threads if false
    private static int sourcePeriod = 200;  // Twice the ms between new units of work
}
