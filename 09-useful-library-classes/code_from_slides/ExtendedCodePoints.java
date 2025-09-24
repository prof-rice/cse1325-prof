public class ExtendedCodePoints {
    public static void main(String[] args) {
        int codePoint = 0x1F600; // Grinning Face emoji
        String s = new String(Character.toChars(codePoint));
        System.out.println(s);
    }
}
