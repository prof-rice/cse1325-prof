import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class Regex {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println("usage: java Regex [text] [regex]"); 
            System.exit(-1);
        }
        String text = args[0];
        String regex = args[1];
        
        System.out.println(text);
        int pos = 0;
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            while(matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                int len = end - start;
                System.out.print(" ".repeat(start - pos) + "^");
                if(len > 2) System.out.print("-".repeat(len-2));
                if(len > 1) System.out.print("^");
                pos = end;
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Cannot match " + regex + " to this:\n" + text + "\n---\n" + e.getMessage());
        } finally {
            System.out.println();
        }
    }
}            
                
/*       
        
        
        String format = "Found '%s' at (%d, %d]\n";
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            while(matcher.find()) {
                System.out.printf(format, matcher.group(), 
                                  matcher.start(), matcher.end());
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Cannot match " + regex + " to this:\n" + text + "\n---\n" + e.getMessage());
        }
    }
}
*/
