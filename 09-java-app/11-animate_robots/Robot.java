/*
 Class Robot - Models anything that moves on the grid.

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



public class Robot {
    public Robot(String id, Coordinate coordinate) {
        this.id = id;
        this.coordinate = coordinate;
        this.alive = true;
    }
    Robot() {
        this(generate_id(), new Coordinate());
    }
    public String id() {return id;}
    public Coordinate coordinate() {return coordinate;}
    
    public void move(Direction direction) {
        coordinate.add(direction);
    }
    public void kill() {
        alive = false;
    }
    public boolean isAlive() {
        return alive;
    }
    
    private static int next_id;
    private static String generate_id() {
        return "Robot" + ++next_id;
    }
    
    public String toString() {
        return id + " " + coordinate;
    }
    
    protected String id;
    protected Coordinate coordinate;
    private boolean alive;
}

