public class Complex {
    public enum Form{CARTESIAN, POLAR}; // and EXPONENTIAL, but who's counting?

    // In Cartesian, a is real and b is imaginary
    // In Polar, a is r and b is theta
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
        if(o == this) return true;
        if(o == null) return false;
        if(o.getClass() != getClass()) return false;
        Complex that = (Complex) o;
        return (this.a == that.a) && (this.b == that.b);
    }
    
    
    private double a;
    private double b;
    
    // Form to use for I/O (constructor and toString)
    private static Form form = Form.CARTESIAN;
    public static void setForm(Form form) {Complex.form = form;}
    public static Form getForm() {return form;}
}

