
import java.util.Random;
import java.util.HashMap;
import java.util.Objects;

class Coordinate {
    public static final int maxX = 29;
    public static final int maxY = 29;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        validate();
    }
    public Coordinate() {
        
        this(rand.nextInt(maxX), rand.nextInt(maxY));
    }
    public int x() {return this.x;}
    public int y() {return this.y;}
    
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    
    public void add(Coordinate rhs) {
        x += rhs.x;
        y += rhs.y;
        validate();
    }
    
    protected void validate() {
        if(x < 0 || x > maxX) throw new IllegalArgumentException("Invalid x: " + x);
        if(y < 0 || y > maxX) throw new IllegalArgumentException("Invalid y: " + y);
    }
        
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false; 
        if(this.getClass() != o.getClass()) return false;
        Coordinate c = (Coordinate) o; // Downcast to a Coordinate
        return (x == c.x) && (y == c.y);
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    protected int x;
    protected int y;

    protected static Random rand = new Random(0XC0FFEE);
}

class HashlessTreasure {
    public HashlessTreasure(Coordinate c, String name, double value) {
        this.coordinate = c;
        this.treasureName = name;
        this.treasureValue = value;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false; 
        if(this.getClass() != o.getClass()) return false;
        HashlessTreasure t = (HashlessTreasure) o; // Downcast to a HashlessTreasure
        return coordinate.equals(t.coordinate)
            && treasureName.equals(t.treasureName)
            && (treasureValue == t.treasureValue);
    }
    protected Coordinate coordinate;  // Our custom class
    protected String treasureName;    // A JCL class
    protected double treasureValue;   // A primitive
}

class Treasure extends HashlessTreasure {
    public Treasure(Coordinate c, String name, double value) {
        super(c, name, value);
    }
    // Add a valid hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(coordinate, treasureName, treasureValue);
    }
}

public class EqualsAndHashCode {
    public static void main(String[] args) {
        HashMap<HashlessTreasure, Integer> map1 = new HashMap<>();
        map1.put(new HashlessTreasure(new Coordinate(23,17), "Blackbeard's", 12835.19), 0);
        map1.put(new HashlessTreasure(new Coordinate(23,17), "Blackbeard's", 12835.19), 1);
        System.out.println("Without hashCode, this should (incorrectly) be 2: " + map1.size());

        HashMap<HashlessTreasure, Integer> map2 = new HashMap<>();
        map2.put(new Treasure(new Coordinate(23,17), "Blackbeard's", 12835.19), 2);
        map2.put(new Treasure(new Coordinate(23,17), "Blackbeard's", 12835.19), 3);
        System.out.println("WITH    hashCode, this should (correctly)   be 1: " + map2.size());
    }
}
