import static qlogger.Qlogger.log;
import java.io.PrintStream;

public class TestQlogger {
    public static void main(String[] args) {
        if(args.length > 0 && args[0].equals("--log")) qlogger.Qlogger.enabled = true;
        else System.out.println("Add '--log' argument to see logged messages");
        
        log("This is a logged message");
        System.out.println("This is a normal message");
        
        try(PrintStream out = new PrintStream("errors.log")) {
            qlogger.Qlogger.out = out;
            log("This logged message should go to file errors.log");
        } catch(Exception e) {
            System.err.println("Log to file errors.log failed\n" + e);
        }
   }
}
