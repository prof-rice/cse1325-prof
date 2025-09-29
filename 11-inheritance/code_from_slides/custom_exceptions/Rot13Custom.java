import java.util.Scanner;

class Rot13CharException extends IllegalArgumentException {
    // Standard constructors
    public Rot13CharException() {super();}
    public Rot13CharException(String message) {super(message);}
    public Rot13CharException(Throwable err) {super(err);}
    public Rot13CharException(String message, Throwable err) {super(message,err);}
    // Custom constructor
    public Rot13CharException(String input, String encoded, char bad) {
        super("Invalid character '" + bad 
            + "' at index " + encoded.length()
            + " in '" + input + "'");
    }
}

public class Rot13Custom {
    static final String key = "nopqrstuvwxyzabcdefghijklm";
    public String encode(String s) {
        String result = "";
        for(char c : s.toCharArray()) {
            if(c == ' ') {result += c; continue;}
            if('a' <= c && c <= 'z') {
                result += key.charAt(c-'a'); 
                continue;
            }
            // throw new RuntimeException("Invalid char: " + c);
            throw new Rot13CharException(s, result, c);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = in.nextLine();
        try {
            Rot13Custom rot13 = new Rot13Custom();
            System.out.println(rot13.encode(s));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
