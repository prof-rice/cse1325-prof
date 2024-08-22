import java.text.DecimalFormat;

class Formatter { 
    public static void main(String args[])  {
        String s;            // the format string
        double i = 12345.6;  // the number to show
        System.out.println("\n" + i + "\n----------");

        // 6-digit integer (will show actual number of digits, though)
        s = "######";
        DecimalFormat form = new DecimalFormat(s);
        System.out.println(s + " => " + form.format(i));
        
        // 6-digit integer with leading zeroes
        s = "000000";
        form = new DecimalFormat(s);
        System.out.println(s + " => " + form.format(i));
        
        // 4 digits and 2 decimals, zero filled
        s = "0000.00";
        form = new DecimalFormat(s);
        System.out.println(s + " => " + form.format(i));

        // Up to 2 decimal digits
        i = 12345.678;
        System.out.println("\n" + i + "\n----------");

        System.out.println(s + " => " + form.format(i));

        s = "######.######";
        form = new DecimalFormat(s);
        System.out.println(s + " => " + form.format(i));
        
        s = "#####0.000000";
        form = new DecimalFormat(s);
        System.out.println(s + " => " + form.format(i));
        
        // Scientific notation (note that exponent must be 0s, not #s)
        s = "0.##E00";
        form = new DecimalFormat(s);
        System.out.println(s + " => " + form.format(i));

        // Engineering notation (exponent always a multiple of 3)
        s = "##0.##E00";
        form = new DecimalFormat(s);
        System.out.println(s + " => " + form.format(i));

        // Currency formats with (US) digit groupings
        s = "$###,###.00";
        form = new DecimalFormat(s);
        System.out.println(s + " => " + form.format(i));

        // Accounting formats (negatives in parentheses)
        s = "$###,###.00;($###,###.00)";
        form = new DecimalFormat(s);
        System.out.println(s + " => " + form.format(i));
        
        i = -12345.678;
        System.out.println("\n" + i + "\n----------");
        
        System.out.println(s + " => " + form.format(i));

     } 
} 
