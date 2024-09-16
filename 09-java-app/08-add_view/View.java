/*
 Class View - Display output.

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

public class View {
    public View(Grid grid) {this.grid = grid;} // think pointer to grid
    public void printBanner() {
        System.out.println("============\n\rROVING ROBOT\n\r============\n\n\r");
    }
    public void printGrid() {
        System.out.println(grid);
    }

    private Grid grid;
}
