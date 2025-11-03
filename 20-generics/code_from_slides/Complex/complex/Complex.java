package complex; 

import java.util.Objects;

public class Complex<T> {
    public Complex(T a, T b, Calc<T> calc) {
        this.calc = calc;
        this.a = a;
        this.b = b;
    }
    public double magnitude() {
        double aa = calc.toDouble(a);
        double bb = calc.toDouble(b);
        return Math.sqrt(aa*aa + bb*bb);
    }
    public Complex<T> add(Complex<T> rhs) {
        return new Complex(calc.add(a, rhs.a), calc.add(b, rhs.b), calc);
    }
    @Override
    public String toString() {
        return a + "+" + b + "i";
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null ||
           o.getClass() != getClass()) return false;
        Complex<T> c = (Complex<T>)o;
        return (c.a.equals(a)) && (c.b.equals(b));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
    
    private Calc<T> calc; // Performs basic math on type T (see interface Calc)
    
    private T a;
    private T b;
}

