public class TestComplex {
    public static void main(String[] args) {
        Complex c1 = new Complex(3.0, 4.0);
        Complex c2 = new Complex(3.0, 4.0); 
        System.out.println("" + c1 + " " 
            + ((c1 == c2) ? "==" : "!=")
            + " " + c2);
        System.out.println("" + c1 + " " 
            + ((c1.equals(c2)) ? " equals " : " does not equal ")
            + " " + c2);
            
        Complex c3 = new Complex(5.0, 0.0); 
        Double d = 5.0; 
        System.out.println("" + c3 + " " 
            + ((c3.equals(d)) ? " equals " : " does not equal ")
            + " " + d);

        Complex c4 = new Complex(0.0, 3.14); 
        System.out.println("The magnitude of " + c1 + " is " + c1.magnitude());
        System.out.println("The magnitude of " + c3 + " is " + c3.magnitude());
        System.out.println("The magnitude of " + c4 + " is " + c4.magnitude());

        Complex c5 = c1.add(c3).add(c4);
        System.out.println("" + c1 + " + " + c3 + " + " + c4 + " = " + c5);        
    }
} 
