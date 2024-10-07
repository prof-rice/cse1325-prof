public class SimpleThread implements Runnable {

    // Interface Runnable requires overriding the run method.
    // When the Thread object starts via Thread.start() below, 
    //   run() executes simultaneous (as it were) with main()
    @Override
    public void run() {
        for(int i=0; i<10; ++i) 
            System.out.println("Thread count " + i);
    }

    public static void main(String args[]) {
        // This instance implements Runnable
        //   and thus has a run() method
        SimpleThread st = new SimpleThread();

        // The Thread instance queues up st.run()
        Thread t = new Thread(st);

        // The start() method begins executing st.run()
        t.start();

        for(int i=0; i<10; ++i) 
            System.out.println("Main count " + i);
    }
}
