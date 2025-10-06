package complex; 

import java.util.Objects;

/**
 * Models a Complex number.
 *
 * @author             Prof Rice
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
public class Complex {
    /**
     * Enumerates the current forms of the Complex library.
     *
     * @since              1.0
     */
    public enum Form{
        /**
         * Cartesian form, where a is real and b is imaginary
         */
        CARTESIAN, 
         
         /**
          * Polar form, where a is magnitude and b is the angle theta
          */
         POLAR
    }; // and EXPONENTIAL, but who's counting?

    /**
     * Creates a Complex instance.
     *
     * @param a            the real component of the Complex number
     * @param b            the imaginary component of the Complex number
     * @since              1.0
     */
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

    /**
     * Creates a default Complex instance.
     *
     * @since          1.0
     * @see            #Complex(double,double)
     */
    public Complex() {
        this(0,0);    // Chain to the first constructor
    }

    /**
     * Calculates the magnitude of this complex number.
     *
     * @return         The magnitude of the complex number in this object.
     * @since          1.0
     */
    public double magnitude() {
        return Math.sqrt(a*a + b*b);
    }

    /**
     * Adds this Complex instance to another, returning the result.
     *
     * @param rhs      the Complex number to be added to this instance
     * @return         the resulting Complex number
     * @since          1.0
     */
    public Complex add(Complex rhs) {
        return new Complex(a+rhs.a, b+rhs.b);
    }

    /**
     * Returns the Cartesian or polar form of the Complex number,
     *   depending on the current form.
     *
     * @return         String of the resulting Complex number depending on Form
     * @since          1.0
     */

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
    
    /**
     * Returns true if the parameter is equal to the current Complex number.
     *
     * @param o        A Complex or Double object to compare
     *                 (all others return false)
     * @return         Boolean is true if the values are equivalent
     * @since          1.0
     */
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;                // An object is equal to itself
        if(o instanceof Double)
            return (a == (Double) o) && b == 0;   // Compare Complex to Double
        if(!(o instanceof Complex)) return false; // A different type is not equal
        Complex c = (Complex)o;
        return (a == c.a) && (b == c.b);          // Compare two Complex
    }
    
    /**
     * Returns a hash value based on both a and b.
     *
     * @return         int hash code
     * @since          1.0
     */
    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
    
    
    private double a; // (real)      These attribute can't be accessed
    private double b; // (imaginary)   outside of class Complex
    
    // Form to use for I/O (constructor and toString)
    private static Form form = Form.CARTESIAN;
    
    /**
     * Specifies the form for future Complex I/O operations for all instances.
     *
     * <p>See Form for valid constants
     *
     * @param form     The form to use for future operations
     * @since          1.0
     */   
    public static void setForm(Form form) {Complex.form = form;}
    
    /**
     * Returns the current form for all Complex I/O operations.
     *
     * <p>See Form for valid constants
     *
     * @return         The current form in use
     * @since          1.0
     */   
    public static Form getForm() {return form;}
}

