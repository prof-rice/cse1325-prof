public class Polygon {
    public static final int MAX_SIDES = 12;
    public void addPoint(Point point) {
        for(int i=0; i<numSides; ++i) {
            if(point.equals(points[i])) {
                throw new IllegalArgumentException("Duplicate point: " + point);
            }
        }
        if(numSides == MAX_SIDES)
            throw new RuntimeException("Polygon is full");
        points[numSides++] = point;
    }
    private static double lineLength(Point p1, Point p2) {
        double x = p1.getX() - p2.getX();
        double y = p1.getY() - p2.getY();
        return Math.sqrt(x*x + y*y);

    }
    public double perimeter() {
        if(numSides < 3) throw new RuntimeException("Polygons required 3+ sides!");
        double perimeter = 0;
        for(int i=1; i<numSides; ++i)
            perimeter += lineLength(points[i-1], points[i]);
        perimeter += lineLength(points[numSides-1], points[0]);
        return perimeter;
    }
    @Override
    public String toString() {
        String s = "Polygon[";
        String sep = "";
        for(int i=0; i<numSides; ++i) {
            s += sep + points[i];
            sep = ",";
        }
        return s + "]";
    }
    private Point[] points = new Point[MAX_SIDES];
    private int numSides = 0;
}
