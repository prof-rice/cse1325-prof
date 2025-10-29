import java.math.BigInteger;

public class TestABigInt {
    public static void main(String[] args) {
        // This code will generate an "integer number too large" error (uncomment and see!)
        // long trillionth_prime = 29_996_224_275_833;
        // System.out.println(trillionth_prime);
        
        BigInteger bi = new BigInteger("29996224275833");
        System.out.println(bi);
    }
}
