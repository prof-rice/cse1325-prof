import static qlogger.Qlogger.log;
import java.io.PrintStream;

public class DemoQlogger {
    public static void main(String[] args) {
        // Enable logging only if the "--log" argument is specified
        if(args.length > 0 && args[0].equals("--log")) qlogger.Qlogger.enabled = true;
        else System.out.println("Add '--log' argument to see logged messages");
        
        // Log to the console by default
        log("This is a logged message");
        System.out.println("This is a normal message");
        
        // Log to a file
        try(PrintStream out = new PrintStream("errors.log")) {
            qlogger.Qlogger.out = out;
            log("This logged message should go to file errors.log");
            if(qlogger.Qlogger.enabled) System.out.println("Check file errors.log!");
        } catch(Exception e) {
            System.err.println("Log to file errors.log failed\n" + e);
        }
   }
}
