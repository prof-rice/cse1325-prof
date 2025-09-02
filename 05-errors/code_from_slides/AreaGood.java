public class AreaGood {
    // calculate area of a rectangle
    public static int area(int length, int width) {  
        // length and width must be positive
        if (length <= 0 || width <= 0) {
            System.err.println("Invalid length or width!");
            System.exit(-1);
        }
        return length*width;
    }
    public static void main(String[] args) {
        int length = 14;
        int width  = 10;

        System.out.println("Area of " + length + " x " + width + " is " 
            + area(length, width));
    }   
}

