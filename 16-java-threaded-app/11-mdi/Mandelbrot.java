import complex.Complex;

import menu.Menu;
import menu.MenuItem;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class SavedData {
    public boolean dirty   = false;
    public int     icount  =  255;
    public double  zoom    =    1.0;      //  0.001  0.00004   0.00004
    public double  xOffset =    17860.0;  // -1.786 -1.7851   -1.7856
    public double  yOffset =    0.00000;  //  0.0    0.0       0.0
    @Override
    public String toString() {
        return "iCount*    = " + icount                  + '\n'
             + "zoom*      = " + zoom                    + '\n'
             + "position*  = " + xOffset + "x" + yOffset + '\n';
    }
}

    class Data {
        
        public SavedData saved     = new SavedData();
        public int       width     = 1920;
        public int       height    = 1080;
        public int       threads   =   16;
        public String    datafile  = "untitled.mb";
        public String    imagefile = "image.ppm";
        public String    viewer    = "/usr/bin/xviewer";
        @Override
        public String toString() {
            return saved
                 + "dimensions = " + width + "x" + height    + '\n'
                 + "threads    = " + threads                 + '\n'
                 + "image file = " + imagefile               + '\n'
                 + "data file  = " + datafile                + '\n'
                 + "viewer     = " + viewer                  + '\n';
        }
    }


public class Mandelbrot {
    private static Scanner scanner = new Scanner(System.in);
    public static Data data = new Data();
 
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addMenuItem(new MenuItem("i", "Set iCount",          () -> setICount()));
        menu.addMenuItem(new MenuItem("z", "Set zoom",            () -> setZoom()));
        menu.addMenuItem(new MenuItem("p", "Set position",        () -> setPosition()));
        menu.addMenuItem(new MenuItem("d", "Set dimensions",      () -> setDimensions()));
        menu.addMenuItem(new MenuItem("t", "Set threads",         () -> setThreads()));
        menu.addMenuItem(new MenuItem("v", "Set viewer",          () -> setViewer()));
        menu.addMenuItem(new MenuItem("g", "Set image filename",  () -> setImageFilename()));
        menu.addMenuItem(new MenuItem("f", "Set data filename",   () -> setDataFilename()));
        menu.addMenuItem(new MenuItem("r", "Revert settings",     () -> revertSettings()));
        menu.addMenuItem(new MenuItem("s", "Save settings",       () -> saveSettings()));
        menu.addMenuItem(new MenuItem("o", "Open settings",       () -> openSettings()));
        menu.addMenuItem(new MenuItem("m", "Generate Mandelbrot", () -> generateMandelbrot()));
        menu.addMenuItem(new MenuItem("x", "Exit",                () -> exit()));

        String cmd = "";
        
        while(!cmd.equals("x")) {
            System.out.print("\n\nMandelbrot Main Menu\n====================\n\n" 
                + menu + '\n' + data + "\nSelection" + (data.saved.dirty ? "*" : "") + "? ");
            cmd = scanner.next().trim().toLowerCase();
            if(!menu.run(cmd)) System.err.println("\n#### Invalid command!\n");
        }
    }
    
    // Listeners
    private static void setDimensions() {
        data.width    = scanner.nextInt();
        data.height   = scanner.nextInt();
    }
    private static void setICount() {
        data.saved.icount   = scanner.nextInt();
        data.saved.dirty    = true;
    }
    private static void setZoom() {
        data.saved.zoom     = scanner.nextDouble();
        data.saved.dirty    = true;
    }
    private static void setPosition() {
        data.saved.xOffset  = scanner.nextDouble();
        data.saved.yOffset  = scanner.nextDouble();
        data.saved.dirty    = true;
    }
    private static void setThreads() {
        data.threads  = scanner.nextInt();
    }
    private static void setViewer() {
        data.viewer   = scanner.nextLine().trim();
    }
    private static void setImageFilename() {
        data.imagefile = scanner.nextLine().trim();
    }
    private static void setDataFilename() {
        data.datafile  = scanner.nextLine().trim();
    }
    private static void updateFilename() {
        String filename = scanner.nextLine().trim();
        if(!filename.isEmpty()) data.datafile = filename;
    }
    private static void revertSettings() {
        data.saved = new SavedData();
    }
    private static void saveSettings() {
        updateFilename();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(data.datafile))) {
            bw.write("Mandelbrot\n" // magic cookie!
                   + data.saved.icount + '\n'
                   + data.saved.zoom + '\n'
                   + data.saved.xOffset + '\n'
                   + data.saved.yOffset + '\n'
            );
            data.saved.dirty  = false;
        } catch(IOException e) {
            System.err.println("#### Could not write " + data.datafile + ": " + e);
        }
    }
    private static void openSettings() {
        updateFilename();
        try (BufferedReader br = new BufferedReader(new FileReader(data.datafile))) {
            if(!br.readLine().equals("Mandelbrot")) {
                System.err.println(data.datafile + " in not a Mandelbrot file");
            } else {
                data.saved.icount  = Integer.parseInt(br.readLine());
                data.saved.zoom    = Double.parseDouble(br.readLine());
                data.saved.xOffset = Double.parseDouble(br.readLine());
                data.saved.yOffset = Double.parseDouble(br.readLine());
            }
        } catch(IOException e) {
            System.err.println("#### Could not open " + data.datafile + ": " + e);
        }
        data.saved.dirty  = false;
    }
    private static void generateMandelbrot() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(data.imagefile))) {
            long start = System.nanoTime();
            Mandelbrot mandelbrot = new Mandelbrot(data.width,          data.height,
                                                   data.saved.icount,   data.threads,
                                                   data.saved.zoom, 
                                                  -data.saved.xOffset, -data.saved.yOffset);
            long elapsed = System.nanoTime() - start;
            bw.write(mandelbrot.toString());
            System.out.printf("\nElapsed time: %8.3f milliseconds\n\n", 
                              ((double) elapsed / 1000) / 1000.0);
        } catch(IOException e) {
            System.err.println("#### Could not write " + data.imagefile + ": " + e);
        }
        try {
            Process process = Runtime.getRuntime().exec(data.viewer + " " + data.imagefile);
            process.waitFor();
        } catch(IOException e) {
            System.err.println("#### Could not launch viewer " + data.viewer + "\n" + e);
        } catch(InterruptedException e) {
        }
    }
    private static void exit() {
        if(data.saved.dirty) {
            System.out.print("Save settings to " + data.datafile + " (y/N)? ");
            String response = scanner.next().trim();
            if(!response.isEmpty() && response.toLowerCase().charAt(0) == 'y') {
               saveSettings();
            }
        }
    }

    // ======================= Calculate Mandelbrot ======================
    
    public Mandelbrot(int width, int height, int icount, int threads,
                      double zoom, double xOffset, double yOffset) {
        this.width  = width;
        this.height = height;
        this.ratio  = (double) height / (double) width;
        this.icount = icount;
        this.zoom   = 0.001 / zoom;   //  0.001  0.00004   0.00004
        this.xOffset = xOffset / 10_000;       // -1.786 -1.7851   -1.7856
        this.yOffset = yOffset / 10_000;       //  0.0    0.0       0.0
        this.colors = new int[width][height];
        this.mutex = new Object();
        calculateImageViaPool(threads);
    }
    
    // No threads
    public void calculateImage () {
        for(int y=0; y<height; ++y) calculateRow(y);
    }

    // Old school - explicit allocation of threads and Runnable implementation
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

    // Better - thread pool and lambda!
    public void calculateImageViaPool (int numThreads) {
        Thread[] threads = new Thread[numThreads];
        for(int i=0; i<numThreads; ++i) {
            threads[i] = new Thread(() -> calculateRows());
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
    
    // For thread pools only
    private void calculateRows() {
        int row = 0;
        while(true) {
            synchronized(mutex) { // Local scoped synchronization
                row = nextY++;
            }
            // row = nextRow(); // Synchronized method
            if(row >= height) break;
            calculateRow(row);
        }
    }
    
    private synchronized int nextRow() {
        return nextY++;
    } 
    
    // For all approaches
    protected void calculateRow   (int y) {
        for(int x=0; x<width; ++x) calculatePoint(x, y);
    }
    
    // The miracle happens here!
    protected void calculatePoint (int x, int y) {
        Complex point = new Complex((((double) x / (double) width) - 0.5) * zoom  + xOffset, 
                                    (((double) y / (double) height) - 0.5) * zoom * ratio + yOffset);
        Complex z = new Complex();
        int iterations = 0;
        while(z.abs() < 2.0 && iterations++ <= icount) z = z.times(z).plus(point);
        colors[x][y] = (iterations < icount) ? (MAX_COLOR*iterations)/icount : 0;
    }

    // ============================= End Mandelbrot Calculation ============================
    
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
    private Object mutex; // used to synchronize thread pool
    
    private double zoom;  // how large to make the image 
    private double ratio; // handle non-square images
    private double xOffset; // scroll image left to right
    private double yOffset; // scroll image up to down 
    
    private int[][] colors;   // array containing color values at y*width+x
    public final static int MAX_COLOR = 255;
}

