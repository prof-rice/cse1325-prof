/*
 Class TestRobot - Tests the Coordinate Class

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
 
public class TestRobot {
    public static void main(String[] args) {
        int result = 0;
        int testVector = 1;
        String expected;
        String actual;
        
        // /////////////////////
        // Static initialization
        expected = "Robot00 (0,0)  Robot02 (0,2)  Robot20 (2,0)  Robot22 (2,2)  ";
        actual = "";
        
        for(int x = 0; x < 3; x+=2) {
            for(int y = 0; y < 3; y+=2) {
                Robot r = new Robot("Robot"+x+y, new Coordinate(x,y));
                actual += r + "  ";
            }
        }

        if (expected.compareTo(actual) != 0) {
            System.err.println("FAIL: Robot static initialization");
            System.err.println("  Expected: \"" + expected + '"');
            System.err.println("  Actual:   \"" + actual + '"');
            result |= testVector;  // Set a bit for this failure
        }
        testVector <<= 1;  // Shift left 1 bit, equivalent to *= 2, after each test

        // /////////////////////
        // Random initialization
        expected = "Robot1 (18,3)  Robot2 (4,12)  Robot3 (27,3)  Robot4 (27,19)  ";
        actual = "";
        
        for(int x = 0; x < 3; x+=2) {
            for(int y = 0; y < 3; y+=2) {
                Robot r = new Robot();
                actual += r + "  ";
            }
        }

        if (expected.compareTo(actual) != 0) {
            System.err.println("FAIL: Robot random initialization");
            System.err.println("  Expected: \"" + expected + '"');
            System.err.println("  Actual:   \"" + actual + '"');
            result |= testVector;  // Set a bit for this failure
        }
        testVector <<= 1;  // Shift left 1 bit, equivalent to *= 2, after each test

        // ////////
        // Movement
        
        expected = "Marvin (5,5)  Marvin (2,5)  Marvin (2,3)  Marvin (22,3)  Marvin (25,6)  Marvin (25,8)  Marvin (22,11)  Marvin (24,9)  Marvin (24,9)  Marvin (17,2)  ";
        actual = "";
        
        Robot r = new Robot("Marvin", new Coordinate(5,5));
        actual = r + "  ";
        
        for(int i=0; i<3; ++i) r.move(Direction.left);       // Move "Marvin" left 3 spaces to (2, 5)
        actual += r + "  ";
        for(int i=0; i<2; ++i) r.move(Direction.up);         // Move "Marvin" up 2 spaces to (2, 3)
        actual += r + "  ";
        for(int i=0; i<20; ++i) r.move(Direction.right);     // Move "Marvin" right 20 spaces to (22, 3)
        actual += r + "  ";
        for(int i=0; i<3; ++i) r.move(Direction.down_right); // Move "Marvin" down and right 3 spaces to (25, 6)
        actual += r + "  ";
        for(int i=0; i<2; ++i) r.move(Direction.down);       // Move "Marvin" down 2 spaces to (25, 8)
        actual += r + "  ";
        for(int i=0; i<3; ++i) r.move(Direction.down_left);  // Move "Marvin" down and left 3 spaces to (22,11)
        actual += r + "  ";
        for(int i=0; i<2; ++i) r.move(Direction.up_right);   // Move "Marvin" up and right 2 spaces to (24, 9)
        actual += r + "  ";
        for(int i=0; i<5; ++i) r.move(Direction.stay);       // Leave "Marvin" in the same place 5 spaces at (24, 9)
        actual += r + "  ";
        for(int i=0; i<7; ++i) r.move(Direction.up_left);    // Move "Marvin" up and left 7 spaces to (17, 2)
        actual += r + "  ";

        if (expected.compareTo(actual) != 0) {
            System.err.println("FAIL: Robot movement");
            System.err.println("  Expected: \"" + expected + '"');
            System.err.println("  Actual:   \"" + actual + '"');
            result |= testVector;  // Set a bit for this failure
        }
        testVector <<= 1;  // Shift left 1 bit, equivalent to *= 2, after each test

        // Report results
        if(result != 0) System.err.println("\nTest FAILED with error code " + result
            + " (0b" + Integer.toBinaryString(result) + ")");
        System.exit(result);
    }

}
