package fractal;

import complex.Complex;

public class Mandelbrot {
    public final static int MAX_COLOR = 255;

    public Mandelbrot(int width, int height, int icount, double zoom, 
                      double xOffset, double yOffset, int threads) {
        this.width   = width;
        this.height  = height;
        this.ratio   = (double) height / (double) width;
        this.icount  = icount;
        this.zoom    = 1 / zoom;  // 0.40;  //  0.40;  //  1000
        this.xOffset = xOffset;   // -0.50; // -0.50;  // -1.786
        this.yOffset = yOffset;   // 0.00;  //  0.00;  //  0.000
        this.colors  = new int[width][height];
        this.fivepercent = height / 20;
        this.nextY   = 0;
        calculateImageViaPool(threads);
    }

    // synchronized ensures only 1 thread accesses nextY at a time
    private synchronized int nextRow() {
        return nextY++;
    }
    public void calculateImageViaPool (int numThreads) {
        long startTime = System.nanoTime();
        Thread[] threads = new Thread[numThreads];
        for(int i=0; i<numThreads; ++i) {
            Runnable runnable = new Runnable() {
                public void run() {
                    while(true) {
                        int row = nextRow();
                        if(row >= height) break;
                        if((row % fivepercent) == 0) { // Update progress  bar
                            int percent = (int) (100.0 * row / height);
                            System.out.print("\r[" + "=".repeat(percent / 5) +
                                " ".repeat(20 - (percent / 5)) + "]");
                        }
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
        long endTime = System.nanoTime();
        milliseconds = (endTime - startTime) / 1_000_000;
    }
    
    public void calculateImage () { // Unused
        for(int y=0; y<height; ++y) calculateRow(y);
    }
    protected void calculateRow   (int y) {
        for(int x=0; x<width; ++x) calculatePoint(x, y);
    }
    protected void calculatePoint (int x, int y) {
        Complex point = new Complex(
            (((double) x / (double) width)  - 0.5) * zoom  + xOffset, 
            (((double) y / (double) height) - 0.5) * zoom * ratio + yOffset);
        Complex z = new Complex();
        int iterations = 0;
        while(z.abs() < 2.0 && iterations++ <= icount) 
            z = z.times(z).plus(point);
        colors[x][y] = (iterations < icount) ? (MAX_COLOR*iterations)/icount 
                                             : 0;
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
    
    public long getMilliseconds() {
        return milliseconds;
    }
    
    private int width;    // image x size (adjust for runtime)
    private int height;   // image y size (adjust for runtime)
    private int icount;   // iteration count
    
    private int nextY;       // used by thread pool
    private int fivepercent; // 5% of height
    
    private double zoom;  // how large to make the image 
    private double ratio; // handle non-square images
    private double xOffset; // scroll image left to right
    private double yOffset; // scroll image up to down 
    
    private int[][] colors;   // array containing color values at y*width+x
    
    private long milliseconds; // time spent generating this fractal
}

