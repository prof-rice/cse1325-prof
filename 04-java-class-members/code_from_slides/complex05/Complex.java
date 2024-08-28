public class Complex {
    // Constructor invoked by e.g., Complex c = new Complex(3.0, 4.0);
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }
    // Default constructor invoked by e.g., Complex c = new Complex();
    public Complex() {
        this(0,0);    // Chain to the first constructor
    }
    public double magnitude() {
        return Math.sqrt(a*a + b*b);
    }
    @Override
    public String toString() {
        return a + "+" + b + "i";
    } 
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;                // An object is equal to itself
        if(o instanceof Double)
            return (a == (Double) o) && b == 0;   // Compare Complex to Double
        if(!(o instanceof Complex)) return false; // A different type is not equal
        Complex c = (Complex)o;
        return (a == c.a) && (b == c.b);          // Compare two Complex
    }   
    private double a; // (real)      These attribute can't be accessed
    private double b; // (imaginary)   outside of class Complex
}

