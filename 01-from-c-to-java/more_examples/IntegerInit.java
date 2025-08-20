public class IntegerInit {
    public static void main(String[] args) {
        Integer i1 = 42;              // Traditional initialization
        Integer i2 = new Integer(99); // Object-oriented initialization
        Integer i3 = new Integer(i1); // Copy an Integer
        Integer i4 = i2;              // Copy an Integer reference ("pointer")
        System.out.println("" + i1 + i2 + i3 + i4);
        i3 = 3;
        i4 = 4;
        System.out.println("" + i1 + i2 + i3 + i4);
        
        int a = 1;
        int b = 2;
        int c = 3;
        System.out.println("" + a + " " + b + " " + c);
        System.out.println(String.valueOf(a) + " " + Integer.toString(b) + " " + String.format("%d", c));
        System.out.printf("%d %d %d\n", a, b, c);
        
    }
}
