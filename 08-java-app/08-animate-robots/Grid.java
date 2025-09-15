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
        // Create the player robot
        Coordinate center = new Coordinate(Coordinate.maxX/2, 
                                           Coordinate.maxY/2);
        player = new Robot(center);
        
        // Create enemy robots, avoiding the player position
        robots = new Robot[numRobots];
        Robot r;
        for(int i=0; i<numRobots; ++i) {
            do {
                r = new Robot(new Coordinate());
            } while(center.equals(r.getCoordinate()));
            robots[i] = r;
        }
    }
    public void movePlayer(Direction direction) {
        player.move(direction);
    }
    public void animateRobots() {
        for (Robot robot : robots) {
            if (robot.isAlive()) 
                robot.move(robot.getCoordinate().directionTo(
                          player.getCoordinate()));
        }
    }
    public void detectCollisions() {
        Coordinate playerCoordinate = player.getCoordinate();
        for(Robot r : robots) {
            Coordinate robotCoordinate = r.getCoordinate();
            if(playerCoordinate.equals(robotCoordinate)) {
                r.kill();
                player.kill();
            }
            for(Robot r2 : robots) {
                if (r == r2) continue;
                if (robotCoordinate.equals(r2.getCoordinate())) {
                    r.kill();
                    r2.kill();
                }
            }
        }
    }
    public boolean playerIsAlive() {
        return player.isAlive();
    }
    public boolean anyRobotIsAlive() {
        for(Robot r : robots) if(r.isAlive()) return true;
        return false;
    }
    @Override
    public String toString() {
        String s = "\n\r";
        for(int y=0; y<=Coordinate.maxY; ++y) {
            for(int x=0; x<=Coordinate.maxX; ++x) {
                char icon = '.';
                Coordinate here = new Coordinate(x,y);
                for(Robot r : robots) 
                    if(here.equals(r.getCoordinate())) 
                        icon = r.isAlive() ? 'X' : '*';
                if (player.getCoordinate().equals(here)) 
                        icon = player.isAlive() ? 'R' : '#';
                s += icon;                
             }
             s += "\n\r";  // support stty raw mode
        }
        return s;
    }
    private Robot player;
    private Robot[] robots;
}

