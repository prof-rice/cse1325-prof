package complex;

import java.math.BigInteger;
import java.math.BigDecimal;

class CalcDouble implements Calc<Double> {
    public Double add(Double a, Double b) {
        return a + b;
    }
    public Double fromDouble(double d) {
        return d;
    }
    public double toDouble(Double a) {
        return a;
    }
} 

class CalcInt implements Calc<Integer> {
    public Integer add(Integer a, Integer b) {
        return a + b;
    }
    public Integer fromDouble(double d) {
        return (int) Math.round(d);
    }
    public double toDouble(Integer a) {
        return (double) a;
    }
} 

class CalcBigInt implements Calc<BigInteger> {
    public BigInteger add(BigInteger a, BigInteger b) {
        return a.add(b);
    }
    public BigInteger fromDouble(double d) {
        return BigDecimal.valueOf(d).toBigInteger();
    }
    public double toDouble(BigInteger a) {
        return a.doubleValue();
    }
} 

public class Calculations {
    public static void main(String[] args) {
        CalcDouble calcDouble = new CalcDouble();
        Complex<Double> d1 = new Complex<>(2.0, -1.0, calcDouble);
        Complex<Double> d2 = new Complex<>(1.0,  5.0, calcDouble);
        System.out.println(d1.add(d2) + " magnitude is " + d1.add(d2).magnitude());

        CalcInt calcInt = new CalcInt();
        Complex<Integer> i1 = new Complex<>(2, -1, calcInt);
        Complex<Integer> i2 = new Complex<>(1,  5, calcInt);
        System.out.println(i1.add(i2) + " magnitude is " + i1.add(i2).magnitude());
        
        CalcBigInt calcBigInt = new CalcBigInt();
        Complex<BigInteger> b1 = new Complex<>(BigInteger.valueOf(2), BigInteger.valueOf(-1), calcBigInt);
        Complex<BigInteger> b2 = new Complex<>(BigInteger.valueOf(1), BigInteger.valueOf( 5), calcBigInt);
        System.out.println(b1.add(b2) + " magnitude is " + b1.add(b2).magnitude());

        Complex<BigInteger> b3 = new Complex<>(new BigInteger("200000000000000000000"), 
                                               new BigInteger("-100000000000000000000"), 
                                               calcBigInt);
        Complex<BigInteger> b4 = new Complex<>(new BigInteger("100000000000000000000"), 
                                               new BigInteger("500000000000000000000"), 
                                               calcBigInt);
        System.out.println(b3.add(b4) + " magnitude is " + b3.add(b4).magnitude());
    }
}
