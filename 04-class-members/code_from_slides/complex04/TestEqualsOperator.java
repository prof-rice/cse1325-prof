public class TestEqualsOperator {
    public static void main(String[] args) {
        System.out.println();

        // Test == for primitives
        int i1 = 15;
        int i2 = 15;
        int i3 = 20;

        System.out.println("      " + i1 + " " 
            + ((i1 == i2) ? "==" : "!=")
            + " " + i2);

        System.out.println("      " + i3 + " " 
            + ((i3 == i2) ? "==" : "!=")
            + " " + i2);
        
        System.out.println();

        // Test == for objects
        Complex c1 = new Complex(3.0, 4.0);
        Complex c2 = new Complex(3.0, 4.0);
        Complex c3 = new Complex(6.0, 8.0);

        System.out.println("" + c1 + " " 
            + ((c1 == c2) ? "==" : "!=")
            + " " + c2 + " <== What?");

        System.out.println("" + c3 + " " 
            + ((c3 == c2) ? "==" : "!=")
            + " " + c2);

        System.out.println();
    }
} 
