public class ByteArray {
    public static void main(String[] args) {
        byte[] text = {'H', 'e', 'l', 'l', 'o'};
        // WARNING: Casting a byte to a char only works for ASCII!
        for(byte b : text) System.out.print((char) b);
    }
}
