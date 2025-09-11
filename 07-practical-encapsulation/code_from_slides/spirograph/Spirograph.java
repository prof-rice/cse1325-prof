/* Summary of some supporting StdDraw methods.

Note that the shapes are centered at (x,y) unless otherwise specified.

enableDoubleBuffering() - draw offscreen for speed, then call show()

setTitle(String title)
setCanvasSize​(int canvasWidth, int canvasHeight)
setScale(double min, double max) / setScale()
save(String filename)
clear([Color backgroundColor])

Color setPenColor​(int red, int green, int blue) / setPenColor(Color color) /
    setPenColor() / nextPenColor() / getPenColor()
double setPenRadius​(double radius) / setPenRadius() / getPenRadius() 

point​(double x, double y)
arc​(double x, double y, double radius, double angle1, double angle2)
[filled]circle​(double x, double y, double radius)
[filled]ellipse​(double x, double y, double semiMajorAxis, double semiMinorAxis)
[filled]Polygon​(double[] x, double[] y)
[filled]Rectangle​(double x, double y, double halfWidth, double halfHeight)
[filled]Square​(double x, double y, double halfLength)

text(double x, double y, String text[, double degrees])
text​Left / textRight(double x, double y, String text)

picture​(double x, double y, String filename
    [, double scaledWidth, double scaledHeight][, double degrees])

*/

public class Spirograph {
    public Spirograph(double innerRingRadius, 
                      double wheelRadius, 
                      double penRadius) {
        this.R = innerRingRadius;
        this.r = wheelRadius;
        this.p = penRadius;
    }
    
    public void draw(double tStart, double tEnd, int count, boolean multicolored) {
        double t = tStart;
        double delta = (tStart - tEnd) / (double) count;
        double x = fx(t);
        double y = fy(t);
        while(count-- > 0) {
            double newX = fx(t);
            double newY = fy(t);
            if(multicolored) StdDraw.nextPenColor();
            StdDraw.line(x, y, newX, newY);
            x = newX;
            y = newY;
            t += delta;
        }
    }
    
    // Spirograph equations courtesy of Linux Gazette, 
    //     https://linuxgazette.net/133/luana.html
    //   t is the angle (radians) through which the wheel 
    // has rotated within the ring

    private double fx(double t) {
        return (double)((R-r)*Math.cos(t)+p*Math.cos((R-r)*t/r));
    }
    
    private double fy(double t) {
        return (double)((R-r)*Math.sin(t)+p*Math.sin((R-r)*t/r));
    }

    private double R; // Inner radius of the ring
    private double r; // Radius of the wheel
    private double p; // Radius of the pen in the wheel
}

