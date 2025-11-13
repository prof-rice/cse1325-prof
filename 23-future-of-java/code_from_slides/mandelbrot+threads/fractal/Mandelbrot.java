package fractal;

import complex.Complex;

import java.util.Set;
import java.util.HashSet;

import java.io.PrintStream;
import java.io.File;

public class Mandelbrot {
    public final static int MAX_COLOR = 255;

    public Mandelbrot(int width, int height, 
                      int icount, double zoom, int threads) {
        this.width   = width;
        this.height  = height;
        this.icount  = icount;
        this.zoom    = zoom;
        this.threads = threads;
        this.colors  = new int[width][height];
        this.nextY   = 0;
        calculateImage();
    }

    // The Mandelbrot calculations - where threads would be useful!
    public void calculateImage () {
        Set<Thread> threadSet = new HashSet<>();
        for(int t=0; t<threads; ++t) {
            final int threadID = t;
            Thread thread = new Thread(() -> worker(threadID));
            thread.start();
            threadSet.add(thread);
        }
        int m = 0;
        for(Thread t : threadSet) {
            try {
                t.join();
            } catch(Exception e) {
                System.err.println("FAIL on join: " + e);
                e.printStackTrace();
            }
        }
    }
    public void worker(int threadID) {
        System.out.println("Starting thread " + threadID);
        while(true) {
            int y = nextY();
            if(y < 0) break;
            calculateRow(y);
        }
        System.out.println("Ending thread " + threadID);
    }
    private synchronized int nextY() {
        return (nextY < height) ? nextY++ : -1;
    }
    protected void calculateRow (int y) {
        for(int x=0; x<width; ++x) calculatePoint(x, y);
    }
    protected void calculatePoint (int x, int y) {
        Complex point = new Complex(((double) x / (double) width)  - 1.5, 
                                    ((double) y / (double) height) - 0.5);
        Complex z = new Complex();
        int iterations = 0;
        while(z.abs() < 2.0 && iterations++ <= icount) 
            z = z.times(z).plus(point);
        // Arrays are thread-safe ONLY if we guarantee each thread writes
        // to unique memory locations, such as this
        colors[x][y] = (iterations < icount) ? (MAX_COLOR*iterations)/icount 
                                             : 0;
    }

    // Write a ppm graphics file - white space-separated text tokens 
    // P3 is the magic cookie, followed by the width, height, and largest color
    // Then Red Green Blue triplets per pixel - left to right, top to bottom
    @Override
    public String toString() {
        StringBuffer result =
            new StringBuffer("P3\n" + width + ' ' + height 
                              + ' ' + icount + '\n');
        for(int y=0; y<height; ++y) {
            for(int x=0; x<width; ++x) {
                result.append("" + colors[x][y] + " " + 
                                   colors[x][y] + " " + 
                                   colors[x][y] + "\n"); // greyscale
            }
        }
        return result.toString();
    }
    
    // Main, just generate a Mandelbrot file
    private static File file = new File("mandelbrot.ppm");
    public static void main(String[] args) {
        if(args.length > 0 && args[0].equals("-h")) {
            System.err.println("usage: java Mandelbrot [threads [size [icount [zoom]]]]");
            System.exit(0);
        }
        
        int threads = (args.length > 0) ? Integer.parseInt(args[0])   :    1;
        int size    = (args.length > 1) ? Integer.parseInt(args[1])   : 1000;
        int icount  = (args.length > 2) ? Integer.parseInt(args[2])   :  255;
        double zoom = (args.length > 3) ? Double.parseDouble(args[3]) :  150;
        System.out.println("Generating " + size + "x" + size + 
                           " image using icount " + icount + 
                           " and zoom " + zoom + 
                           " with " + threads + " threads.");
        Mandelbrot m = null;
        
        try {
            m = new Mandelbrot(size, size, icount, zoom, threads);
        } catch(Exception e) {
            System.err.println("Failed to generate fractal: " + e);
            e.printStackTrace();
            System.exit(-1);
        }
        try (PrintStream out = new PrintStream(file)) {
            out.println(m);
        } catch(Exception e) {
            System.err.println("Failed to write file: " + file);
            e.printStackTrace();
            System.exit(-2);
        }
        System.err.println("Now open image file " + file + 
                           " with your favorite viewer!");
    }

    
    // Fields
    private int threads;  // number of threads to create
    private int width;    // image x size (adjust for runtime)
    private int height;   // image y size (adjust for runtime)
    private int icount;   // iteration count
    
    private double zoom;  // how large to make the image
    
    private int nextY;
    
    private int[][] colors;   // array containing color values at y*width+x
}

