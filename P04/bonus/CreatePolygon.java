import java.util.Scanner;
public class CreatePolygon {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Enter a polygon using x y points (Ctrl-d or Ctrl-x to finish):");
            Polygon p2 = new Polygon();
            while(in.hasNextDouble()) {
                double x = in.nextDouble();
                double y = in.nextDouble();
                Point point = new Point(x,y);
                p2.addPoint(point);
                System.out.println("Added point " + point);
            }
            System.out.println("" + p2 + " has perimeter " + p2.perimeter());
        } catch(Exception e) {
            System.err.println("INVALID: " + e);
        }
    }
}
