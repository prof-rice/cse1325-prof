import java.lang.Math;

class Coordinate implements Comparable<Coordinate> {
    public Coordinate(double x, double y, double z) {
        this.x = x; this.y = y; this.z = z;
    }
    public double magnitude() {return Math.sqrt(x*x + y*y + z*z);}
    @Override
    public int compareTo(Coordinate rhs) {
        return ((Double) magnitude()).compareTo(rhs.magnitude());
    }
    @Override
    public String toString() {return "(" + x + "," + y + "," + z + ")";}
    double x, y, z;
}

