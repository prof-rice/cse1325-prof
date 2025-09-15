/*
 Class TestRobot - Regression test for the Robot class.

 @author      George F. Rice
 @copyright   Copyright 2017-2025
 @version     3.0

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

public class TestRobot {
    public static void main(String[] args) {
        int result = 0;
        int testVector = 1;
        
        String expected;
        String actual;
        
        // Test non-default constructor
        
        expected = "robot(0,7)robot(0,21)robot(6,7)robot(6,21)" +
                   "robot(18,3)robot(4,12)robot(27,3)";
        actual = "";
        
        for(int x = 0; x < 3; x+=2) {
            for(int y = 1; y < 4; y+=2) {
                actual += new Robot(new Coordinate(x*3, y*7));
            }
        }
        for(int i = 1; i<4; ++i)
            actual += new Robot(new Coordinate());

        if (expected.compareTo(actual) != 0) {
            System.err.println("FAIL: Robot explicit initialization");
            System.err.println("  Expected: \"" + expected + '"');
            System.err.println("  Actual:   \"" + actual + '"');
            result |= testVector;  
        }
        testVector <<= 1;

        // Report results if non-zero
        
        if(result != 0) {
            System.err.println("\nFAIL: TestCoordinate error code " + result);
        }
        System.exit(result);
    }

}
