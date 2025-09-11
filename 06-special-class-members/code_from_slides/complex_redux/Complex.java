import java.util.Objects;

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
    public Complex negate() {
        return new Complex(-a, -b);
    }
    public Complex add(Complex rhs) {
        return new Complex(a+rhs.a, b+rhs.b);
    }
    public Complex subtract(Complex rhs) {
        return new Complex(a-rhs.a, b-rhs.b);
    }
    public Complex multiply(Complex rhs) {
        return new Complex(a*rhs.a - b*rhs.b, 
                           a*rhs.b + b*rhs.a);
    }
    public Complex divide(Complex rhs) {
        double divisor = rhs.a*rhs.a + rhs.b*rhs.b;
        return new Complex((a*rhs.a + b*rhs.b) / divisor, 
                           (b*rhs.a - a*rhs.b) / divisor);
    }
    public Complex sqrt() {
        double r = this.magnitude();
        return new Complex(Math.sqrt((r + a) / 2),
            Math.sqrt((r - a) / 2) * ((b >= 0) ? 1 : -1));
    }
    public Complex incrementReal() {
        return this.add(new Complex(1, 0));
    }
    public Complex incrementImaginary() {
        return this.add(new Complex(0, 1));
    }
    @Override
    public String toString() {
        switch (form) {
            case CARTESIAN: {
                if(a == 0 && b == 0) {
                    return "0";
                } else if(a == 0) {
                    return b + "i";
                } else {
                    if(b > 0) return a + "+" + b + "i";
                    if(b == 0) return "" + a;
                    if(b < 0) return a + b + "i";
                }
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
        if(o == this) return true;  // 1. This is always equal to itself
        if(o == null || 
          (o.getClass() != getClass())) 
                      return false; // 2. Not equal if a different type
        Complex that = (Complex) o; // 3. Cast to my type
        return (this.a == that.a) 
            && (this.b == that.b);  // 4. Compare relevant fields a & b
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(a,b);
    }
    
    private double a; // (real)      These attribute can't be accessed
    private double b; // (imaginary)   outside of class Complex
    
    // Form to use for I/O (constructor and toString)
    private static Form form = Form.CARTESIAN;
    public static void setForm(Form form) {Complex.form = form;}
    public static Form getForm() {return form;}
}

