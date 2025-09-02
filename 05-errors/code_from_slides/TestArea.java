public class TestArea {
    public static void main(String[] args) {
        // TEST VECTOR #1: Normal Sides (or just use assert!)
        if (Area.area(14, 10) != 140) 
            System.err.println("FAIL: 10x14 not 140 but " + Area.area(14,10));

        // TEST VECTOR #2: Identical Length Sides
        if (Area.area(10, 10) != 100) 
            System.err.println("FAIL: 10x10 not 100 but " + Area.area(10,10));

        // TEST VECTOR #3: Zero Length Side
        if (Area.area(0, 10) != 0) System.err.println("FAIL: 0x10 not 0 but " + Area.area(0,10));

        // TEST VECTOR #4: Negative Length Side
        try {
            int i = Area.area(-1, -2);
            System.err.println("FAIL: Negative side did not throw exception but returned " + i);
        } catch (Exception e) { // discard the expected exception
        }
    }
}

