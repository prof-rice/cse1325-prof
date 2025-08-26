public class Main {
    private static TrafficLight utaCooperEW = new TrafficLight();
    private static TrafficLight utaCooperNS = new TrafficLight();
    
    private static void printLight(Color color) {
        System.out.print(
            ((utaCooperEW.thisColor() == color)    ? "@ "  : "- ")
          + ((utaCooperNS.thisColor() == color)    ? "@\n" : "-\n"));
    }
    public static void printLights() {
        System.out.print("\n".repeat(80));
        printLight(Color.red);
        printLight(Color.yellow);
        printLight(Color.green);
    }
    public static void main(String[] args) throws InterruptedException {
        while(true) {
            utaCooperEW.nextColor(); printLights(); 
            Thread.sleep(3000);
            
            utaCooperEW.nextColor(); printLights(); 
            Thread.sleep(1000);
            
            utaCooperEW.nextColor(); utaCooperNS.nextColor();printLights(); 
            Thread.sleep(3000);
       
            utaCooperNS.nextColor(); printLights(); 
            Thread.sleep(1000);
            
            utaCooperNS.nextColor(); 
        }
    }
}
