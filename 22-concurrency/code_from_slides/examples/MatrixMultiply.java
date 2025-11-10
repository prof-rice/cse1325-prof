import java.util.Set;
import java.util.HashSet;

public class MatrixMultiply {
    public static final int SIZE = 500;
    
    public void multiply(int matrices) {
        while(matrices-- > 0) {
            Matrix m1 = new Matrix(SIZE); m1.fill();
            Matrix m2 = new Matrix(SIZE); m2.fill();
            Matrix m3 = m1.multiply(m2);
            System.out.print(m3.xor() + " ");
        }
    }
    
    public static void main(String[] args) {
        if(args.length == 0 || args.length > 2 || args[0].equals("-h")) 
            System.err.println("Usage: java MatrixMultiply <numMultiplies> [<numThreads>]");

        int numMultiplies = (args.length > 0) ? Integer.parseInt(args[0]) : 1;
        int numThreads    = (args.length > 1) ? Integer.parseInt(args[1]) : 1;
        
        Set<Thread> threads = new HashSet<>();
        
        for(int i=0; i<numThreads; ++i) {
            final MatrixMultiply mm = new MatrixMultiply();
            Thread thread = new Thread(() -> mm.multiply(numMultiplies));
            thread.start();
            threads.add(thread);
        }
        
        for(Thread thread : threads) {
            try {
                thread.join();
            } catch(InterruptedException e) {
                System.err.println("ABORT: " + e);
            }
        }
        System.out.println();
    }
}
