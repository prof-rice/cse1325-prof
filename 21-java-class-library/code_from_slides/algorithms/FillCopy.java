import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class FillCopy {
    public static void main(String[] args) {
        if(args.length == 0) System.err.println("Provide some arguments to copy!");
        List<String> argList = Arrays.asList(args);                  // argList size can't be modified

        List<String> etc = new ArrayList<>(argList);                 // construct COPY of argList into etc
        Collections.fill(etc, "etc");                                // fill etc with "etc"
        Collections.copy(etc, argList.subList(0,argList.size()/2));  // copy first half of argList into etc
        Printer.print(etc);
    }
}
