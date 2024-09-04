public class StringDemo {
    public static void main(String[] args) {
        // Special case for initialization of Strings, but could use
        //   String s = new String("I am a Java programmer!");
        String s = "I am a Java programmer!";
        
        // Java 16+ includes Text Blocks for initializating multiline String objects.
        // Note the use of triple-double-quotes to encode the sentence.
        /*
        String humpty = """
                        "When I use a word," Humpty Dumpty said,
                        in rather a scornful tone, "it means just what I
                        choose it to mean - neither more nor less." """;
        System.out.println(humpty);
        */
        // Special case for concatenating String objects using +, but could use
        //     s.concat(" characters");
        // The length() method returns the number of characters in the String
        System.out.println("'" + s + "' is " + s.length() + " characters");

        // We can do a lot of comparisons using String methods!
        String first = "george";
        String last = "rice";
        if(first.startsWith("ge")) System.out.println(first + " starts with ge");
        if(first.endsWith("ge")) System.out.println(first + " ends with ge, too!");
        
        // Integer.signum returns -1 if negative, 1 if positive, or 0 otherwise
        // Alternately, we could do this:
        //   String[] compares = {" less than ", " equal to ", " greater than "};
        //   String compared = compares[Integer.signum(first.compareTo(last))+1];
        //   System.out.println(first + " is" + compared + last);
        String compared = " equals ";
        if (first.compareTo(last) < 0) compared = " is less than ";
        else if (first.compareTo(last) > 0) compared = " is greater than ";
        System.out.println(first + compared + last + " (considering case)");

        // We can also ignore case
        String sarcasm = "GeOrGe";
        compared = " equals ";
        if (sarcasm.compareTo(first) < 0) compared = " is less than ";
        else if (sarcasm.compareTo(first) > 0) compared = " is greater than ";
        System.out.println(sarcasm + compared + first + " (considering case)");

        // We could also use first.equals(last) and first.equalsIgnoreCase(sarcasm)
        if(first.equalsIgnoreCase(sarcasm))
            System.out.println(first + " equalsIgnoreCase " + sarcasm);
     
        // In addition to using System.printf, you can format a String variable
        // If portability is important, use System.lineSeparator() instead of '\n'
        //    This returns '\n' for Linux, '\r\n' for Windows, '\r' for Mac
        String format = "I am %d years old!" + System.lineSeparator();
        int age = 25;
        String s2 = String.format(format, age);
        System.out.print(s2);
        
        // Use valueOf to convert a string to a numeric class type
        String sage = "37";
        age = Integer.valueOf(sage);
        System.out.printf(format, age);
        
        // We can iterate over a String's chars using toCharArray()        
        // Note that a Java char only covers the most common 65,536 code points (ahem)
        //   of the 143,859 characters defined as of July 2021. 
        //   Handling the other code points is unfortunately hard in Java,
        //   and fortunately will NOT be on the exam.
        for(char c : sage.toCharArray()) System.out.print(c + System.lineSeparator());
        
        // Alternately, we can access characters with an index
        for(int i=0; i<sage.length(); ++i) System.out.print(sage.charAt(i) + System.lineSeparator());
        
        // We can also take substrings starting at the first index
        //   and (optionally) ending at the last index-1
        System.out.println(s.substring(5) + " " + s.substring(0, 4));
        
        // We can remove whitespace from both ends of the String and convert 
        //   to upper (toUpperCase) or lower (toLowerCase) case
        // (Whitespace in between words is ignored)
        String spacey = "  I do object-oriented!   \n";
        System.out.println(spacey.trim() + " I said, " + spacey.trim().toUpperCase());
        
        // Searching within a String is also supported
        System.out.println("In '" + s + "', 'Java' starts at " + s.indexOf("Java"));
        System.out.println("The last 'am' in '" + s + "' starts at " + s.lastIndexOf("am"));
        String filename = "Readme.txt";
        int dot = filename.lastIndexOf(".");
        System.out.println("In " + filename 
            + ", the name is '" + filename.substring(0, dot)
            + "' and the extension is '" + filename.substring(dot+1) + "'");

        // We can also split a String into an array around a given character or pattern
        //   (We'll briefly discuss patterns shortly)
        // String sep is an Old Programmer's Trick for inserting commas between list elements
        String pathname = "/home/ricegf/Documents/resume.odt";
        System.out.print("In " + pathname + ", the directories and filename are \n  ");
        String sep = "'";
        for(String dir : pathname.split("/")) {
            System.out.print(sep + dir);
            sep = "', '";
        }
        System.out.println("'");
        
        // Or we can replace a substring
        System.out.println(s.replace("Java", "good"));
        
        // We don't insert strings into a String, though - it's easier to split and concat instead
        
    }
}
