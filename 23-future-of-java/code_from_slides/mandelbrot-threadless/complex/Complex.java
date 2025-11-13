package complex;

import java.util.Scanner;

import java.io.PrintStream;
import java.io.File;

public class Complex {
    public Complex(double x, double y) {this.x = x; this.y = y;}
    public Complex() {this(0.0, 0.0);}
    
    // File I/O
    public Complex(Scanner in) {
        this(in.nextDouble(), in.nextDouble());
        in.nextLine();
    }
    public void save(PrintStream out) {
        out.println(x);
        out.println(y);
    }
    
    // Getters
    public double getReal() {return x;}
    public double getImaginary() {return y;}
    
    // Unary math    
    public double abs()  {return Math.hypot(x,y);}  // Math.sqrt(x*x + y*y)
    public double theta() {return Math.atan2(y,x);} // Angle
    public Complex scale(double alpha) {return new Complex(x*alpha, y*alpha);}
    public Complex conjugate() {return new Complex(x,-y);}
    public Complex reciprocal() {
        double scale = x*x + y*y;
        return new Complex(x/scale, -y/scale);
    }

    // Binary math
    public Complex plus  (Complex c) {return new Complex(x + c.x, y + c.y);}
    public Complex minus (Complex c) {return new Complex(x - c.x, y - c.y);}
    public Complex times (Complex c) {return new Complex((x * c.x) - (y * c.y),
                                                (x * c.y) + (y * c.x));
    }
    public Complex divide(Complex c) {return times(c.reciprocal());}

    // Trigonometry
    public Complex exp() {return new Complex(Math.exp(x) * Math.cos(y), 
                                             Math.exp(x) * Math.sin(y));
    }
    public Complex sin() {return new Complex(Math.sin(x) * Math.cosh(y), 
                                             Math.cos(x) * Math.sinh(y));
    }
    public Complex cos() {return new Complex(Math.cos(x) * Math.cosh(y), 
                                            -Math.sin(x) * Math.sinh(y));
    }
    public Complex tan() {return sin().divide(cos());}


    // Standard utility
    @Override
    public String toString() {
        return "" + x + ((y>=0) ? "+" : "") + y + "i";
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        Complex c = (Complex) o;
        return (x == c.x) && (y == c.y);
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31*hash + (int) (10000*x);
        hash = 31*hash + (int) (10000*y);
        return hash;
    }
       
    // Comparisons
    private final double EPSILON = 0.000001;
    private boolean equals(Double d1, Double d2) {
        return Math.abs(d1 - d2) < EPSILON;
    }
    private boolean equals(int i1, int i2) {
        return i1 == i2;
    }
    
    private double x;
    private double y;
}


