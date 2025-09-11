public class Animate {
    public static void main(String[] args) {
        StdDraw.setScale(-2.0, +2.0);
        StdDraw.enableDoubleBuffering();

        for (double t = 0.0; true; t += 0.02) {
           double x = Math.sin(t);
           double y = Math.cos(t);
           StdDraw.clear();
           StdDraw.filledCircle(x, y, 0.1);
           StdDraw.filledCircle(-x, -y, 0.1);
           StdDraw.show();
           StdDraw.pause(20);    
        }
    }
}
