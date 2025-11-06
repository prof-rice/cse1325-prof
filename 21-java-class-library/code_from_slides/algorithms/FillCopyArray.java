import java.util.Arrays;

public class FillCopyArray {
    public static void main(String[] args) {
        if(args.length == 0) System.err.println("Provide some arguments to copy!");
        
        String[] etc = new String[args.length];
        System.arraycopy(args, 0, etc, 0, args.length);              // Copy args to etc

        Arrays.fill(etc, etc.length / 2, etc.length, "etc");       // Fill last half with "etc"
        Printer.print(etc);
    }
}
