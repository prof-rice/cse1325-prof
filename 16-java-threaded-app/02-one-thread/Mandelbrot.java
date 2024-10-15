import complex.Complex;

public class Mandelbrot {
    public final static int MAX_COLOR = 255;

    public static void main(String[] args) {
        Mandelbrot m = new Mandelbrot();
        System.out.println(m);
    }
    public Mandelbrot(int width, int height, int icount) {
        this.width  = width;
        this.height = height;
        this.icount = icount;
        this.zoom   = 150;
        this.colors = new int[width][height];
        calculateImage();
    }
    public Mandelbrot() {
        this(1000, 1000, 255);
    }
    public void setZoom(double zoom) {
        this.zoom = zoom;
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
                result.append("" + colors[x][y] + " " + colors[x][y] + " " + colors[x][y] + "\n");
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

