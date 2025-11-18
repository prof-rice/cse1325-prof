import java.util.Map;
import java.util.TreeMap;

import static qlogger.Qlogger.log;

public class ThreadedPrimes extends Primes {
    @Override
    public void search(long begin, long end, int numThreads) {
        Thread[] threads = new Thread[numThreads];
        long delta = (end - begin)/numThreads;
        
        for(int i=0; i<numThreads; ++i) {
            final int threadID = i;
            final long beginFinal = begin;
            final long endFinal = (i < (numThreads-1)) 
                ? beginFinal + delta
                : end;
            threads[i] = new Thread(
                () -> findPrimes(beginFinal, endFinal, threadID));
            threads[i].start();
            begin += delta;
        }
        
        for(int i=0; i<numThreads; ++i) {
            try {
                threads[i].join();
            } catch(InterruptedException e) {
                log("Interrupted exception on thread " + i);
            }
        }
    }
    @Override
    protected synchronized void addPrime(long prime, int threadID) {
        super.addPrime(prime, threadID);
    }
}
