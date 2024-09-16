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
    public enum Header {NORMAL, HELP, FINAL};
    public void setHeader(Header header) {
        this.header = header;
    }

    public View(Grid grid) {
        this.grid = grid;          // think pointer to grid
        this.header = Header.HELP; // start with the help screen
    } 
    private void clearScreen() {
        for(int i=0; i<80; ++i) System.out.println('\r'); // clear screen
    }
    public void printGrid() {
        clearScreen();
        printBanner();
        switch(header) {
            case NORMAL: {break;}
            case HELP:   {printHelp(); break;}
            case FINAL:  {
                if(grid.playerIsAlive()) printTrophy(); 
                else printExplosion();
                break;
            }
            default: throw new IllegalArgumentException();  // In case of new Header value
        }
        System.out.println(grid);
        header = Header.NORMAL;
    }
    
    // //////////////
    // Header options
    private void printBanner() {
        System.out.println("============\n\rROVING ROBOT\n\r============\n\n\r");
    }
    private void printHelp() {
        System.out.print( /* Text Blocks work with Java 17 
        
           """
           Use the numeric keypad to maneuver your robot Ralph (R)
             and avoid the evil robots (X).
           You may take one step in any direction:
                       7  8  9              q  w  e
                                                     ⟍ |⟋                                      ⟍|⟋
                       4--5--6    ?--help   a--s--d
                                                      ⟋|⟍                                     ⟋|⟍
                       1  2  3              z  x  c
                           exit--0  .--teleport
            
            The evil robots will always take one step toward you.
            Collisions destroy those involved, and leave behind
              a lethal debris field (*). Good luck!
            """
            */
            
            "Use the numeric keypad to maneuver your robot Ralph (R)\n\r" +
            "  and avoid the evil robots (X).                       \n\r" +
            "                                                       \n\r" +
            "You may take one step in any direction:                \n\r" +
            "            7  8  9                q  w  e             \n\r" +
            "             \\ | /                  \\ | /              \n\r" +
            "            4--5--6    ?--help     a--s--d             \n\r" +
            "             / | \\                  / | \\              \n\r" +
            "            1  2  3                z  x  c             \n\r" +
            "                 exit--0  .--teleport                  \n\r" +
            "                                                       \n\r" +
            "The evil robots will always take one step toward you.  \n\r" +
            "Collisions destroy those involved, and leave behind    \n\r" +
            "  a lethal debris field (*). Good luck!                \n\r"
           
       );
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
    private Header header;
}
