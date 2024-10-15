package complex;

public class TestComplex {
    public static void main(String[] args) {
        int result = 0;
        int testVector = 1;
        
        Complex c1 = new Complex(3.0, 4.0);
        Complex c2 = new Complex(8.0, -6.0);

        String expected_c1 = "3.0+4.0i";
        String expected_c2 = "8.0-6.0i";
        
        Complex expected_plus     = new Complex(11.0, -2.0);
        Complex expected_minus    = new Complex(-5.0, 10.0);
        Complex expected_times    = new Complex(48.0, 14.0);
        Complex expected_divide   = new Complex( 0.0,  0.5);
        double expected_abs_c1    = 5.0;
        double expected_abs_c2    = 10.0;
        double expected_theta_c1  = 0.9272952180016122;
        double expected_theta_c2  = -0.6435011087932844;
        Complex expected_scale_c1 = new Complex( 4.5,  6.0); // by 1.5
        Complex expected_scale_c2 = new Complex(12.0, -9.0);
        Complex expected_conj_c1  = new Complex( 3.0, -4.0);
        Complex expected_conj_c2  = new Complex( 8.0,  6.0);
        Complex expected_exp_c1   = new Complex(-13.128783081462158,-15.200784463067954);
        Complex expected_exp_c2   = new Complex(2862.2272849105543,832.9258610593317);
        Complex expected_sin_c1   = new Complex(3.853738037919377,-27.016813258003932);
        Complex expected_sin_c2   = new Complex(199.56902807063307,29.349271217017808);
        Complex expected_cos_c1   = new Complex(-27.034945603074224,-3.851153334811777);
        Complex expected_cos_c2   = new Complex(-29.34963187554332,199.56657569672572);
        Complex expected_tan_c1   = new Complex(-1.8734620462948492E-4,0.999355987381473);
        Complex expected_tan_c2   = new Complex(-3.5379198642104814E-6,-1.000011768189405);
        
        
        // Test toString
        {
          if(!c1.toString().equals(expected_c1)) {
              result |= testVector;
              System.out.println("Error in toString: Expected " + expected_c1 
                               + " Actual " + c1.toString());
          }
          if(!c2.toString().equals(expected_c2)) {
              result |= testVector;
              System.out.println("Error in toString: Expected " + expected_c2
                               + " Actual " + c2.toString());
          }
          testVector <<= 1;
        }
        
        // Test getters
        {
          if( (c1.getReal() != 3.0) || (c1.getImaginary() !=  4.0)
           || (c2.getReal() != 8.0) || (c2.getImaginary() != -6.0)) {
              result |= testVector;
              System.out.println("Error in getters: Expected " + expected_c1
                                + " Actual "  + c1.getReal() + " + " + c1.getImaginary() 
                                + "i OR Expected " + expected_c2
                                + " Actual "  + c2.getReal() + " + " + c2.getImaginary() 
                                + "i");
          }
          testVector <<= 1;
        }
       
        // Test math (+, -, *, /, reciprocal)
        {
          if(!c1.plus(c2).equals(expected_plus)) {
              result |= testVector;
              System.out.println("Error in plus: Expected " + c1 + " + " + c2 
                               + " = " + expected_plus
                               + " Actual " + c1.plus(c2));
          }
          if(!c2.plus(c1).equals(expected_plus)) {
              result |= testVector;
              System.out.println("Error in plus: Expected " + c2 + " + " + c1 
                               + " = " + expected_plus
                               + " Actual " + c2.plus(c1));
          }
          if(!c1.minus(c2).equals(expected_minus)) {
              result |= testVector;
              System.out.println("Error in minus: Expected " + c1 + " - " + c2 
                               + " = " + expected_minus
                               + " Actual " + c1.minus(c2));
          }
          if(!c1.times(c2).equals(expected_times)) {
              result |= testVector;
              System.out.println("Error in times: Expected " + c1 + " * " + c2 
                               + " = " + expected_times
                               + " Actual " + c1.times(c2));
          }
          if(!c2.times(c1).equals(expected_times)) {
              result |= testVector;
              System.out.println("Error in times: Expected " + c2 + " * " + c1 
                               + " = " + expected_times
                               + " Actual " + c2.times(c1));
          }
          if(!c1.divide(c2).equals(expected_divide)) {
              result |= testVector;
              System.out.println("Error in divide: Expected " + c1 + " / " + c2 
                               + " = " + expected_divide
                               + " Actual " + c1.divide(c2));
          }
          Complex c2_reciprocal = c2.reciprocal();
          if(!c1.times(c2_reciprocal).equals(expected_divide)) {
              result |= testVector;
              System.out.println("Error in times: Expected " + c1 + " * 1/" + c2 
                               + " = " + expected_divide
                               + " Actual " + c1.times(c2_reciprocal));
          }          
          testVector <<= 1;
        }

        // Test unary
        {
          if(c1.abs() != expected_abs_c1) {
              result |= testVector;
              System.out.println("Error in abs: Expected " + expected_abs_c1 
                               + " Actual " + c1.abs());
          }
          if(c2.abs() != expected_abs_c2) {
              result |= testVector;
              System.out.println("Error in abs: Expected " + expected_abs_c2 
                               + " Actual " + c2.abs());
          }
          if(c1.theta() != expected_theta_c1) {
              result |= testVector;
              System.out.println("Error in " + c1 + " theta: Expected " + expected_theta_c1 
                               + " Actual " + c1.theta());
          }
          if(c2.theta() != expected_theta_c2) {
              result |= testVector;
              System.out.println("Error in " + c2 + " theta: Expected " + expected_theta_c2 
                               + " Actual " + c2.theta());
          }
          if(!c1.scale(1.5).equals(expected_scale_c1)) {
              result |= testVector;
              System.out.println("Error in " + c1 + " scale(1.5): Expected " + expected_scale_c1 
                               + " Actual " + c1.scale(1.5));
          }
          if(!c2.scale(1.5).equals(expected_scale_c2)) {
              result |= testVector;
              System.out.println("Error in " + c2 + " scale(1.5): Expected " + expected_scale_c2
                               + " Actual " + c2.scale(1.5));
          }
          if(!c1.conjugate().equals(expected_conj_c1)) {
              result |= testVector;
              System.out.println("Error in " + c1 + " conjugate: Expected " + expected_conj_c1 
                               + " Actual " + c1.conjugate());
          }
          if(!c2.conjugate().equals(expected_conj_c2)) {
              result |= testVector;
              System.out.println("Error in " + c2 + " conjugate: Expected " + expected_conj_c2 
                               + " Actual " + c2.conjugate());
          }

          testVector <<= 1;
        }        

        // Test trigonometry
        {
          if(!c1.exp().equals(expected_exp_c1)) {
              result |= testVector;
              System.out.println("Error in " + c1 + " exp: Expected " + expected_exp_c1 
                               + " Actual " + c1.exp());
          }
          if(!c2.exp().equals(expected_exp_c2)) {
              result |= testVector;
              System.out.println("Error in " + c2 + " exp: Expected " + expected_exp_c2 
                               + " Actual " + c2.exp());
          }
          if(!c1.sin().equals(expected_sin_c1)) {
              result |= testVector;
              System.out.println("Error in " + c1 + " sin: Expected " + expected_sin_c1 
                               + " Actual " + c1.sin());
          }
          if(!c2.sin().equals(expected_sin_c2)) {
              result |= testVector;
              System.out.println("Error in " + c2 + " sin: Expected " + expected_sin_c2 
                               + " Actual " + c2.sin());
          }
          if(!c1.cos().equals(expected_cos_c1)) {
              result |= testVector;
              System.out.println("Error in " + c1 + " cos: Expected " + expected_cos_c1 
                               + " Actual " + c1.cos());
          }
          if(!c2.cos().equals(expected_cos_c2)) {
              result |= testVector;
              System.out.println("Error in " + c2 + " cos: Expected " + expected_cos_c2 
                               + " Actual " + c2.cos());
          }
          if(!c1.tan().equals(expected_tan_c1)) {
              result |= testVector;
              System.out.println("Error in " + c1 + " tan: Expected " + expected_tan_c1 
                               + " Actual " + c1.tan());
          }
          if(!c2.tan().equals(expected_tan_c2)) {
              result |= testVector;
              System.out.println("Error in " + c2 + " tan: Expected " + expected_tan_c2 
                               + " Actual " + c2.tan());
          }
          testVector <<= 1;
        }        
                   
        
        // Report final result
        if(result != 0) {
            System.out.println("\nFAIL: error code " + result);
            System.exit(result);
        }
    }
}
