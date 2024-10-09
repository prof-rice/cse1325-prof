import java.util.Map;     // The interface
import java.util.HashMap; // The implementing classes
import java.util.TreeMap;

import java.util.Objects;

enum Direction {N, S, E, W}
class Degrees {
    public Degrees(double degrees, Direction direction) {
        this.degrees = degrees;
        this.direction = direction;
    }
    public Double getDegrees() {
        return this.degrees;
    }
    @Override
    public String toString() {
        return String.format("%3.4f %s", degrees, direction);
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Degrees that = (Degrees) o;
        return this.degrees == that.degrees
            && this.direction.equals(that.direction);
    }
    @Override
    public int hashCode() {
        return Objects.hash(degrees, direction);
    }

    private Double degrees;
    private Direction direction;
}
class Coordinate implements Comparable<Coordinate> {
    public Coordinate(Degrees latitude, Degrees longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    @Override
    public String toString() {
        return String.format("(%s, %s)", latitude, longitude);
    }
    @Override
    public int compareTo(Coordinate coordinate) {
        int result = latitude.getDegrees().compareTo(coordinate.latitude.getDegrees());
        if(result == 0) result = longitude.getDegrees().compareTo(coordinate.longitude.getDegrees());
        return result;
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return compareTo(that) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
    private Degrees latitude;
    private Degrees longitude;
}

public class TreasureMap {
  public static void main(String[] args) {
    Map<Coordinate, String> unsortedTreasures = new HashMap<>();
    Map<Coordinate, String>   sortedTreasures = new TreeMap<>();
    
    Coordinate c2 = new Coordinate(new Degrees(30.6266, Direction.N), new Degrees(81.4609, Direction.W));
    unsortedTreasures.put(c2, "Treasure of San Miguel");
      sortedTreasures.put(c2, "Treasure of San Miguel");
    
    Coordinate c1 = new Coordinate(new Degrees(5.5282, Direction.N), new Degrees(87.0574, Direction.W));
    unsortedTreasures.put(c1, "Treasure of Lima");
      sortedTreasures.put(c1, "Treasure of Lima");
    
    Coordinate c3 = new Coordinate(new Degrees(60.28889, Direction.S), new Degrees(19.04444, Direction.E));
    unsortedTreasures.put(c3, "Treasure Island");
      sortedTreasures.put(c3, "Treasure Island");
    
    System.out.println("Unsorted treasures: ");
    for(Coordinate key : unsortedTreasures.keySet()) {
        System.out.println("    " + unsortedTreasures.get(key) + " " + key);
    }
    
    System.out.println("Sorted (by latitude) treasures: ");
    for(Coordinate key : sortedTreasures.keySet()) {
        System.out.println("    " + sortedTreasures.get(key) + " " + key);
    }
  }
}
