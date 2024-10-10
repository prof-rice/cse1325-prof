public class Scroller <E> {  // Also called Marquee or Banner
    public Scroller(E value, int position) {
        this.value = value;
        this.position = position;
        this.originalPosition = position;
    }
    public E getValue() {
        return value;
    }
    // OPTION 1: "synchronized" protects scroll() from thread interference
    public synchronized void scroll() {
        if(--position < 0) position = originalPosition;
        System.out.print("\r"); // return to start of line (except on Mac)
        for(int i=0; i<position; ++i) System.out.print(" ");
        System.out.print(value.toString() + "  ");
        System.out.flush();
    }
    public void autoScroll(int milliseconds) {
        if(thread != null) {
            autoScrollEnabled = false;
            try {
                thread.join();
            } catch(InterruptedException e) {
                System.err.println("#### thread join interrupted!");
            }
        }
        if(milliseconds < 1)  return;
        autoScrollEnabled = true;
        thread = new Thread(() -> {
            while(autoScrollEnabled) {
                // OR use synchronized(this) {scroll();}
                scroll();
                try {
                    Thread.sleep(milliseconds);
                } catch(InterruptedException e) {
                    System.err.println("#### thread sleep interrupted!");
                }
            }
        });
        thread.start();
    }
    
    private E value;  // Also called message or post
    private int position;
    private int originalPosition;
    private Thread thread;
    private boolean autoScrollEnabled;

    public static void main(String[] args) {
        Scroller<Double> scroller = new Scroller<>(Math.PI, 5);
        for(int i=0; i<3; ++i) {
            scroller.scroll();
            try {Thread.sleep(1000);} catch(InterruptedException e) {}
        }
        scroller.autoScroll(500);
        try {Thread.sleep(10000);} catch(InterruptedException e) {}
        scroller.autoScroll(-1);
        System.out.println("\nDone!");
    }
}
