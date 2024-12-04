public class Cooper_and_UTA {
    public static void main(String[] args) {
        // First instance the two faces of this signal, one facing north and south
        //   and the other facing east and west (we ignore turn lanes, etc.)
        TrafficLight northSouth = new TrafficLight(new TrafficLight.Red_1());
        TrafficLight eastWest   = new TrafficLight(new TrafficLight.Red_2());
        
        // Now generate an event to kick off the precession of lights
        TrafficLight.e_enable_green_1.generate();

        // Run for 300 seconds (5 minutes). We'll collapse repetitions ("Reps")
        //   of identical light configuration - so Reps is the number of seconds
        //   in that configuration
        String previousLights = "";
        int repetitions = 0;
        System.out.println("Reps NorthSouth   EastWest\n---- ----------  ---------");
        
        for (int i=0; i < 300; ++i) {

            // Show the color of each face of the traffic signal when it changes
            String lights = String.format("%10s %10s\n", northSouth.color().toString(),
                                                       eastWest  .color().toString());
            if(lights.equals(previousLights)) ++repetitions;
            else if(previousLights.length() != 0) {
                System.out.printf("%4d %s", repetitions+1, previousLights);
                repetitions = 0;
            }
            previousLights = lights;

            // Generate a tic for each traffic light in the signal
            northSouth.tic();
            eastWest.tic();
        }
    }
}
