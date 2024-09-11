import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class Phone {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(\\d{3,3}-)?\\d{3,3}-\\d{4,4}");
        System.out.println("Enter 7- or 10-digit phone number:");
        while(in.hasNextLine()) {
            String phone = in.nextLine();
            if(pattern.matcher(phone).matches())
                System.out.println("Dialing " + phone);
            else
                System.err.println(phone + " is not a valid phone number!");
        }
    }
}

