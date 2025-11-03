import java.util.Arrays;

class WithInteger implements Comparable<Integer> {
    public WithInteger(int value) {
        this.value = value;
    }
    @Override
    public int compareTo(Integer rhs) {
        return value - rhs;
    }
    private int value;
}

class WithString implements Comparable<String> {
    public WithString(Integer value) {
        this.value = value;
    }
    @Override
    public int compareTo(String rhs) {
        return value - Integer.parseInt(rhs);
    }
    private Integer value;
}



public class ImplementsComparable {
    public static void main(String[] args) {
        WithInteger wi = new WithInteger(2);
        for(int i=0; i<5; ++i) 
            System.out.println("For " + i + ", compareTo = " + wi.compareTo(i));
            
        WithString ws = new WithString(2);
        for(String s : Arrays.asList("1", "2", "3")) 
            System.out.println("For \"" + s + "\", compareTo = " + ws.compareTo(s));
            
        Coordinate c = new Coordinate(3, 4, 5);
        for(int x = 3; x < 7; x += 2) {
          for(int y = 3; y < 5; y += 1) {
            for(int z = 3; z < 7; z += 2) {
                Coordinate c2 = new Coordinate(x, y , z);
                System.out.println("For \"" + c2 + "\", compareTo = " + c.compareTo(c2));
            }
          }
        }
    }
}

