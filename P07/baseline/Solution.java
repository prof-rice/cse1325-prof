import java.util.Objects;

public class Solution implements Comparable<Solution> {
    public Solution(Integer boardNumber, String word, Position startingPosition, int threadNumber) {
        this.boardNumber = boardNumber;
        this.word = word;
        this.startingPosition = startingPosition;
        //this.threadNumber = threadNumber;
        this.moves = "";
    }
    public Solution(Solution solution, int move) {
        this.boardNumber = solution.boardNumber;
        this.word= solution.word;
        this.startingPosition = solution.startingPosition;
        this.moves = solution.moves + move;
        //this.threadNumber = solution.threadNumber;
    }
    @Override
    public String toString() {
     // return "Thread " + threadNumber + " Board " + boardNumber + ": " 
        return "Board " + boardNumber + ": " 
             + word + "@" + startingPosition + " " + moves;
    }
    @Override
    public int compareTo(Solution that) {
        int result = this.boardNumber.compareTo(that.boardNumber);
        if(result == 0) result = word.compareTo(that.word);
        if(result == 0) result = startingPosition.compareTo(that.startingPosition);
        if(result == 0) result = moves.compareTo(that.moves);
        return result;
    }
    @Override 
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Solution that = (Solution) o;
        return this.compareTo(that) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(boardNumber, word, startingPosition, moves);
    }
    
    private Integer boardNumber;
    private String word;
    private Position startingPosition;
    private String moves;
    
    //private int threadNumber; // NOT relevant for comparisons or hashes
}
