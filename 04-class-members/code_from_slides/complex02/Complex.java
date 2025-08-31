public class Complex {
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }
    // The toString method replaces the default string representation
    @Override
    public String toString() {
        return a + "+" + b + "i";
    }    
    private double a;
    private double b;
    
    public static void main(String[] args) {
        Complex c = new Complex(3.0, 4.0);
        System.out.println("Created Complex number " + c);
    }
}

