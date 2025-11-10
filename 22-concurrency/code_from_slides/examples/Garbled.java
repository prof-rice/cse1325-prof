class UnsynchronizedCounter {
    private int count = 0;
    public void increment() {
        count++;
    }
    public void decrement() {
        count--;
    }
    public int getCount() {
        return count;
    }
}
public class Garbled {
    private static UnsynchronizedCounter counter = new UnsynchronizedCounter();
    
    public static void incOrDec() {
        for(int i=0; i<50000; ++i) {
            if(i%2 == 0) counter.increment();
            else counter.decrement();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for(int i=0; i<10; ++i) {
            threads[i] = new Thread(() -> incOrDec());
            threads[i].start();
        }
        for(int i=0; i<10; ++i) {
            threads[i].join();
        }
        System.out.println("Should be 0: " + counter.getCount());
    }
}
