public class AreaAssert {
    // calculate area of a rectangle
    public static int area(int length, int width) {  
        // length and width must be positive
        assert length > 0 && width > 0 : "Invalid length or width!";
        return length*width;
    }
    public static void main(String[] args) {
        if(args.length > 0 && args[0].equals("--log")) qlogger.Qlogger.enabled = true;
        int length =  14;
        int width  = -10;

        System.out.println("Area of " + length + " x " + width + " is " 
            + area(length, width));
    }   
}

