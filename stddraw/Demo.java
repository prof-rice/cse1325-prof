public class Demo {
    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    
    public static void main(String[] args) throws InterruptedException{
        StdDraw.setScale(-12.0, +12.0);        // Window is now (-12,-12) to (12,12)
        StdDraw.setPenColor(StdDraw.RED);      // Draw with a red pen
        StdDraw.setPenRadius(0.003);
        
        for(double radius=1.0; radius < 12.0; radius += 3.0) {  // explosion effect
            for(double theta=0; theta<Math.PI; theta += Math.PI/16) {
                double x = radius * Math.cos(theta);   // A bit of trigonometry, sorry! :D
                double y = radius * Math.sin(theta);
                StdDraw.line(-x, -y, x, y);            // Draw from (-x,-y) to (x,y)
            }
            System.out.print("Press enter for next step: ");
            scanner.nextLine();                // Pause to admire the art
            StdDraw.clear();                   // Clear the window
        }
        StdDraw.close();                       // Close the window
    }
}
