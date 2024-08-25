public class TrafficLight {
    // The fields of class TrafficLight.
    // Private means they cannot be directly accessed outside of the class.
    // I usually put these at the bottom, because programmers reading my code
    //    are usually more interested in the (public) interfaces.
    private boolean operating;
    private Color light;
    
    // This is the CONSTRUCTOR
    TrafficLight() {
        this.operating = true; 
        this.light = Color.red;
    }
    // This is a GETTER method
    // They often (but not always) are named starting with "get"
    public boolean isOperating() {
        return operating;
    }
    // This is a SETTER method
    // They often (but not always) are named starting with "set"
    public void power(boolean operating) {
        this.operating = operating;
    }
    // Another GETTER method
    // Note that we have no setter for the light field
    // It is read-only
    public Color thisColor() {
        return light;
    }
    // A METHOD that manipulates the field named light
    // No code external to class TrafficLight can modify field light
    // Encapsulation!
    public Color nextColor() {
        // Example of a switch expression
        light = switch(light) {
                    case green  -> Color.yellow;
                    case yellow -> Color.red;
                    case red    -> Color.green;
                };
        // Prior to Java 14 (which introduced switch expressions), 
        //     I would nest ternaries and (clearly, I think) write:
        // light = ((light == Color.green)  ? Color.yellow : 
        //         ((light == Color.yellow) ? Color.red    :
        //                                    Color.green));
        return light;
    }
    // The special METHOD that converts a TrafficLight object into a String.
    // The @Override isn't required for Java, but it is required in CSE1325.
    // We'll discuss why in Lecture 08.
    @Override
    public String toString() {
        // Example of a ternary
        return operating ? light.name() : "off";
    }
}
