public class TwoIdenticalSpheresInSpace {
    // Static constant field, usually initialized in-line
    public static final double GRAVITATIONAL_CONSTANT = 6.6743E-11;
    
    // Non-static constant field, often initialized in the constructor
    private final double mass;
    
    // Non-static non-constant field
    private double distance;
    
    // Mass cannot change, but distance can change
    //   (mass is in kilograms, radius is in meters)
    public TwoIdenticalSpheresInSpace(double mass, double radius) {
        this.mass = mass;  // field = parameter
        // this.mass *= 2; // NO - can no longer change, is final
        
        this.distance = radius;
        this.distance *= 2; // YES - not final
    }
    public double force() {
        final double massPerKgSecSqr = GRAVITATIONAL_CONSTANT * mass * mass;
        // massPerKgSecSqr *= 2; // NO - can no longer change, is final
        return massPerKgSecSqr / (distance * distance);
    }
    public double acceleration() {
        return force() / mass;
    }
    public static void main(String[] args) {
        // Constant variable
        final double mass;  // kg
        if(args.length > 0) mass = Double.parseDouble(args[0]);
        else mass = 100;
        
        // Non-constant variable
        double radius = 12.5; // m
        
        TwoIdenticalSpheresInSpace ss = new TwoIdenticalSpheresInSpace(mass, radius);
        System.out.println("The force between two " + mass + " kg identical spheres "
            + radius*2 + " m apart is " + ss.force() + " kN");
        System.out.println("This imparts an acceleration of " 
            + ss.acceleration() + " m/s²");
    }
}
