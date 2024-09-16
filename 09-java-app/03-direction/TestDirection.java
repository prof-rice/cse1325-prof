/*
 Class TestDirection - Tests the Direction Class

 @author      George F. Rice
 @copyright   Copyright 2017-2021
 @version     2.0

 This file is part of Roving Robots.

 Roving Robots is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 Roving Robots is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with Roving Robots.  If not, see <https://www.gnu.org/licenses/>.
*/ 
 
public class TestDirection {
    public static void main(String[] args) {
        int result = 0;
        int testVector = 1;
        String expected;
        String actual;
        
        // /////////////////////
        // Static initialization
    {
        expected = "(-1,-1)  (-1,0)  (-1,1)  (0,-1)  (0,0)  (0,1)  (1,-1)  (1,0)  (1,1)  ";
        actual = "";
        
        for(int x = -1; x <= 1 ; ++x) {
            for(int y = -1; y <= 1; ++y) {
                Direction d = new Direction(x, y);
                actual += d + "  ";
            }
        }

        if (expected.compareTo(actual) != 0) {
            System.err.println("FAIL: Coordinate static initialization");
            System.err.println("  Expected: \"" + expected + '"');
            System.err.println("  Actual:   \"" + actual + '"');
            result |= testVector;  // Set a bit for this failure
        }
        testVector <<= 1;  // Shift left 1 bit, equivalent to *= 2, after each test
    }

        // //////////////
        // Range Checking
        
        // Barely illegal directions
    {
        int[] xs = {-2, 0, 2};
        int[] ys = {-2, 0, 2};
        
        for(int x : xs) { // Test outside smallest and largest x
            for(int y : ys) { // Test outside smallest and largest y
                if(x == 0 && y == 0) continue;  // The one legal direction in the group
                try {
                    Direction d = new Direction(x, y); // Should throw exception!
                    System.err.println("FAIL: Range detection");
                    System.err.println("  Expected: exception");
                    System.err.println("  Actual:   \"" + d + '"');
                    result |= testVector;  // Set a bit for this failure
                } catch(IllegalArgumentException e) {
                } catch(Exception e) { // Unexpected exception!
                    System.err.println("FAIL: Unexpected exception");
                    System.err.println("  Expected: IllegalArgumentException");
                    System.err.println("  Actual:   " + e.toString());

                }
            }
        }
      
        testVector <<= 1;  // Shift left 1 bit, equivalent to *= 2, after each test
    }
        
        // ///////////////////////
        // Addition to Coordinates
    {
        // Barely illegal directions
        int[] xs = {1, 0, -1};
        int[] ys = {1, 0, -1};
        
        expected = "(1,1)  (2,1)  (3,0)  (3,1)  (3,1)  (3,0)  (2,1)  (1,1)  (0,0)  ";
        actual = "";

        Coordinate c = new Coordinate(0,0); 
 
        for(int x : xs) { // Test outside smallest and largest x
            for(int y : ys) { // Test outside smallest and largest y
                try {
                    Direction d = new Direction(x,y);
                    c.add(d);
                    actual += c + "  ";
                } catch(Exception e) { // Unexpected exception!
                    System.err.println("FAIL: Unexpected exception");
                    System.err.println("  Expected: Add (" + x + "," + y + ") to " + c);
                    System.err.println("  Actual:   " + e.toString());
                }
            }
        }
        if (expected.compareTo(actual) != 0) {
            System.err.println("FAIL: Addition to Coordinates");
            System.err.println("  Expected: \"" + expected + '"');
            System.err.println("  Actual:   \"" + actual + '"');
            result |= testVector;  // Set a bit for this failure
        }
        testVector <<= 1;  // Shift left 1 bit, equivalent to *= 2, after each test
    }
    
        // Report results
        if(result != 0) System.err.println("\nTest FAILED with error code " + result
            + " (0b" + Integer.toBinaryString(result) + ")");
        System.exit(result);
    }

}
