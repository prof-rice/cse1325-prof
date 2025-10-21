public class AbsoluteShocker {
    public static void main(String[] args) {
        for(int i=Integer.MIN_VALUE; i <= Integer.MAX_VALUE; ++i) 
            if(Math.abs(i) < 0) System.err.println("Negative ABS! ");
    }
}
