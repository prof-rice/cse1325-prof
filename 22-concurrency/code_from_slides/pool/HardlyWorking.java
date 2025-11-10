import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

class Work {
    public Work() {
        this.milliseconds = random.nextInt(1000);     // How long this "task" will take
        this.workID = nextWorkID++;                   // A unique name for this "task"
    }
    public void doWork(int threadID) throws InterruptedException {
        this.threadID = threadID;                     // Remember which thread did this work
        // System.out.println("Work " + workID + " started by thread " + threadID);
        System.out.print("."); System.out.flush();
        started = new Date();                         // Remember when this "task" started
        Thread.sleep(milliseconds);                   // "Do" the work
        finished = new Date();                        // Remember when this "task" finished
        // System.out.println(this);
    }
    public int getWorkID() {
        return workID;
    }
    @Override
    public String toString() {
        return "Work by thread " + threadID + 
            ((started  != null) ? " started  " + date.format(started) : " unstarted ") +
            ((finished != null) ? " finished " + date.format(finished) : " and unfinished");
    }

    private long milliseconds;         // How long this "task" will take
    private int workID;                // A unique name for this "task"
    
    private int threadID;              // "Name" of thread that did this work
    private Date started;              // When the task began
    private Date finished;             // When the task exited
    
    private static int nextWorkID = 0;           // Used to genearte unique workIDs
    private static Random random = new Random(); // Used to generate random milliseconds
    private static SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");  
}
