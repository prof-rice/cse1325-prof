public class Triple implements Comparable<Triple> {
    private int x;
    private int y;
    private int z;
    public Triple(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Double magnitude() {
        return Math.sqrt(Math.abs((double) (x*x + y*y + z*z)));
    }
    @Override // Comparable
    public int compareTo(Triple t) {
        return magnitude().compareTo(t.magnitude());
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || ! (o instanceof Triple)) return false;
        Triple t = (Triple) o;
        return (x == t.x) && (y == t.y) && (z == t.z);
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y, z);
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }
}

