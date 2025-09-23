import java.util.Scanner;
import java.util.Random;
public class TestPolygon {
    public static void main(String[] args) {
        final int UNEXPECTED_EXCEPTION_VECTOR = 0x80;
        int result = 0;
        int vector = 1;
        Polygon p;
        
        try {
            // Test 1 - normal case
            try {
                p = new Polygon();
                p.addPoint(new Point());
                p.addPoint(new Point(3.0, 0.0));
                p.addPoint(new Point(3.0, 4.0));
                if((p.perimeter() - 12.0) > 0.000001) {
                    System.err.println("FAIL: Perimeter should be 12.0, not " + p.perimeter());
                    result |= vector;
                }
            } catch(Exception e) {
                System.err.println("FAIL: Exception from valid polygon");
                result |= vector;
            }
            vector <<= 1;
            
            // Test 2 - duplicate point
            try {
                p = new Polygon();
                p.addPoint(new Point());
                p.addPoint(new Point(3.0, 0.0));
                p.addPoint(new Point(0.0, 0.0));
                System.err.println("FAIL: Duplicate point should throw IllegalArgumentException");
                result |= vector;
            } catch(IllegalArgumentException e) { // expected
                if(e.getClass() != IllegalArgumentException.class) throw e;
            }
            vector <<= 1;

            // Test 3 - too few points
            try {
                p = new Polygon();
                p.addPoint(new Point(0.0, 0.0));
                p.addPoint(new Point(3.0, 0.0));
                double perimeter = p.perimeter();
                System.err.println("FAIL: Too few points should throw RuntimeException");
                result |= vector;
            } catch(RuntimeException e) { // expected
                if(e.getClass() != RuntimeException.class) throw e;
            }

            // Test 4 - too many points
            try {
                p = new Polygon();
                for(int i = 0; i < Polygon.MAX_SIDES+1; ++i) 
                    p.addPoint(new Point(rand.nextDouble(), rand.nextDouble()));
                System.err.println("FAIL: Too many points should throw RuntimeException");
                result |= vector;
            } catch(RuntimeException e) { // expected
                if(e.getClass() != RuntimeException.class) throw e;
            }

        } catch(Exception e) {
            System.err.println("FAIL: Unexpected exception");
            result |= UNEXPECTED_EXCEPTION_VECTOR;
            e.printStackTrace();
        }
        
        if(result != 0) {
            System.err.println("FAIL: Result code " + result);
            System.exit(result);
        }
    }
    private static Scanner in = new Scanner(System.in);
    private static Random rand = new Random();
}
