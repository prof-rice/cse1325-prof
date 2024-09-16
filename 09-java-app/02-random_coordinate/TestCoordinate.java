/*
 Class Coordinate - Models a location on a 2D grid.

 @author      George F. Rice
 @copyright   Copyright 2017-2019
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
 
public class TestCoordinate {
    public static void main(String[] args) {
        int result = 0;
        int testVector = 1;
        String expected;
        String actual;
        
        // /////////////////////
        // Static initialization
        expected = "(0,0)  (0,3)  (0,6)  (2,0)  (2,3)  (2,6)  (4,0)  (4,3)  (4,6)  ";
        actual = "";
        
        for(int x = 0; x < 3; ++x) {
            for(int y = 0; y < 3; ++y) {
                Coordinate c = new Coordinate(x*2, y*3);
                actual += '(' + Integer.toString(c.x()) + ',' + Integer.toString(c.y()) + ")  ";
            }
        }

        if (expected.compareTo(actual) != 0) {
            System.err.println("FAIL: Coordinate static initialization");
            System.err.println("  Expected: \"" + expected + '"');
            System.err.println("  Actual:   \"" + actual + '"');
            result |= testVector;  // Set a bit for this failure
        }
        testVector <<= 1;  // Shift left 1 bit, equivalent to *= 2, after each test

        // /////////////////////
        // Random initialization
        expected = "(18,3)  (4,12)  (27,3)  (27,19)  (8,0)  (3,13)  (5,0)  (17,24)  (1,13)  ";
        actual = "";
        
        for(int x = 0; x < 3; ++x) {
            for(int y = 0; y < 3; ++y) {
                Coordinate c = new Coordinate();
                actual += '(' + Integer.toString(c.x()) + ',' + Integer.toString(c.y()) + ")  ";
            }
        }

        if (expected.compareTo(actual) != 0) {
            System.err.println("FAIL: Coordinate random initialization");
            System.err.println("  Expected: \"" + expected + '"');
            System.err.println("  Actual:   \"" + actual + '"');
            result |= testVector;  // Set a bit for this failure
        }
        testVector <<= 1;  // Shift left 1 bit, equivalent to *= 2, after each test

        // Report results
        System.exit(result);
    }

}
