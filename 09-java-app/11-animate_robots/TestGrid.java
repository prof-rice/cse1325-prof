/*
 Class TestGrid - Tests the Grid Class

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
 
public class TestGrid {
    public static void main(String[] args) {
        int result = 0;
        int testVector = 1;
        String expected;
        String actual;
        
        // /////////////////////
        // Static initialization
        expected =           "\n\r" +
".....X..X....................\n\r" +
"..............X.X...X........\n\r" +
".............................\n\r" +
"..................X........X.\n\r" +
"...X........X................\n\r" +
".............................\n\r" +
".............................\n\r" +
".................X...........\n\r" +
".......................X..X..\n\r" +
".............................\n\r" +
"......X...........X.......X..\n\r" +
".....X.......................\n\r" +
"....X........................\n\r" +
".XXX.........................\n\r" +
"..............R....X.........\n\r" +
"......X......................\n\r" +
".............................\n\r" +
".........................X..X\n\r" +
".............................\n\r" +
"...........................X.\n\r" +
".............................\n\r" +
".............................\n\r" +
".............................\n\r" +
".............................\n\r" +
"....X............X...........\n\r" +
"...................X.X.......\n\r" +
".............................\n\r" +
".............................\n\r" +
"...................X.........\n\r";
        actual = "";

        Grid grid = new Grid(30);
        actual = "" + grid;
        //for(int i=0; i<actual.length(); ++i) System.err.print("" + i + ":" + actual.charAt(i) + " ");

        if (expected.compareTo(actual) != 0) {
            System.err.println("FAIL: Grid static initialization");
            System.err.println("  Expected: \n" + expected + '\n');
            System.err.println("  Actual:   \n" + actual + '\n');
            result |= testVector;  // Set a bit for this failure
            
            System.err.print("String differs at char(s): ");
            for(int i=0; i<expected.length() && i<actual.length(); ++i) {
                if(expected.charAt(i) != actual.charAt(i)) System.err.print(" " + i);
            }
        }
        testVector <<= 1;  // Shift left 1 bit, equivalent to *= 2, after each test

        // Report results
        if(result != 0) System.err.println("\nTest FAILED with error code " + result
            + " (0b" + Integer.toBinaryString(result) + ")");
        System.exit(result);
    }

}
