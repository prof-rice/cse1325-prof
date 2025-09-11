/* 
Turtle Graphics are drawn by imagining a turtle with a pen on its tail.

The pen can be raised or lowered on command, and when lowered leaves 
a colored trail behind the turtle as it moves.

The turtle can also be commanded to change the color of the pen on its tail
and to turn left or right by the number of degrees specified.

Surprisingly complex and beautiful artwork can be generated with some
loops containing instructions to the turtle, as we'll see!

---

This implementation relies on a single-file static class named StdDraw.
With a few simple method calls, graphics-capable computers will open
a window and follow the commands. 

Documentation for StdDraw can be generated using Ant with the

ant javadoc

command. Open the file javadoc/index.html to read the documentation.

This class translates between our turtle and StdDraw.

*/

public class Turtle {
    public Turtle(double x, double y, double degrees) {
        penUp();
        teleport(x, y, degrees);
        penDown();
    }
    public Turtle() {
        this(0, 0, 0);
    }
    
    // Pen control
    public void penUp() {
        penIsDown = false;
    }
    public void penDown() {
        penIsDown = true;
    }
    
    // Movement
    public void turn(double degrees) { // positive degrees is left
        angle += Math.toRadians(degrees);
        angle = Math.atan2(Math.sin(angle), Math.cos(angle)); // normalize
    }
    public void forward(double distance) { // distance is in scaled StdDraw units
        double newX = x + distance*Math.cos(angle);
        double newY = y + distance*Math.sin(angle);
        if(penIsDown) StdDraw.line(x, y, newX, newY);
        x = newX; 
        y = newY;
    }
    public void teleport(double x, double y, double degrees) { // same as goto
        if(penIsDown) StdDraw.line(this.x, this.y, x, y);
        this.x = x;
        this.y = y;
        this.angle = Math.toRadians(degrees);
    }
    
    // Get turtle state
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getDegrees() {
        return Math.toDegrees(angle);
    }
    public boolean penIsDown() {
        return penIsDown;
    }
    
    // Fields
    private double x;          // scaled StdDraw units
    private double y;
    private double angle;      // turtle's facing in radians
    private boolean penIsDown; // draw if true, move otherwise
}

/*

Interested in more sophisticated artwork? Here's a brief summary 
of some additional supporting StdDraw methods.

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

