import complex.Complex;
import java.util.concurrent.locks.ReentrantLock;

public class Mandelbrot {
    public final static int MAX_COLOR = 255;

    public static void main(String[] args) {
        int numThreads = 1;
        if(args.length > 0) numThreads = Integer.parseInt(args[0]);
        Mandelbrot m = new Mandelbrot(numThreads);
        System.out.println(m);
    }
    public Mandelbrot(int width, int height, int icount, int threads) {
        this.width  = width;
        this.height = height;
        this.ratio  = (double) height / (double) width;
        this.icount = icount;
        this.zoom   = 0.00004;   //  0.001  0.00004   0.00004
        this.xOffset = -1.7856;  // -1.786 -1.7851   -1.7856
        this.yOffset = 0;        //  0.0    0.0       0.0
        this.colors = new int[width][height];
        this.mutex = new ReentrantLock();
        calculateImageViaPool(threads);
    }
    public Mandelbrot(int width, int height, int icount) {
        this(width, height, icount, 1);
    }
    public Mandelbrot(int threads) {
        this(3840, 2160, 255, threads);
    }
    public Mandelbrot() {
        this(1000, 1000, 255, 1);
    }
    public void setView(double xOffset, double yOffset, double zoom) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.zoom = zoom;
    }

    public void calculateImageViaPool (int numThreads) {
        Thread[] threads = new Thread[numThreads];
        for(int i=0; i<numThreads; ++i) {
            Runnable runnable = new Runnable() {
                public void run() {
                    int row = 0;
                    while(true) {
                       // mutex ensures only 1 thread accesses nextY at a time
                       // A ReentrantLock allows the same thread to re-lock it
                       //   as long as it has one unlock for every lock.
                       // https://www.netjstech.com/2016/02/difference-between-reentrantlock-and-synchronized-java.html
                       try {
                            mutex.lock();
                            row = nextY++;
                        } finally {
                            mutex.unlock();
                        }
                        if(row >= height) break;
                        calculateRow(row);
                    }
                }
            };
            threads[i] = new Thread(runnable);
            threads[i].start();
        }
        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception");
            }
        }
    }
    
    public void calculateImage (int numThreads) {
        Thread[] threads = new Thread[numThreads];
        int slice = height / numThreads;
        int currentY = 0;
        for(int i=0; i<numThreads; ++i) {
            final int thisY = currentY;
            final int nextY = (i != numThreads-1) ? currentY + slice : height;
            Runnable runnable = new Runnable() {
                final int firstY = thisY;
                final int lastY = nextY - 1;
                public void run() {
                    for(int row = firstY; row <= lastY; row++)
                        calculateRow(row);
                }
            };
            threads[i] = new Thread(runnable);
            threads[i].start();
            currentY = nextY;
        }
        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception");
            }
        }
    }

    public void calculateImage () {
        for(int y=0; y<height; ++y) calculateRow(y);
    }
    protected void calculateRow   (int y) {
        for(int x=0; x<width; ++x) calculatePoint(x, y);
    }
    protected void calculatePoint (int x, int y) {
        Complex point = new Complex((((double) x / (double) width) - 0.5) * zoom  + xOffset, 
                                    (((double) y / (double) height) - 0.5) * zoom * ratio + yOffset);
        Complex z = new Complex();
        int iterations = 0;
        while(z.abs() < 2.0 && iterations++ <= icount) z = z.times(z).plus(point);
        colors[x][y] = (iterations < icount) ? (MAX_COLOR*iterations)/icount : 0;
    }

    @Override
    public String toString() {
        int[] rmasks = {0b11111111, 0b01111111, 0b11111111, 0b01111111};
        int[] gmasks = {0b11111111, 0b01111111, 0b01111111, 0b11111111};
        int[] bmasks = {0b11111111, 0b11111111, 0b01111111, 0b01111111};
        StringBuffer result =
            new StringBuffer("P3\n" + width + ' ' + height 
                              + ' ' + icount + '\n');
        for(int y=0; y<height; ++y) {
            for(int x=0; x<width; ++x) {
                // result.append("" + colors[x][y] + " 0 0\n");
                int c = colors[x][y];
                //if ((x == width/2) || (y == height/2)) c = 255;
                int i = (c >> 6) & 0b00000011;
                if((c & 0b11110000) == 0) c <<= 1;
                result.append(" " + (c & rmasks[i]) 
                            + " " + (c & gmasks[i])
                            + " " + (c & bmasks[i]) + "\n");
            }
        }
        return result.toString();
    }
    
    private int width;    // image x size (adjust for runtime)
    private int height;   // image y size (adjust for runtime)
    private int icount;   // iteration count
    private int nextY;    // used by thread pool
    private ReentrantLock mutex; // used to synchronize thread pool
    
    private double zoom;  // how large to make the image 
    private double ratio; // handle non-square images
    private double xOffset; // scroll image left to right
    private double yOffset; // scroll image up to down 
    
    private int[][] colors;   // array containing color values at y*width+x
}

