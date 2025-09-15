public class Game {
    public Game() {
        this.grid = new Grid(0);
    }
    public void cli() {
        while(true) {
            char command = '5';
            try {
                printGrid();
                System.out.print("\nCommand: ");
                command = (char)System.in.read();
                executeCommand(command);
            } catch (Exception e) {
                System.err.println("Invalid command: " + command);
            }
        }
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
            case '0'      -> System.exit(0);
            default       -> valid = false;
        }
        return valid;
    }
    public void printGrid() {
        System.out.println(clearScreen + grid);
    }
    private static String clearScreen = String.valueOf('\n').repeat(80);
    private Grid grid;
}
