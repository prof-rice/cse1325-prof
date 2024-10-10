public class TugOfWar {
    private String rope = "------------X------------";
    private String winner = "";
    private void pullLeft() {
        rope = rope.substring(1) + rope.charAt(0);
        if(rope.charAt(0) == 'X' && winner.isEmpty()) 
            winner = "Left";
    }
    private void pullRight() {
        rope = rope.charAt(rope.length()-1) + rope.substring(0, rope.length()-1);
        if(rope.charAt(rope.length()-1) == 'X' && winner.isEmpty()) 
            winner = "Right";
    }
    public void tug() {
        while(winner.isEmpty()) {
            if(Math.random() < 0.5) pullLeft(); else pullRight();
            System.out.println(" " + rope);
        }
        System.out.println(winner + " side wins!");
    }        
    public static void main(String[] args) {
        (new TugOfWar()).tug();
    }
}
