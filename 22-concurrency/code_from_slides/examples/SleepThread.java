import java.util.Scanner;

public class SleepThread implements Runnable {
    // We use this Boolean as a signal (better known as a "semaphore")
    //   to know when main() is finished.
    private static boolean done = false;

    // We loop until our semaphore says to stop.
    // Thread.sleep pauses for the milliseconds specified in its parameter.
    // Thread.sleep requires that we handle InterruptedException.
    @Override
    public void run() {
        try {
            while(!done) {
                System.out.println("*hiccup*");
                Thread.sleep(1000 + (int)(Math.random() * 3000));
            }
        } catch(InterruptedException e) {
            System.err.println("Thread abort: " + e);
        }
    }
    public static void main(String args[]) throws InterruptedException {
        // We collapse 2 instances and a method call into a single line,
        //   causing method run() to execute in parallel.
        (new Thread(new SleepThread())).start();

        // main() continues with some console I/O, including a 6s sleep.
        Scanner in = new Scanner(System.in);
        System.out.println("Who has the hiccups?");
        String name = in.nextLine();
        Thread.sleep(6000);
        System.out.println("Hey " + name + " - BOO!!!!!");

        // Signal to the thread that we're finished. The program continues
        //   until all threads have also exited.
        done = true;
    }
}
