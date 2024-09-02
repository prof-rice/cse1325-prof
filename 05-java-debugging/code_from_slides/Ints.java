import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ints {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Pattern pattern = Pattern.compile("^-?\\d+$");
    System.out.println("Enter some integers:");
    while(in.hasNextLine()) {
        Matcher matcher = pattern.matcher(in.nextLine());
        if(matcher.find())
            System.out.println("That's an int!");
        else
            System.out.println("### INVALID INPUT ###");
    }
  }
}
