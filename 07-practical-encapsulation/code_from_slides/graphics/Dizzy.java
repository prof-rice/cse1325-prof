public class Dizzy {
    public static void main(String[] args) {
        StdDraw.setScale(-360, 360);  // The square window will be from (-360,-360) to (360,360)
        Turtle turtle = new Turtle(); // Hello, turtle!
        
        for(int distance = 1; distance < 300; ++distance) {
            turtle.forward(distance); // Move forward distance steps (in StdDraw units)
            turtle.turn(61);          // Turn left 61°
        }
    }
}
