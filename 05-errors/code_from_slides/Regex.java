import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
  public static void main(String[] args) {
    Pattern pattern = Pattern.compile(args[0], Pattern.CASE_INSENSITIVE);
    for(int i=1; i<args.length; ++i) {
        Matcher matcher = pattern.matcher(args[i]);
        if(matcher.find())
            System.out.println("Match found in " + args[i]);
    }
  }
}
