public class MatrixMultiply implements Runnable {
    public final int SIZE = 500;
    
    @Override
    public void run() {
        Matrix m1 = new Matrix(SIZE); m1.fill();
        Matrix m2 = new Matrix(SIZE); m2.fill();
        Matrix m3 = m1.multiply(m2);
        System.out.print(m3.xor() + " ");
    }
    
    public static void main(String[] args) {
        int numMultiplies = 1;
        int numThreads = 1;
        if(args.length == 0 || args.length > 2) {
            System.err.println("Usage: java MatrixMultiply numMultiplies [numThreads]");
            System.exit(0);
        }
        if(args.length > 0) numMultiplies = Integer.parseInt(args[0]);
        if(args.length > 1) numThreads = Integer.parseInt(args[1]);
        
        if(numThreads == 1) {
            MatrixMultiply mm = new MatrixMultiply();
            for(int i=0; i<numMultiplies; ++i) mm.run();
        } else {
            try {
                Thread[] threads = new Thread[numThreads];
                for(int i=0; i<numThreads; ++i) {
                    threads[i] = new Thread(new MatrixMultiply());
                    threads[i].start();
                }
                for(int i=0; i<numThreads; ++i) {
                    threads[i].join();
                }
            } catch (InterruptedException e) {
                System.err.println("Abort: " + e);
            }
        }
    }
}
