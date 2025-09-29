import java.util.Scanner;

public class Rot13 {
    static final String key = "nopqrstuvwxyzabcdefghijklm";
    public String encode(String s) {
        String result = "";
        for(char c : s.toCharArray()) {
            if(c == ' ') {result += c; continue;}
            if('a' <= c && c <= 'z') {
                result += key.charAt(c-'a'); 
                continue;
            }
            throw new RuntimeException("Invalid char: " + c);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = in.nextLine();
        try {
            Rot13 rot13 = new Rot13();
            System.out.println(rot13.encode(s));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
