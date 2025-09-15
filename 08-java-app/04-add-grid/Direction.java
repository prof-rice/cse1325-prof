/*
 Class Direction - Models a direction on a 2D grid.

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
public enum Direction {
  UP        ( 0,-1),
  UP_RIGHT  ( 1,-1),
  RIGHT     ( 1, 0),
  DOWN_RIGHT( 1, 1),
  DOWN      ( 0, 1),
  DOWN_LEFT (-1, 1),
  LEFT      (-1, 0),
  UP_LEFT   (-1,-1),
  STAY      ( 0, 0);
  private Direction(int deltaX, int deltaY) {
      this.deltaX = deltaX;
      this.deltaY = deltaY;
  }
  public final int deltaX;
  public final int deltaY;
}
