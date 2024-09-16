/*
 Class Coordinate - Models a location on a 2D grid.

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

import java.util.Random;

public class Coordinate {
    public static final int maxX = 29;
    public static final int maxY = 29;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        validate();
    }
    public Coordinate() {
        
        this(rand.nextInt(maxX), rand.nextInt(maxY));
    }
    public int x() {return this.x;}
    public int y() {return this.y;}
    
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    
    public void add(Coordinate rhs) {
        x += rhs.x;
        y += rhs.y;
        validate();
    }
    
    protected void validate() {
        if(x < 0 || x > maxX) throw new IllegalArgumentException("Invalid x: " + x);
        if(y < 0 || y > maxY) throw new IllegalArgumentException("Invalid y: " + y);
    }
        
    protected int x;
    protected int y;

    protected static Random rand = new Random(0XC0FFEE);
}

