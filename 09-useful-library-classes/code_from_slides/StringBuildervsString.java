import java.util.Random;

// This program compares two methods of reversing a string
//   sc - using concatenation to a new string
//   sb - using StringBuilder.reverse()

class StringBuilderVsString {
    // Reverse using String concatenation in a loop
    static String ReverseWithNewString(String s) {
        String result = "";
        for(char c : s.toCharArray()) result = c + result;
        return result;
    }
    
    // Reverse by converting to StringBuilder, reverse(), and toString()
    static String ReverseWithStringBuilder(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString(); // Look - method chaining!
        // OR return (new StringBuilder(s)).reverse().toString();
    }
    public static void main(String[] args) {
        Random random = new Random();
        
        // Get number of chars (default 1000)
        if(args.length > 1) {
            System.err.println(
                "usage: java StringBuilderVsString [#chars]");
            System.exit(-1);
        }
        int size = (args.length > 0) 
                 ? Integer.parseInt(args[0]) 
                 : 1000;
    
        // Create really big String
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; ++i) 
            sb.append((char)(random.nextInt(26) + 'a'));
        String s = sb.toString();
        // System.out.println(s);
        
        // Try using String concatenation
        long scStartTime = System.nanoTime();
        String scString = ReverseWithNewString(s);
        long scElapsedTime = System.nanoTime() - scStartTime;

        // Try using StringBuilder
        long sbStartTime = System.nanoTime();
        String sbString = ReverseWithStringBuilder(s);
        long sbElapsedTime = System.nanoTime() - sbStartTime;

        // Print results
        if(!sbString.equals(scString))
            System.err.println("Reversed string mismatch!"
                + "\n  sb = " + sbString
                + "\n  sc = " + scString);
        System.out.printf("String concatenation took %12d nanoseconds\n", 
               scElapsedTime);
        System.out.printf("StringBuilder        took %12d nanoseconds\n",  
               sbElapsedTime);
        System.out.println(
            ((scElapsedTime < sbElapsedTime) 
                 ? "String concatenation is faster by "
                 : "StringBuilder is faster by ")
          + 100 * Math.abs(scElapsedTime - sbElapsedTime)
            / Long.min(scElapsedTime, sbElapsedTime)
          + "%"
        );
    }
}
