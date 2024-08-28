public class Complex {
    enum Form{CARTESIAN, POLAR}; // and EXPONENTIAL, but who's counting?

    // Constructor invoked by e.g., Complex c = new Complex(3.0, 4.0);
    public Complex(double a, double b) {
        switch (form) {
            case CARTESIAN: {
                this.a = a;
                this.b = b;
                break;
            }
            case POLAR: {
                this.a = a * Math.cos(b);
                this.b = a * Math.sin(b);
                break;
            }
            default: throw new IllegalArgumentException("Invalid Form enum");
        }
    }
    // Default constructor invoked by e.g., Complex c = new Complex();
    public Complex() {
        this(0,0);    // Chain to the first constructor
    }
    public double magnitude() {
        return Math.sqrt(a*a + b*b);
    }
    public Complex add(Complex rhs) {
        return new Complex(a+rhs.a, b+rhs.b);
    }
    @Override
    public String toString() {
        switch (form) {
            case CARTESIAN: {
                return a + "+" + b + "i";
            }
            case POLAR: {
                // String r = String.format("%.2f", Math.sqrt(a*a + b*b));
                // String theta = String.format("%.3f", Math.atan(b/a));
                final double r = Math.sqrt(a*a + b*b);
                final double theta = Math.atan(b/a);
                return r + "(cos " + theta + ") + i sin(" + theta + ")";
            }
            default: throw new IllegalArgumentException("Invalid Form enum");
        }
        
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
    
    // Form to use for I/O (constructor and toString)
    private static Form form = Form.CARTESIAN;
    public static void setForm(Form form) {Complex.form = form;}
    public static Form getForm() {return form;}
}

