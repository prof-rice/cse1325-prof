public class Sunflower {
    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    
    public static void main(String[] args) throws InterruptedException{
        StdDraw.setScale(-4.0, +4.0);        // Window is now (-4,-4) to (4,4)
        StdDraw.setPenColor(StdDraw.ORANGE); // Draw with an orange pen
        StdDraw.setPenRadius(0.003);         // Set the line width
        
        final double r = 3.0; // radius of the sunflower
        final double k = 5.0; // number of principal petals
        final int stepDivisor = 64;
        final double stepIncrement = Math.PI/1024; // slowly spin while generating
        int steps = 0;
        Double xLast = null;  // starting (x,y) of the line
        Double yLast = null;
        for(double t=0; t<Math.PI*16; t+=Math.PI/stepDivisor) {
            Double x = r * Math.cos(k * t)  * Math.cos(t + stepIncrement * ++steps);
            Double y = r * Math.cos(k * t)  * Math.sin(t + stepIncrement * ++steps);
            if(xLast != null && yLast != null) {
                StdDraw.line(xLast, yLast, x, y);
            }
            xLast = x;
            yLast = y;
        }
        StdDraw.setPenColor(150, 75, 0);        // Draw with a brown pen
        StdDraw.filledCircle(0.0, 0.0, r/3.0);  // Fill in the pistil
        
        System.out.print("Press Enter to exit: ");
        scanner.nextLine();                // Pause to admire the art
        StdDraw.clear();                   // Clear the window
        StdDraw.close();                   // Close the window
    }
}
