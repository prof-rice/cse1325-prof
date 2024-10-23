public class Immutables {
    public static Coordinate multiply(Coordinate c, int by) {
        c.multiply(by);
        return c;
    }
    public static void changeTo(Coordinate c, int x, int y) {
        c = new Coordinate(x, y);
    }
    public static void main(String[] args) {
        Coordinate c = new Coordinate(3, 4); 
        System.out.println("Created as " + c);
        multiply(c, 2);
        System.out.println("     x2 is " + c);
        changeTo(c, 4, 3);
        System.out.println("Changed to " + c);
    }
}
