import java.util.Arrays;

public class ImplementsMax {
    public static <T extends Comparable<T>> T max(T lhs, T rhs) {
        if (lhs.compareTo(rhs) > 0) return lhs; else return rhs;
    }

    public static void main(String[] args) {
        Coordinate c = new Coordinate(3, 4, 5);
        for(int x = 3; x < 7; x += 2) {
          for(int y = 3; y < 5; y += 1) {
            for(int z = 3; z < 7; z += 2) {
                Coordinate c2 = new Coordinate(x, y , z);
                System.out.println("Of " + c + " and " + c2 + ", max is " + max(c, c2));
            }
          }
        }
    }
}

