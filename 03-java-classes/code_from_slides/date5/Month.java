// Each enumerated value calls the constructor below with its parameter
public enum Month {January(1,"garnet"),     February(2,"amethyst"),  
                   March(3,"aquamarine"),   April(4,"diamond"),
                   May(5,"emerald"),        June(6,"pearl"), 
                   July(7,"ruby"),          August(8,"peridot"),    
                   September(9,"sapphire"), October(10,"tourmaline"),  
                   November(11,"citrine"),  December(12,"tanzanite");
    
    // Attribute for the integer representing this month               
    private final int monthID;
    private final String gem;
    
    // Constructor for setting the attribute
    private Month(int monthID, String gem) {
        this.monthID = monthID;
        this.gem = gem;
    }
    
    // Method that returns the associated month ID for a month
    public int asInt() {
        return monthID;
    }
    
    // Method that returns the associated month's gemstone
    public String asGemstone() {
        return gem;
    }
    
    public String toString() {
        return this.name() + " (" + monthID + "," + gem + ")";
    }
}
           
