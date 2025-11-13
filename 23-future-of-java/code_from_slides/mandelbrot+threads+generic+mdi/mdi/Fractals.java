package mdi;

import menu.Menu;
import menu.MenuItem;

import fractal.Mandelbrot;

import java.io.File;
import java.io.PrintStream;

import java.util.Scanner;

public class Fractals {

    // ////////// MENU //////////
    private static final String clearScreen = "\n".repeat(80);
    private static final String title = "Fractals\n========\n\n";
    
    public Fractals() {
        newz();
        menu = new Menu(new Object[]{clearScreen, title},
                        new Object[]{this, "\nSelection?"},
                        new MenuItem("Exit\n",             this::exit),
                        new MenuItem("Generate Fractal\n", this::showFractal),
                        new MenuItem("Change size",        this::changeSize),
                        new MenuItem("Change icount",      this::changeICount),
                        new MenuItem("Change zoom",        this::changeZoom),
                        new MenuItem("Change xOffset",     this::changeXOffset),
                        new MenuItem("Change yOffset",     this::changeYOffset),
                        new MenuItem("Change threads\n",   this::changeThreads),
                        new MenuItem("New",                this::newz),
                        new MenuItem("Save",               this::save),
                        new MenuItem("Save as",            this::saveAs),
                        new MenuItem("Open\n",             this::open),
                        new MenuItem("Set ppm file",       this::setPPMFile),
                        new MenuItem("Set Viewer",         this::setViewer)
        );
        menu.run();
    }
    @Override
    public String toString() {
        return "\nsize:     " + size +
               "\nicount:   " + icount +
               "\nzoom;     " + zoom +
               "\nxOffset:  " + xOffset +
               "\nyOffset:  " + yOffset +
               "\nthreads:  " + threads + '\n' +
               "\nfilename: " + file +
               "\nppm file: " + ppmFile +
               "\nviewer:   " + viewer +
               "\n";
    }

    // ///////// OBSERVERS /////////
    private void exit() {
        menu.result = null;
    }
    private void showFractal() {
        System.out.println("Generating " + ppmFile);
        Mandelbrot m = null;
        try {
            m = new Mandelbrot(size, size, icount, zoom,
                               xOffset, yOffset, threads);
        } catch (Exception e) {
            menu.result.append("\nFAIL: Unable to generate Mandelbrot\n" + e);
            e.printStackTrace();
            return;
        }
        
        double genTime = m.getMilliseconds() / 1000.0;
        menu.result.append("\nGenerating fractal required " + genTime + " seconds");
        menu.result.append("\n\n" + genHistory + "\n");
        genHistory.add(genTime);
         
        try(PrintStream out = new PrintStream(ppmFile)) {
            out.println(m);
        } catch(Exception e) {
            menu.result.append("\nFAIL: Unable to write " + ppmFile + "\n" + e);
            e.printStackTrace();
            return;
        }
        String cmd = null;
        try {
            cmd = viewer + " " + ppmFile.getName();
            Process process = Runtime.getRuntime().exec(cmd);
            menu.result.append("\nLaunched '" + cmd + 
                               "' as " + process);
        } catch(Exception e) {
            menu.result.append("\nFAIL: Unable to display fractal with '" + 
                               cmd + "'");
            e.printStackTrace();
            return;
        }
    }
    private void changeSize() {
        Integer i = menu.getInt("\n\n" + sizeHistory + 
                                "\nEnter new size: ");
        if(i != null) {
            menu.result.append("\nChanged size from " + size + " to " + i);
            sizeHistory.add(size);
            size = i;
        }
    }
    private void changeICount() {
        Integer i = menu.getInt("\n\n" + icountHistory + 
                                "\nEnter new icount: ");
        if(i != null) {
            menu.result.append("\nChanged icount from " + icount + " to " + i);
            icountHistory.add(icount);
            icount = i;
        }
    }
    private void changeZoom() {
        Double d = menu.getDouble("\n\n" + zoomHistory + 
                                  "\nEnter new zoom: ");
        if(d != null) {
            menu.result.append("\nChanged zoom from " + zoom + " to " + d);
            zoomHistory.add(zoom);
            zoom = d;
        }
    }
    private void changeXOffset() {
        Double d = menu.getDouble("\n\n" + xOffsetHistory + 
                                  "\nEnter new xOffset: ");
        if(d != null) {
            menu.result.append("\nChanged xOffset from " + xOffset + " to " + d);
            xOffsetHistory.add(xOffset);
            xOffset = d;
        }
    }
    private void changeYOffset() {
        Double d = menu.getDouble("\n\n" + yOffsetHistory + 
                                  "\nEnter new yOffset: ");
        if(d != null) {
            menu.result.append("\nChanged yOffset from " + yOffset + " to " + d);
            yOffsetHistory.add(yOffset);
            yOffset = d;
        }
    }
    private void changeThreads() {
        Integer i = menu.getInt("\n\n" + threadsHistory + 
                                "\nEnter new number of threads: ");
        if(i != null) {
            menu.result.append("\nChanged threads from " + threads + " to " + i);
            threadsHistory.add(threads);
            threads = i;
        }
    }
    
    private void newz() {
        size = 1000;
        icount = 255;
        zoom = 0.5;
        xOffset = 0.0;
        yOffset = 0.0;
        threads = 1;
    }
    
    private void save() {
        if(file == null)
            file = Menu.selectFile("Save to file: ", null, null);
        if(file != null) {
            try(PrintStream out = new PrintStream(file)) {
                out.println(size);
                out.println(icount);
                out.println(zoom);
                out.println(xOffset);
                out.println(yOffset);
                out.println(threads);
                menu.result.append("\nSaved to file " + file);
            } catch(Exception e) {
                menu.result.append("\nFAIL: Unable to write to " + file);
                e.printStackTrace();
                return;
            }
        }
    }
    
    private void saveAs() {
        file = null;
        save();
    }
    
    private void open() {
        file = Menu.selectFile("Open file: ", null, null);
        if(file != null) {
            try(Scanner in = new Scanner(file)) {
                size = in.nextInt(); in.nextLine();
                icount = in.nextInt(); in.nextLine();
                zoom = in.nextDouble(); in.nextLine();
                xOffset = in.nextDouble(); in.nextLine();
                yOffset = in.nextDouble(); in.nextLine();
                threads = in.nextInt(); in.nextLine();
                menu.result.append("\nOpened file " + file);
            } catch(Exception e) {
                menu.result.append("\nFAIL: Unable to open " + file);
                e.printStackTrace();
                return;
            }
        }
    }
    
    private void setPPMFile() {
        String filename = Menu.getString("Current ppm file is " + ppmFile + "\nNew filename? ");
        if(filename != null && !filename.isEmpty())
            ppmFile = new File(filename);
    }
    private void setViewer() {
        viewer = Menu.getString("Current viewer is " + viewer + "\nNew viewer? ");
    }

    // ///////// MAIN /////////
    public static void main(String[] args) {
        new Fractals();
    }
    
    private Menu menu; 
    
    private int size;       // image x and y size (adjust for runtime)
    private int icount;     // iteration count
    private double zoom;    // how large to make the image 
    private double xOffset; // scroll image left to right
    private double yOffset; // scroll image up to down 
    private int threads;    // Number of threads to use when generating
    
    private static File file;
    private static File ppmFile = new File("mandelbrot.ppm");
    private static String viewer = "eog";

    private static final int HISTORY_SIZE = 20;
    private History<Integer> sizeHistory    = new History<>(HISTORY_SIZE);
    private History<Integer> icountHistory  = new History<>(HISTORY_SIZE);
    private History<Double>  zoomHistory    = new History<>(HISTORY_SIZE);
    private History<Double>  xOffsetHistory = new History<>(HISTORY_SIZE);
    private History<Double>  yOffsetHistory = new History<>(HISTORY_SIZE);
    private History<Integer> threadsHistory = new History<>(HISTORY_SIZE);
    
    private History<Double>  genHistory     = new History<>(HISTORY_SIZE);
}
