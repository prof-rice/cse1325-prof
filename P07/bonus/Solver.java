public class Solver {
    public Solver(Board board, int threadNumber, int verbosity) {
        this.board = board;
        this.threadNumber = threadNumber;
        this.verbosity = verbosity;
        log(board.toString(), 3);
    }

    public Solver(Board board, int threadNumber) {
        this(board, threadNumber, 0);
    }
    
    // Solve attempts to find the word in the current board
    // Unlike actual Board, it WILL reuse any adjacent letter even if already used
    public Solution solve(String word) {
        log("Searching for " + word, 3);
        for(int row=0; row<board.getBoardSize(); ++row) {              // Scan the entire board
            for(int column=0; column<board.getBoardSize(); ++column) {
                Position p = new Position(row, column);
                Solution s = findNextChar(word, p, new Solution(board.getBoardNumber(), word, p, threadNumber));
                if(s != null) return s;
            }
        }
        return null;
    }

    // This method works by recursion - given the remaining letters in partialWord
    //   and the partialSolution already found, look at the 8 moves around position
    //   in search of the *next* letter.
    // If the next letter is found, then call findNextChar if more letters remain
    //   or return the solution if the entire word has been found.
    private Solution findNextChar(String partialWord, Position position, Solution partialSolution) {
        log("findNextChar(" + partialWord + "," + position + "," + partialSolution + ")", 4);
        if(partialWord.charAt(0) != board.get(position)) return null; // current position incorrect
        if(partialWord.length() == 1) return partialSolution;         // correct and last letter FOUND!
        for(int move : Board.moves) {                                 // Look at the 8 surrounding spots
            Position nextPos = board.move(position, move); if(nextPos == null) continue;
            Solution s = findNextChar(partialWord.substring(1),       //   and check for next character
                                      nextPos, 
                                      new Solution(partialSolution, move));
            if(s != null) return s; // If not null, this is a complete and valid solution!
        }
        return null;
    }

    // This implements verbosity from Boggle, printing the debug message only if requested
    private void log(String s, int level) {
        if(verbosity == level) System.out.println(s);
    }
    
    // This is an algorithm-only class - it does not store business data,
    // so toString, equals, and hashCode do not apply

    private Board board;

    private int threadNumber;
    private int verbosity;
}
