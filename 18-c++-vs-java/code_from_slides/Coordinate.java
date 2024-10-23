public class Coordinate {
    private int x, y;
    public Coordinate(int x, int y) {this.x = x; this.y = y;}
    public Coordinate() {this(0,0);}
    public void multiply(int by) {this.x *= by; this.y *= by;}
    @Override
    public String toString() {return "(" + x + "," + y + ")";}
}


