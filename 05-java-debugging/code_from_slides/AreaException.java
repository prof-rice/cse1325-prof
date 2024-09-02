public class AreaException {
    // calculate area of a rectangle
    public static int area(int length, int width) {  
        // length and width must be positive
        if (length <= 0 || width <= 0) 
            throw new IllegalArgumentException("Invalid length or width!");
        return length*width;
    }
    public static void main(String[] args) {
        int length =  14;
        int width  = -10;

        try {
            System.out.println("Area of " + length + " x " + width + " is " 
                + area(length, width));
        } catch(Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }   
}

