import java.util.ArrayList;

public class TicTacToe {
    // This is the size of the (square) board, traditionally 3x3
    public static final int SIZE = 3;
    
    // Marker represents what exists at an (x,y) location.
    // 's' has not been marked yet, O and X are the 2 players
    public enum Marker {s, O, X;
        @Override
        public String toString() {
            return (this == s) ? "." : name();
        }
    }
    
    // Here's our 2D ArrayList, or an ArrayList of ArrayLists.
    // More properly, this should be List<List<Marker>> - coming soon.
    private ArrayList<ArrayList<Marker>> board;
    
    public TicTacToe() {
        board = new ArrayList<ArrayList<Marker>>();        // Instance the outer list
        for(int x=0; x<SIZE; ++x) {
            ArrayList<Marker> a = new ArrayList<Marker>(); // Instance an inner list,
            for(int y=0; y<SIZE; ++y) a.add(Marker.s);     //   fill with 's', and
            board.add(a);                                  //   add to the outer list
        }
    }
    // The Marker is added to the board at (x,y)
    public void move(int x, int y, Marker m) {
        if(!board.get(y).get(x).equals(Marker.s))  // Don't mark if already marked
            throw new IllegalArgumentException("Position " + x + "," + y 
                                + " already has " + board.get(x).get(y));
        board.get(y).set(x, m);                    // Otherwise, safe to mark
    }
    // We generate String (or StringBuilder) for each possible winning moves,
    //   then check the text. More String, StringBuilder, and substring practice!
    public Marker winner() {
        String win1 = "";
        String win2 = "";
        StringBuilder dia1 = new StringBuilder();
        StringBuilder dia2 = new StringBuilder();
        StringBuilder row  = new StringBuilder();
        StringBuilder col  = new StringBuilder();
        for(int y=0; y<SIZE; ++y) {
           win1 += Marker.values()[1];     // Build winning string of O
           win2 += Marker.values()[2];     // Build winning string of X
           dia1.append(board.get(y).get(y));        // Build \ diagonal
           dia2.append(board.get(y).get(SIZE-y-1)); // Build / diagonal
           for(int x=0; x<SIZE; ++x) {
               row.append(board.get(y).get(x));     // Build all rows
               col.append(board.get(x).get(y));     // Build all columns
           }
        }
        if(dia1.toString().equals(win1) || dia2.toString().equals(win1)) return Marker.values()[1];
        if(dia1.toString().equals(win2) || dia2.toString().equals(win2)) return Marker.values()[2];
        for(int i=0; i<row.length(); i += SIZE) {   // Check rows/cols ever SIZE chars
            if(row.substring(i, i+SIZE).equals(win1) ||
               col.substring(i, i+SIZE).equals(win1)) return Marker.values()[1];
            if(row.substring(i, i+SIZE).equals(win2) ||
               col.substring(i, i+SIZE).equals(win2)) return Marker.values()[2];
        }
        return Marker.s;  // No winner yet
    }
    // Format the board for display
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int y=0; y<SIZE; ++y) {
            for(int x=0; x<SIZE; ++x) sb.append(" " + board.get(y).get(x).toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    // A super-concise Menu-Driven Interface (MDI)
    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        int movesLeft = SIZE * SIZE;
        while(movesLeft-- > 0 && ttt.winner() == Marker.s) {
            System.out.println("\n" + ttt + "\n");
            while(true) {
                try {
                    Marker toMove = Marker.values()[1 + movesLeft%2];
                    ttt.move(Integer.parseInt(System.console().readLine(toMove + " move (x)? ")),
                             Integer.parseInt(System.console().readLine(toMove + " move (y)? ")),
                             toMove);
                     break;
                } catch(Exception e) {
                    System.err.println("Invalid move: " + e.getMessage());
                }
            }
        }
        System.out.println("\n" + ttt + "\n");
        System.out.println(((ttt.winner() == Marker.s) ? "Cat" : ttt.winner().toString()) + " wins!");
    }
}
