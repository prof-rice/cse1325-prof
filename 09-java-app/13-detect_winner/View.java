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
    private void clearScreen() {
        for(int i=0; i<80; ++i) System.out.println('\r'); // clear screen
    }
    private void printBanner() {
        System.out.println("============\n\rROVING ROBOT\n\r============\n\n\r");
    }
    public void printGrid() {
        clearScreen();
        printBanner();
        System.out.println(grid);
    }
    public void printFinalGrid() {
        clearScreen();
        if(grid.playerIsAlive()) printTrophy(); else printExplosion();
        System.out.println(grid);
    }
    private void printExplosion() {
        System.out.print(
            "     _.-^^---....,,--             \n\r" +
            " _--                  --_         \n\r" +
            "<                        >)       \n\r" +
            "|                         |       \n\r" +
            "\\._                   _./         \n\r" +
            "   ```--. . , ; .--'''            \n\r" +
            "         | |   |                  \n\r" +
            "      .-=||  | |=-.               \n\r" +
            "      `-=#$%&%$#=-'               \n\r" +
            "         | ;  :|                  \n\r" +
            "_____.,-#%&$@%#&#~,._____  unknown\n\r\n\r" +
            "You lose! Good day, sir!\n\r" // With apologies to Willy Wonka
        );
    }
    private void printTrophy() {
        System.out.print(
            "      (_v_)      \n\r" +
            "       _|_       \n\r" +
            "       | |       \n\r" +
            "  |-----+-----|  \n\r" +
            "  |   LONE    |  \n\r" +
            "  | SURVIVOR  |  \n\r" +
            "   '---------'   \n\r" +
            "    \\       /    \n\r" +
            "     '.   .'     \n\r" +
            "       | |       \n\r" +
            "      .' '.      \n\r" +
            "     _|___|      \n\r" +
            "    [#######] apc\n\r\n\r" +
            "So shines a good deed in a weary world...\n\r" // ditto
       );
    }

    private Grid grid;
}
