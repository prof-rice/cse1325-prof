 class Coordinate {
    private int x, y;
    public Coordinate(int x, int y) {this.x = x; this.y = y;}
    @Override public String toString() {return "(" + x + "," + y + ")";}
 }
 public class OutputGeneric {
    // Add generic $print method here
    
    public static <E> void $print(E value) {
        System.out.print(value + " ");
    }
    
    public static void main(String[] args) {
        String[] s = {"one", "two", "three", "four", "five"};
        for(int i=0; i<5; ++i) {
            $print(i);
            $print(s[i]);
            $print(new Coordinate(i*2, i*3));
        }
        System.out.println();
    }
 }


