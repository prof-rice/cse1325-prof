import java.util.concurrent.TimeUnit;

public class Main {
    private static TrafficLight utaCooperEW = new TrafficLight();
    private static TrafficLight utaCooperNS = new TrafficLight();
       
    public static void printLights() {
        System.out.print( ""
          + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
          + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
          + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
          + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
          + ((utaCooperEW.thisColor() == Color.red)    ? "@ "  : "- ")
          + ((utaCooperNS.thisColor() == Color.red)    ? "@\n" : "-\n")
          + ((utaCooperEW.thisColor() == Color.yellow) ? "@ "  : "- ")
          + ((utaCooperNS.thisColor() == Color.yellow) ? "@\n" : "-\n")
          + ((utaCooperEW.thisColor() == Color.green)  ? "@ "  : "- ")
          + ((utaCooperNS.thisColor() == Color.green)  ? "@\n" : "-\n")
        );
    }
    public static void main(String[] args) 
            throws InterruptedException {
        while(true) {
            utaCooperEW.nextColor(); printLights(); 
            TimeUnit.SECONDS.sleep(3);
            
            utaCooperEW.nextColor(); printLights(); 
            TimeUnit.SECONDS.sleep(1);
            
            utaCooperEW.nextColor(); utaCooperNS.nextColor();printLights(); 
            TimeUnit.SECONDS.sleep(3);
       
            utaCooperNS.nextColor(); printLights(); 
            TimeUnit.SECONDS.sleep(1);
            
            utaCooperNS.nextColor(); 
        }
    }
}
