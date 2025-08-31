public class Complex {
    // Constructor invoked by e.g., Complex c = new Complex(3.0, 4.0);
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }
    
    private double a; // (real)      These attribute can't be accessed
    private double b; // (imaginary)   outside of class Complex
}
    
