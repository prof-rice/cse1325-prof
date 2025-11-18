import java.util.Map;
import java.util.TreeMap;

import static qlogger.Qlogger.log;

public class Primes {
    public Primes() {
        primes = new TreeMap<>();
        maxPrime = 0;
    }
    public void search(long begin, long end, int numThreads) {
        findPrimes(begin, end, -1);    
    }
    public int size() {
        return primes.size();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Long, Integer> e : primes.entrySet()) {
            sb.append(String.format("%" + 
               Long.toString(maxPrime).length() +
               "d found by thread %d\n", 
               e.getKey(), e.getValue()
            ));
        }
        return sb.toString();
    }
    public static boolean isPrime(long number) {
        if(number < 2) return false;
        for (long i=2; i <= Math.sqrt(number); ++i) {
            if ((number % i) == 0) return false;
        }
        return true;
    }
    
    protected void findPrimes(long begin, long end, int threadID) {
        log("Thread " + threadID + " is searching " + begin + " to " + (end-1));
        for(long i=begin; i<end; ++i) {
            if(isPrime(i)) addPrime(i, threadID);
        }
    }
    protected void addPrime(long prime, int threadID) {
        primes.put(prime, threadID);
        if(prime > maxPrime) maxPrime = prime;
    }
    
    private long maxPrime;
    private Map<Long, Integer> primes;
}
