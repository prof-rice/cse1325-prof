

public class TugOfWarThreaded {
    private String rope = "------------X------------";
    private String winner = "";
    private synchronized void pullLeft() {
        rope = rope.substring(1) + rope.charAt(0);
        if(rope.charAt(0) == 'X' && winner.isEmpty()) 
            winner = "Left";
    }
    private synchronized void pullRight() {
        rope = rope.charAt(rope.length()-1) + rope.substring(0, rope.length()-1);
        if(rope.charAt(rope.length()-1) == 'X' && winner.isEmpty()) 
            winner = "Right";
    }
    public void tug() {
        Thread left = new Thread(() -> {
            while(winner.isEmpty()) {
                pullLeft();
                try {Thread.sleep((int) (50 * Math.random()));
                } catch (InterruptedException e) {
                }
            }});
        Thread right = new Thread(() -> {
            while(winner.isEmpty()) {
                pullRight();
                try {Thread.sleep((int) (50 * Math.random()));
                } catch (InterruptedException e) {
                }
            }});
        left.start(); right.start();
        while(winner.isEmpty()) {
             System.out.println(rope);
             try {Thread.sleep(100);
             } catch (InterruptedException e) {
             }
        }
        left.join();
        right.join();
        System.out.println(winner + " side wins!");

    }        
    public static void main(String[] args) {
        (new TugOfWar()).tug();
    }
}
