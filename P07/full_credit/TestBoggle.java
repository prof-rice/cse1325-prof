public class TestBoggle {
    public static void main(String[] args) {
        String[] board = new String[] {
            "ABEG", "IOPQ", "RYEL", "OISR"
        };
        
        Solver solver = new Solver(new Board(board), 0);
        
        System.out.println(solver.solve("BOY"));
    }
}
