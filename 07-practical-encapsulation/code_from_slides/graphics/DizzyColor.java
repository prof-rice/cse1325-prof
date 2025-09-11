public class DizzyColor {
    public static void main(String[] args) {
        StdDraw.setScale(-360, 360);
        Turtle turtle = new Turtle();
        
        for(int distance = 1; distance < 300; ++distance) {
            StdDraw.nextPenColor(); // nextPenColor rotates through a color wheel
            turtle.forward(distance);
            turtle.turn(61);
        }
    }
}
