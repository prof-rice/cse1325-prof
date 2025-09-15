/*
 Class TestDirection - Regression test for the Direction class

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
 
public class TestDirection {
    public static void main(String[] args) {
        int vector = 1;
        int result = 0;
        
        if(Direction.UP.deltaX !=  0 || Direction.UP.deltaY != -1) {
            result |= vector;
            System.err.println("ERROR: Invalid values for Direction.UP: "
                + Direction.UP.deltaX + " and "
                + Direction.UP.deltaY);
        }
        vector <<= 1;
        if(Direction.UP_RIGHT.deltaX !=  1 || Direction.UP_RIGHT.deltaY != -1) {
            result |= vector;
            System.err.println("ERROR: Invalid values for Direction.UP_RIGHT: "
                + Direction.UP_RIGHT.deltaX + " and "
                + Direction.UP_RIGHT.deltaY);
        }
        vector <<= 1;
        if(Direction.RIGHT.deltaX !=  1 || Direction.RIGHT.deltaY !=  0) {
            result |= vector;
            System.err.println("ERROR: Invalid values for Direction.RIGHT: "
                + Direction.RIGHT.deltaX + " and "
                + Direction.RIGHT.deltaY);
        }
        vector <<= 1;
        if(Direction.DOWN_RIGHT.deltaX !=  1 || Direction.DOWN_RIGHT.deltaY !=  1) {
            result |= vector;
            System.err.println("ERROR: Invalid values for Direction.DOWN_RIGHT: "
                + Direction.DOWN_RIGHT.deltaX + " and "
                + Direction.DOWN_RIGHT.deltaY);
        }
        vector <<= 1;
        if(Direction.DOWN.deltaX !=  0 || Direction.DOWN.deltaY !=  1) {
            result |= vector;
            System.err.println("ERROR: Invalid values for Direction.DOWN: "
                + Direction.DOWN.deltaX + " and "
                + Direction.DOWN.deltaY);
        }
        vector <<= 1;
        if(Direction.DOWN_LEFT.deltaX != -1 || Direction.DOWN_LEFT.deltaY !=  1) {
            result |= vector;
            System.err.println("ERROR: Invalid values for Direction.DOWN_LEFT: "
                + Direction.DOWN_LEFT.deltaX + " and "
                + Direction.DOWN_LEFT.deltaY);
        }
        vector <<= 1;
        if(Direction.LEFT.deltaX != -1 || Direction.LEFT.deltaY !=  0) {
            result |= vector;
            System.err.println("ERROR: Invalid values for Direction.LEFT: "
                + Direction.LEFT.deltaX + " and "
                + Direction.LEFT.deltaY);
        }
        vector <<= 1;
        if(Direction.UP_LEFT.deltaX != -1 || Direction.UP_LEFT.deltaY != -1) {
            result |= vector;
            System.err.println("ERROR: Invalid values for Direction.UP_LEFT: "
                + Direction.UP_LEFT.deltaX + " and "
                + Direction.UP_LEFT.deltaY);
        }
        vector <<= 1;
        if(Direction.STAY.deltaX !=  0 || Direction.STAY.deltaY !=  0) {
            result |= vector;
            System.err.println("ERROR: Invalid values for Direction.STAY: "
                + Direction.STAY.deltaX + " and "
                + Direction.STAY.deltaY);
        }
        vector <<= 1;
        
        if(result != 0) {
            System.err.println("\nFAIL: error code " + result);
        }
        System.exit(result);
    }
}
