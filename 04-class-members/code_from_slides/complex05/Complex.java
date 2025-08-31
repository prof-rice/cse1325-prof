class Complex {
    // Constructor invoked by e.g., Complex c = new Complex(3.0, 4.0);
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }
    
    // Default constructor invoked by e.g., Complex c = new Complex();
    public Complex() {
        this(0,0);    // Chain to the first constructor
    }

    // toString method replaces the default string representation
    @Override
    public String toString() {
        return a + "+" + b + "i";
    }    

    // Define an equals method that actually compares values!
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;                       // An object is equal to itself
        if(o == null) return false;                      // Null objects equal nothing
        if(o.getClass() != getClass()) return false;     // Different classes are not equal
        Complex that = (Complex) o;                      // Treat as my type
        return (this.a == that.a) && (this.b == that.b); // Compare two Complex by fields
    }   

    private double a; // (real)      These attribute can't be accessed
    private double b; // (imaginary)   outside of class Complex
}
    
