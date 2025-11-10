import java.util.Scanner;

public class InterruptThread implements Runnable {
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
            System.out.println("I'm cured!");
        }
    }
    public static void main(String args[]) throws InterruptedException {
        Thread t = new Thread(new InterruptThread());
        t.start();

        // main() continues with some console I/O, including a 6s sleep.
        Scanner in = new Scanner(System.in);
        System.out.println("Who has the hiccups?");
        String name = in.nextLine();
        Thread.sleep(6000);
        System.out.println("Hey " + name + " - BOO!!!!!");

        // Interrupt the thread. If waiting, the thread will throw an
        //   InterruptedException. If calculating, the thread must
        //   periodically poll Thread.interrupted().
        t.interrupt();

        // Pause until the thread exits (not strictly required here)
        //   or t.join(1000); to wait up to 1 second
        t.join();
    }
}
