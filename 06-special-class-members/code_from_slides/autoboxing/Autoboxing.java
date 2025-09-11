public class Autoboxing {
  private static int doubleIt(int i) {
    Integer two = 2;
    // Integer * int -> int
    return two * i; 
  }

  private static double toGradians(double radians) {
    double scale = 10.0/9.0;
    // double -> Double
    Double degrees = Math.toDegrees(radians);
    // double * Double -> double
    return scale * degrees; 
  }

  public static void main(String[] args) {
    Integer i = 42; 
    // or = new Integer(42); (deprecated)

    // Integer -> int -> Integer
    i = doubleIt(i); 
    System.out.println(i);

    // double -> Double        
    Double radians = Math.PI;
    // Double -> double -> Double
    Double gradians = toGradians(radians);
    System.out.println(gradians);
  }
}
