// For the quadratic ax² + bx + c = 0

// The TWO roots are given by the quadratic equation
// x[] = (-b ± √(b² - 4ac) ) / 2a

// Because b² - 4ac may be negative, the roots may be complex
// And, in fact, a, b, and c may be complex as well!

// This class solves complex quadratic equastions
// and returns the two roots as Complex[2].

public class QuadraticEquation {
    private Complex a;
    private Complex b;
    private Complex c;
    public QuadraticEquation(Complex a, Complex b, Complex c) {
        if(a.equals(new Complex())) 
            throw new IllegalArgumentException("a cannot be 0+0i");
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Complex[] solve() {
        Complex[] result = new Complex[2]; // always 2 roots

        Complex twoA = (new Complex(2,0)).multiply(a);
        Complex fourAC = (new Complex(4,0)).multiply(a)
                                           .multiply(c);
        Complex discriminant = b.multiply(b)
                                .subtract(fourAC);
        Complex sqrtD = discriminant.sqrt();
        result[0] = b.negate()
                     .add(sqrtD)
                     .divide(twoA);
        result[1] = b.negate()
                     .subtract(sqrtD)
                     .divide(twoA);
        return result;
    }
}
