import complex.Complex;

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
        this.icount = icount;
        this.zoom   = 150;
        this.colors = new int[width][height];
        calculateImage(threads);
    }
    public Mandelbrot(int width, int height, int icount) {
        this(width, height, icount, 1);
    }
    public Mandelbrot(int threads) {
        this(4000, 4000, 255, threads);
    }
    public Mandelbrot() {
        this(4000, 4000, 255, 1);
    }
    public void setZoom(double zoom) {
        this.zoom = zoom;
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
    protected void calculateRow (int y) {
        for(int x=0; x<width; ++x) calculatePoint(x, y);
    }
    protected void calculatePoint (int x, int y) {
        Complex point = new Complex(((double) x / (double) width)  - 1.5, 
                                    ((double) y / (double) height) - 0.5);
        Complex z = new Complex();
        int iterations = 0;
        while(z.abs() < 2.0 && iterations++ <= icount) z = z.times(z).plus(point);
        colors[x][y] = (iterations < icount) ? (MAX_COLOR*iterations)/icount : 0;
    }

    // Write a ppm graphics file - white space-separated text tokens 
    // P3 is the magic cookie, followed by the width, height, and largest color
    // Then Red Green Blue triplets for each pixel - left to right, top to bottom
    @Override
    public String toString() {
        StringBuffer result =
            new StringBuffer("P3\n" + width + ' ' + height 
                              + ' ' + icount + '\n');
        for(int y=0; y<height; ++y) {
            for(int x=0; x<width; ++x) {
                result.append("" + colors[x][y] + " 0 0\n");
            }
        }
        return result.toString();
    }
    
    private int width;    // image x size (adjust for runtime)
    private int height;   // image y size (adjust for runtime)
    private int icount;   // iteration count
    
    private double zoom;  // how large to make the image
    
    private int[][] colors;   // array containing color values at y*width+x
}

