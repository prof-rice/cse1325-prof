/*
 Class Grid - Models a 2D grid.

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

public class Grid {
    public Grid(int numRobots) {
        player = new Robot("Ralph", new Coordinate(Coordinate.maxX/2, Coordinate.maxY/2));
        robots = new Robot[numRobots];
        for(int i=0; i<numRobots; ++i) robots[i] = new Robot();
    }
    public void movePlayer(Direction direction) {
        player.move(direction);
    }
    public void teleportPlayer() {
        player = new Robot(player.id(), new Coordinate());
    }
    public void animateRobots() {
        for (Robot robot : robots) {
        if (robot.isAlive()) {
            int deltaX =  robot.coordinate().x() -
                         player.coordinate().x();
            int deltaY =  robot.coordinate().y() -
                         player.coordinate().y();
            robot.move(new Direction(deltaX < 0 ? 1 : (deltaX > 0 ? -1 : 0), 
                                     deltaY < 0 ? 1 : (deltaY > 0 ? -1 : 0)));
    }
  }
    }
    public String toString() {
        String s = "\n\r";
        for(int y=0; y<=Coordinate.maxY; ++y) {
            for(int x=0; x<=Coordinate.maxX; ++x) {
                char icon = '.';
                Coordinate here = new Coordinate(x,y);
                for(Robot r : robots) if(r.coordinate().equals(here)) 
                    icon = r.isAlive() ? 'X' : '*';
                if (player.coordinate().equals(here)) 
                    icon = player.isAlive() ? 'R' : '#';
                s += icon;                
             }
             s += "\n\r";  // support stty raw mode
        }
        return s;
    }
    public void detectCollisions() {
        for(Robot r : robots) {
            if(r.coordinate().equals(player.coordinate())) {
                r.kill();
                player.kill();
            }
            for(Robot r2 : robots) {
                if (r == r2) continue;
                if (r.coordinate().equals(r2.coordinate())) {
                    r.kill();
                    r2.kill();
                }
            }
        }
    }
    public boolean playerIsAlive() {
        return player.isAlive();
    }
    private Robot player;
    private Robot[] robots;
}
