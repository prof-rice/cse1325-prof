public class Area {
    public static int area(int length, int width) {  // calculate area of a rectangle
        // length and width must be positive
        if (length < 0 || width < 0) 
            throw new IllegalArgumentException("Bad length " + length + " or width " + width);
        int result = length*width;
        return result;
    }
    public static void main(String[] args) {
        int length = 14;
        int width = 10;

        System.out.println("Area of " + length + " x " + width + " is " 
            + area(length, width));

        length = Integer.MAX_VALUE; // The largest 2's complement in Java
        width = 2;                  // positive integer supported by Java

        System.out.println("Area of " + length + " x " + width + " is " 
            + area(length, width));
    }
   
}

