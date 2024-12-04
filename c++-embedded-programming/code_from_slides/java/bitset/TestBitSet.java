import java.util.BitSet;

class TestBitSet {
    public static final int SIZE = 20;

    private static String toString(BitSet bs) {
        return toString(bs, SIZE);
    }
    private static String toString(BitSet bs, int size) {
        char[] chars = new char[size];
        for(int i=0; i<size; ++i) 
            chars[size-i-1] = (bs.get(i) ? '1' : '0');
        return new String(chars); 
    }
    public static void main(String[] args) {
        String scale = "|------|";
        for(int i=0; i<4; ++i) scale += scale;
        System.out.println("                " 
                         + scale.substring(scale.length()-SIZE));
    
        BitSet bs = new BitSet(SIZE);
        System.out.println(SIZE + "-bit BitSet:  " + toString(bs));
        System.out.println("Size   = " + bs.size()
                         + " (number of bits allocated, by 64)");
        System.out.println("Length =  " + bs.length()
                         + " (position of last '1')\n");     
    
        bs.set(0, SIZE);
        System.out.println("All bits set:   " + toString(bs));
    
        bs.clear();
        System.out.println("All bits clear: " + toString(bs));
    
        bs.set(8,16);
        System.out.println("2nd byte set:   " + toString(bs));
    
        for(int i=0; i<SIZE; i+=2) bs.flip(i);
        System.out.println("Even bits flip: " + toString(bs));
        System.out.println("Cardinality = " + bs.cardinality() 
                         + " (number of set bits)");

        System.out.println("\n                " 
                         + scale.substring(scale.length()-SIZE));    
        BitSet mask = new BitSet(SIZE);
        for(int i=0; i<SIZE; i+=3) mask.set(i);
        System.out.println("Orig bitset:    " + toString(bs));
        System.out.println("Mask bitset:    " + toString(mask));
        bs.xor(mask);
        System.out.println("Orig.xor(Mask): " + toString(bs) 
                         + " (0^0 and 1^1 = 0, 0^1 and 1^0 = 1\n");
    
        bs.set(64);
        System.out.println("                " 
                         + scale.substring(scale.length()-bs.length()));
        
        System.out.println("Set bit 64:     " + toString(bs, bs.length()));
        System.out.println("Size = " + bs.size());
        System.out.println("Length = " + bs.length());     
    }
}
