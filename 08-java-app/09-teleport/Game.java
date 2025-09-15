public class Game {
    public Game(int numRobots) {
        this.grid = new Grid(numRobots);
    }
    public void cli() {
        char command = '5';
        while(grid.playerIsAlive() && grid.anyRobotIsAlive()) {
            try {
                printGrid();
                System.out.print("\nCommand: ");
                command = (char)System.in.read();
                if(executeCommand(command))
                    grid.animateRobots();
                grid.detectCollisions();
            } catch (Exception e) {
                System.err.println("Invalid command: " + command);
                e.printStackTrace();
                System.exit(-1);
            }
        }
        printGrid();
        if(grid.anyRobotIsAlive()) printExplosion();
        else if(grid.playerIsAlive()) printTrophy();
    }
    public boolean executeCommand(char command) {
        boolean valid = true;
        switch(command) {
            case '1', 'z' -> grid.movePlayer(Direction.DOWN_LEFT );
            case '2', 'x' -> grid.movePlayer(Direction.DOWN      );
            case '3', 'c' -> grid.movePlayer(Direction.DOWN_RIGHT);
            case '4', 'a' -> grid.movePlayer(Direction.LEFT      );
            case '5', 's' -> grid.movePlayer(Direction.STAY      );
            case '6', 'd' -> grid.movePlayer(Direction.RIGHT     );
            case '7', 'q' -> grid.movePlayer(Direction.UP_LEFT   );
            case '8', 'w' -> grid.movePlayer(Direction.UP        );
            case '9', 'e' -> grid.movePlayer(Direction.UP_RIGHT  );
            case '.', 't' -> grid.teleportPlayer();
            case '0'      -> System.exit(0);
            default       -> valid = false;
        }
        return valid;
    }
    public void printGrid() {
        System.out.println(clearScreen + grid);
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

    private static String clearScreen = String.valueOf('\n').repeat(80);
    private Grid grid;
}
