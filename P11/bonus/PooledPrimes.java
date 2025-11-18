import java.util.Map;
import java.util.TreeMap;

import static qlogger.Qlogger.log;

public class PooledPrimes extends ThreadedPrimes {
    public static final int SLICES = 50;
    @Override
    public void search(long begin, long end, int numThreads) {
        sliceSize = 1 + (end - begin) / SLICES;
        // log("Slice size = " + sliceSize);
        
        currentSlice = begin - sliceSize;
        endSlice = end;
    
        Thread[] threads = new Thread[numThreads];
        
        for(int i=0; i<numThreads; ++i) {
            final int threadID = i;
            threads[i] = new Thread(() -> searchWorker(threadID));
            threads[i].start();
        }
        
        for(int i=0; i<numThreads; ++i) {
            try {
                threads[i].join();
            } catch(InterruptedException e) {
                log("Interrupted exception on thread " + i);
            }
        }
    }
    private void searchWorker(int threadID) {
        log("Started worker with threadID = " + threadID);
        while(true) {
            long slice = nextSlice();
            if(slice < 0) break;
            findPrimes(slice, Math.min(slice+sliceSize, endSlice), threadID);
        }
    }
    private synchronized long nextSlice() {
        currentSlice += sliceSize;
        return (currentSlice < endSlice) ? currentSlice : -1; 
    }
    private long currentSlice;
    private long endSlice;
    private long sliceSize;
}
