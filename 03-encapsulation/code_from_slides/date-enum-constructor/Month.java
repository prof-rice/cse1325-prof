// Each enumerated value calls the constructor below with its parameter
public enum Month {January(1),  February(2),  March(3), 
                   April(4),    May(5),       June(6), 
                   July(7),     August(8),    September(9), 
                   October(10),  November(11),  December(12);
    
    // Attribute for the integer representing this month               
    private final int monthID;
    
    // Constructor for setting the attribute
    private Month(int monthID) {
        this.monthID = monthID;
    }
    
    // Method that returns the associated month ID for a month
    public int asInt() {
        return monthID;
    }
}
           
