import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

class Work {
    public Work() {
        this.milliseconds = 100+random.nextInt(1000); // How long this "task" will take
        this.workID = nextWorkID++;                   // A name for this "task"
    }
    public void doWork(int threadID) {
        this.threadID = threadID;                     // Remember which thread did this work
        System.out.println("Work " + workID + " started by thread " + threadID);
        started = new Date();                         // Remember when this "task" started
        try {
            Thread.sleep(milliseconds);               // "Do" the work
        } catch(InterruptedException e) {
        }
        finished = new Date();                        // Remember when this "task" finished
    }
    @Override
    public String toString() {
        return "Work by thread " + threadID + " started  " + date.format(started)
                                            + " finished " + date.format(finished);
    }
    private int workID;
    private int threadID;
    private Date started;
    private Date finished;
    private long milliseconds;
    private static int nextWorkID = 0;
    private static Random random = new Random();
    private static SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");  
}

public class ThreadPool {
    public static final int WORK_SIZE = 100;
    public ThreadPool() {
        for(int i=0; i<WORK_SIZE; ++i) work.push(new Work());
    }
    public void worker(int threadID) {
        Work w = null;
        try {
            while(true) {
                synchronized(lock) {
                    w = work.pop();
                }
                w.doWork(threadID);
            }
        } catch(Exception e) {
        }  
    }
    private static Object lock = new Object();
    private Deque<Work> work = new ArrayDeque<>();
    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("usage: Java ThreadPool numThreads");
            System.exit(0);
        }
        int numThreads = Integer.parseInt(args[0]);
        ThreadPool pool = new ThreadPool();
        Thread[] threads = new Thread[numThreads];
        for(int i=0; i<numThreads; ++i) {
            final int threadID = i;
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
}
