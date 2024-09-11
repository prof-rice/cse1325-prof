import complex.Complex;

class TestComplex {
    public static void main(String[] args) {
        Complex c1 = new Complex(3.0, 4.0);        // Cartesian by default - a + bi
        Complex.setForm(Complex.Form.POLAR);       // Call static method on CLASS
        Complex c2 = new Complex(10.0, Math.PI/4); // Polar - r(cos θ + i sin θ)

        System.out.println("In polar:     " + c1 + " and\n              " + c2);
        
        c2.setForm(Complex.Form.CARTESIAN);        // Call static method on OBJECT
        
        System.out.println("In Cartesian: " + c1 + " and\n              " + c2);
     }
} 
