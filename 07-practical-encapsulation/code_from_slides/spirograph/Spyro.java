public class Spyro {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-200, 200);
        
        double innerRingRadius  =  100.0;
        double wheelRadius      =    2.0;
        double penRadius        =   80.0;
        
        Spirograph spirograph = new Spirograph(innerRingRadius,
                                               wheelRadius,
                                               penRadius);

        double tStart           =    0.0;
        double tEnd             =    2.0 * Math.PI;
        int count               = 2001;
        boolean multicolored    = true;

        spirograph.draw(tStart, tEnd, count, multicolored);
        StdDraw.show();
    }

}
