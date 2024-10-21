import java.util.Random;
import java.util.Objects;

// This class represents a Boggle board from 1x1 to 99x99

public class Board {
    // This constructor predictably generates a random boardSize x boardSize Boggle board
    public Board(int boardSize) {
        this.boardNumber = nextBoardNumber++;
        board = new String[boardSize];
        for(int row=0; row<boardSize; ++row) {
            StringBuilder sb = new StringBuilder();
            for(int column=0; column<boardSize; ++column) {
                sb.append(validChars.charAt(random.nextInt(validChars.length())));
            }
            board[row] = sb.toString();
        }
    }
    // Alternate constructor primarily for testing 
    public Board(String[] board) {
        this.board = board;
    }
    
    public int getBoardSize() {
        return board.length;
    }
    public int getBoardNumber() {
        return boardNumber;
    }

    // This field / method pair help navigate to adjacent letters on the board
    // Directions are relative to 5 on a numeric keypad 
    public static final int[] moves = new int[] {9, 8, 7, 6, 4, 3, 2, 1};
    
    // This calculates a new Position, or null if off-board (MUST match int[] moves above!)
    public Position move(Position p, int offset) {
        int r = p.row;
        int c = p.column;
        switch(offset) {
            case 7  -> {--r; --c;} // up left
            case 8  -> {--r     ;} // up
            case 9  -> {--r; ++c;} // up right
            case 4  -> {     --c;} // left
            case 6  -> {     ++c;} // right
            case 1  -> {++r; --c;} // down left
            case 2  -> {++r     ;} // down
            case 3  -> {++r; ++c;} // down right
            default -> throw new RuntimeException("Board.move unhandled offset " + offset);
        }
        if  (r < 0 || r >= board.length
          || c < 0 || c >= board.length) return null;
        else return new Position(r,c);
    }
    public char get(Position p) {
        return board[p.row].charAt(p.column);
    }
    @Override
    public String toString() {
        String sep = "-".repeat(board.length) + '\n';
        
        // This generates column headers for the board
        //   for board sizes from 1 to 99
        StringBuilder tens = new StringBuilder();
        StringBuilder ones = new StringBuilder();
        int ten = 0;
        int one = 0;
        for(int i=0; i<board.length; ++i) {
            ones.append(Integer.toString(one));
            tens.append(Integer.toString(ten));
            if(++one == 10) {++ten; one = 0;}
        }

        // Lots of string manipulation - use StringBuilder!
        StringBuilder sb = new StringBuilder(
            "   " + tens + "\n   " + ones + "\n   " + sep
        );
        
        // This generates row labels on each side of the board
        int row = 0;
        for(String s : board) sb.append(
            String.format("%02d|%s|%02d\n", row, s, row++));
        sb.append("   " + sep + "   " + tens + "\n   " + ones + "\n");
        return sb.toString();
    }
    @Override 
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Board that = (Board) o;
        for(int i=0; i<board.length; ++i){
            if(!board[i].equals(that.board[i])) return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        return Objects.hash((Object[]) board);
    }
    
    // This is the actual Boggle board - the chars in each row are String,
    //   and multiple rows are a true array
    private String[] board;
    
    // These are the valid characters allowed on the Boggle board
    private static final String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    // random is seeded to ensure we get identical Boggle boards every time
    private static Random random = new Random(0xC0FFEE); 

    private static int nextBoardNumber = 0;
    private int boardNumber;

}
