/*
 Class Grid - Models a 2D grid.

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

public class Grid {
    public Grid(int numRobots) {
        player = new Robot(new Coordinate(Coordinate.maxX/2, 
                                          Coordinate.maxY/2));
    }
    public void movePlayer(Direction direction) {
        player.move(direction);
    }
    @Override
    public String toString() {
        String s = "\n\r";
        for(int y=0; y<Coordinate.maxY; ++y) {
            for(int x=0; x<Coordinate.maxX; ++x) {
                char icon = '.';
                Coordinate here = new Coordinate(x,y);
                if (player.getCoordinate().equals(here)) 
                    icon = 'R';
                s += icon;                
             }
             s += "\n\r";  // support stty raw mode
        }
        return s;
    }
    private Robot player;
}

