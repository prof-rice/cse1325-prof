// Example #5: Mine Sweeper Game
//
// Techniques Illustrated
//
// Different in Java:
//   Global constants (called "final static fields" in Java)
//   Functions (called "static methods" in Java)
//   Arrays (two-dimensional)
//   Handling command line arguments (with usage statement)
//   Providing online program documentation
//   Converting text ("String") to a double
//   Splitting a line of text into "words"
//   Reading primitive values from the console (STDIN)
//   Printing to the console (STDOUT)
//
// Similar to C:
//   Initializing local primitives
//   3-term for loops
//   Simple if statements
//   Switch statements (but without the breaks!)
//   Formatted output with printf

public class MineSweeper {
    static int WIDTH;
    static int HEIGHT;
    static int MINES;
    
    static boolean[][] hasMine;
    static int[][] board;
    
    // Board codes
    final static int MINE_UNKNOWN = -1; // board code default (".")
    final static int MINE_MAYBE   = -2; // board code for a possible mine ("?")
    final static int MINE_KNOWN   = -3; // board code for a suspected mine ("X")
    
    public static void clearBoard() {
        for(int y=0; y<HEIGHT; ++y) {
            for(int x=0; x<WIDTH; ++x) {
                hasMine[x][y] = false;
                board[x][y] = MINE_UNKNOWN;
            }
        }    
    }
    public static void placeMines() {
        for(int mine=0; mine<MINES; ++mine) {
            int x = (int) (Math.random() * WIDTH);
            int y = (int) (Math.random() * HEIGHT);
            hasMine[x][y] = true;
        }
    }
    public static boolean updateBoard(int x, int y) { // returns hasMine[x][y]
        if(x<0 || x>=WIDTH || y<0 || y>=HEIGHT) return false;
        int minX = x>0 ? x-1 : x;
        int maxX = x<(WIDTH-1) ? x+1 : x;
        int minY = y>0 ? y-1 : y;
        int maxY = y<(HEIGHT-1) ? y+1 : y;
        int mines = 0;
        for(int xx = minX; xx <= maxX; ++xx)
            for(int yy = minY; yy <= maxY; ++yy)
                if(hasMine[xx][yy]) ++mines;
        board[x][y] = mines;
        return hasMine[x][y];
    }
    public static void markMineOnBoard(int x, int y, int suspect_code) {
         if(x<0 || x>=WIDTH || y<0 || y>=HEIGHT) return;
         board[x][y] = suspect_code;
    }
    public static void printBoard(boolean showAll) {
        System.out.print("    ");
        for(int x=0; x<WIDTH; ++x) System.out.print(x/10);
        
        System.out.print("\n    ");
        for(int x=0; x<WIDTH; ++x) System.out.print(x-(x/10)*10);
        System.out.println();
        
        for(int y=0; y<HEIGHT; ++y) {
            System.out.printf("%3d ", y);
            for(int x=0; x<WIDTH; ++x)
                if(showAll)
                    System.out.print((hasMine[x][y]) ? "X" : ".");
                else 
                    System.out.print(
                      switch (board[x][y]) {
                            case MINE_UNKNOWN -> ".";
                            case MINE_MAYBE   -> "?";
                            case MINE_KNOWN   -> "X";
                            default           -> board[x][y];
                        }
                    );
            System.out.println();
        }
        System.out.println();
    }
    public static boolean boardIsCorrect() {
        for(int y=0; y<HEIGHT; ++y) {
            for(int x=0; x<WIDTH; ++x) {
                if( hasMine[x][y] && board[x][y] == MINE_UNKNOWN) return false;
                if(!hasMine[x][y] && (board[x][y] == MINE_KNOWN ||
                                      board[x][y] == MINE_MAYBE)) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        if(args.length > 0 && args[0].equals("-h")) {
            System.out.println("Java MineSweeper Copyright 2022 by Prof Rice"
                + "\nReleased under the Gnu GPL 3; see https://www.gnu.org/licenses/"
                + "\n\nUsage: java MineSweeper [width] [height] [# mines]");
            System.exit(0);
        }
                
        WIDTH  = (args.length > 0) ? Integer.parseInt(args[0]) : 20;
        HEIGHT = (args.length > 1) ? Integer.parseInt(args[1]) : WIDTH/2;
        MINES  = (args.length > 2) ? Integer.parseInt(args[2]) : WIDTH*HEIGHT/8;

        hasMine = new boolean[WIDTH][HEIGHT];
        board   = new int    [WIDTH][HEIGHT];
        
        clearBoard();
        placeMines();
        
        java.util.Scanner in = new java.util.Scanner(System.in);
        boolean boom = false;
        int command = -1;
        int x = 0;
        int y = 0;
        
        while((command != 0) && !boom && !boardIsCorrect()) {
            printBoard(false);
            System.out.print("\n0 exit"
                           + "\n1 x y - count adjacent mines"
                           + "\n2 x y - to mark possible mine"
                           + "\n3 x y - mark suspected mine: ");
            command = in.nextInt(); if(command == 0) break;
            x = in.nextInt();
            y = in.nextInt();
            
            switch(command) {
                case 1 -> boom = updateBoard(x,y);
                case 2 -> markMineOnBoard(x,y, MINE_MAYBE);
                case 3 -> markMineOnBoard(x,y, MINE_KNOWN);
                default -> System.out.println("Invalid command: " + command);
            }
        }
        
        printBoard(false);
        printBoard(true);
        if(boom) 
            System.out.println("#### BOOM ####\nYou hit the mine at ("
                             + x + "," + y + ")");
        else if(boardIsCorrect()) 
            System.out.println("#### WINNER ####");
        
        System.out.println("\nThanks for playing MineSweeper!"); 
            
    }
}
