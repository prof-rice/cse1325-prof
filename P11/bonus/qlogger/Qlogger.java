package qlogger;

/**
 * Trivial logger to System.err or a file.
 *
 * Logging is disabled until Qlogger.enabled is set to true.
 *
 * To redirect output to a file, set Qlogger.out to a PrintStream instance.
 *
 * @author             Professor George F. Rice
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
public class Qlogger {
    /**
     * Logging is disabled when this field is false (default).
     */
    public static boolean enabled = false;
    /**
     * Destination for the logged messages (System.err by default).
     */
    public static java.io.PrintStream out = System.err;
    /**
     * Logs the String to the current PrintStream, if enabled.
     *
     * @param s  the nessage to be logged
     * @since          1.0
     */
    public static void log(String s) {if(enabled) out.println(s);}
}
