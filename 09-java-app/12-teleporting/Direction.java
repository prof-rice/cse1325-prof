/*
 Class Direction - Models a direction on a 2D grid.

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

public class Direction extends Coordinate {

    static final Direction left       = new Direction(-1, 0);
    static final Direction up_left    = new Direction(-1,-1);
    static final Direction up         = new Direction( 0,-1);
    static final Direction up_right   = new Direction( 1,-1);
    static final Direction right      = new Direction( 1, 0);
    static final Direction down_right = new Direction( 1, 1);
    static final Direction down       = new Direction( 0, 1);
    static final Direction down_left  = new Direction(-1, 1);
    static final Direction stay       = new Direction( 0, 0);
        
    public Direction(int x, int y) {
        super(x, y);
    }
    @Override
    protected void validate() {
        if(x < -1 || x > 1) throw new IllegalArgumentException("Invalid x direction: " + x);
        if(y < -1 || y > 1) throw new IllegalArgumentException("Invalid y direction: " + y);
    }
}

