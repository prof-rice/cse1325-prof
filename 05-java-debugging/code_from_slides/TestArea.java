public class TestArea {
    public static int area(int length, int width) {  
        if (length <= 0 || width <= 0) 
            throw new IllegalArgumentException("Invalid length or width!");
        return length*width;
    }
    // Regression test for method area
    public static void main(String[] args) {
        // TEST #1: Normal Sides (or just use assert!)
        if (area(14, 10) != 140) 
            System.err.println("FAIL: 10x14 not 140 but " + area(14,10));

        // TEST #2: Identical Length Sides
        if (area(10, 10) != 100) 
            System.err.println("FAIL: 10x10 not 100 but " + area(10,10));

        // TEST #3: Zero Length Side
        if (area(0, 10) != 0) System.err.println("FAIL: 0x10 not 0 but " + area(0,10));

        // TEST #4: Negative Length Side
        try {
            int i = area(-1, -2);
            System.err.println("FAIL: Negative side not exception but " + area(-1, -2));
        } catch (Exception e) { // discard the expected exception
        }
    }
}

