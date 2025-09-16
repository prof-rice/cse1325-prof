import java.util.Random;
import java.util.Scanner;

public class DrawPolygons {
    private static Scanner scanner = new Scanner(System.in);
    private static Random rand = new Random();
    public static void main(String[] args) {
        if(args.length == 0) {
            System.err.println("usage: java Polygons [#sides...]");
            System.exit(-1);
        }
        Polygon polygon = null;
        StdDraw.setScale(-2.0, +12.0);
        StdDraw.setPenRadius(0.003);
        for(String arg : args) {
            int sides = Integer.parseInt(arg);
            polygon = new Polygon();
            for(int i=0; i<=sides; ++i) 
                polygon.addPoint(new Point(10*Math.random(),10*Math.random()));
            StdDraw.setPenColor(StdDraw.COLORWHEEL[rand.nextInt(StdDraw.COLORWHEEL.length)]);
            polygon.draw();
            System.out.println("Drew " + polygon + " in " + StdDraw.getPenColor());
        }
        scanner.nextLine();
        StdDraw.close();
    }
}
