public class TwoIdenticalSpheresInSpaceWithBlocks {
    // Static constant field, usually initialized in-line
    // Here we defer to the static initialization block below
    public static final double GRAVITATIONAL_CONSTANT; // = 6.6743E-11;
    
    // Non-static constant field, often initialized in the constructor
    private final double mass;
    
    // Non-static non-constant field
    private double distance;
    
    // Static initialization block runs at load time,
    // assigning values to static final fields
    static { 
        GRAVITATIONAL_CONSTANT = 6.6743E-11;
    }
    
    // Instance initialization block runs at the start of ALL constructors
    // (after the optional super statement, which we'll cover later)
    { 
        System.out.println("Initializing 2 identical spheres in space");
    }
    // Mass cannot change, but distance can change
    //   (mass is in kilograms, radius is in meters)
    public TwoIdenticalSpheresInSpaceWithBlocks(double mass, double radius) {
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
        final double mass = 100;  // kg
        
        // Non-constant variable
        double radius = 12.5; // m
        
        TwoIdenticalSpheresInSpaceWithBlocks sis = new TwoIdenticalSpheresInSpaceWithBlocks(mass, radius);
        System.out.println("The force between two " + mass + "kg identical spheres "
            + radius*2 + " m apart is " + sis.force() + " kN");
        System.out.println("This imparts an acceleration of " 
            + sis.acceleration() + " m/s²");
    }
}
