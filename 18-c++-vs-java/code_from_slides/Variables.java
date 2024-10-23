public class Variables {
    public static void main(String[] args) {
        int x = 3;  // primitive - 3 is on the stack
        int y = 4;  // primitive - 4 is on the stack
        Coordinate c = new Coordinate(x, y); 
            // object - address is on the stack
            //   the object itself is on the heap!
        System.out.println(x + " and " + y + " makes " + c);
    }
}
