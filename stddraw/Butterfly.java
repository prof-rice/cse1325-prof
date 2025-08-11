public class Butterfly {
    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    
    public static void main(String[] args) throws InterruptedException{
        StdDraw.setScale(-4.0, +4.0);        // Window is now (-4,-4) to (4,4)
        StdDraw.setPenRadius(0.003);         // Set the line width
        
        final int loopMultiplier = 24;
        final int stepDivisor = 64;
        int steps = 0;
        Double xLast = null;
        Double yLast = null;
        for(double t=0; t<Math.PI*12; t+=Math.PI/stepDivisor) {
            double k = Math.exp(Math.cos(t)) - 2 * Math.cos(4*t) - Math.pow(Math.sin(t/12), 5.0);
            Double x = Math.sin(t) * k;
            Double y = Math.cos(t) * k;
            if(xLast != null && yLast != null) {
                StdDraw.line(xLast, yLast, x, y);
                if(++steps % stepDivisor == 0) StdDraw.nextPenColor();
            }
            xLast = x;
            yLast = y;
        }
        System.out.print("Press Enter to exit: ");
        scanner.nextLine();                // Pause to admire the art
        StdDraw.clear();                   // Clear the window
        StdDraw.close();                   // Close the window
    }
}
