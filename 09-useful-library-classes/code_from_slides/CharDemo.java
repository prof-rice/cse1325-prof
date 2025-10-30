// Java 21 supports Unicode 15.0

import java.util.Scanner;

import java.io.File;

public class CharDemo {
    public static void main(String[] args) {
        try (Scanner file = new Scanner(new File("CharDemo.txt"))) {
            while(file.hasNextLine()) System.out.println(file.nextLine());
        } catch(Exception e) {
            System.err.println("CharDemo.txt is missing or corrupt!");
        }
        
        Scanner scanner = new Scanner(System.in);
        
        // Conversions between char, Character, and codepoint
        //   (most conversions between char and Character are handled by autoboxing)
        Character character = '0';                    // Construct a Character (NO constructor!)
        char   zero      = character;                     // convert Character to char (autoboxing!)
        Character zeroC  = zero;                          // convert char to Character (autoboxing!)
        int codepoint    = (int) zero;                    // cast    char to code point
        String zeroS     = character.toString();          // convert Character to String
        String zeros     = Character.toString(zero);      // convert char to String (or use +)
        String zeroz     = Character.toString(codepoint); // convert code point to String
        char[] zeroc     = Character.toChars(codepoint);  // convert code point to char
        System.out.println("Zero is "   + zero + " "  + codepoint + " " +
                            zeroS + " " + zeros + " " + zeroz     + " " +
                            zeroc[0]);

        // ALL of the methods demonstrated below (except digit and forDigit) 
        // work with char or codepoint!

        while(true) {
            System.out.print("\nEnter a code point (0 to 65535, leading 0x, U+, or \\u OK) or char: ");
            String s = scanner.nextLine().trim();
            
            // Obtain a codepoint from a String
            try {
                if(s.isEmpty()) { // exit
                    break;
                } else if(s.length() == 1) { // single char
                    codepoint = (int) s.charAt(0);
                } else if(s.length() > 2 &&  // check for hex code point
                    (s.startsWith("0x") || s.startsWith("U+") || s.startsWith("\\u"))) {
                    codepoint = Integer.parseInt(s.substring(2), 16);
                } else { // assume decimal code point
                    codepoint = Integer.parseInt(s);
                }
            } catch(Exception e) { // bad assumption - probably a 2-char supplemental code unit
                System.err.println("FAIL: Likely a supplemental character (won't fit in a char)\n" + e);
                continue;
            }
            
            // Determine if char or codepoint is a valid Unicode character
            String description = character.getName(codepoint); 
            if(description == null) description = "(no description)";
            System.out.printf("\nCodepoint U+%X (%d) '%s':\n", codepoint, codepoint, description);
            if(!Character.isDefined(codepoint)) {
                System.out.println("  Undefined");
                continue;
            }
            
            // Convert a codepoint into a Character
            character = (char) codepoint;
            
            // Identify a letter or digit
            if(Character.isLetterOrDigit(codepoint))
                System.out.println("  Is a letter or digit.");
            else
                System.out.println("  Is NOT a letter or digit: " + character);
            
            // Identify a digit, and if so, convert to a digit character in base 10 and 16
            if(Character.isDigit(codepoint)) {
                int base10 = Character.digit(codepoint, 10);
                int base16 = Character.digit(codepoint, 16);                
                System.out.print("  Is digit " + character);
                if(base10 != -1) System.out.print("  in decimal " + base10 + " " + Character.forDigit(codepoint, 10));
                if(base16 != -1) System.out.print(" in hex " + base16 + " " + Character.forDigit(codepoint, 16));
                System.out.println();
            } else { 
                System.out.println("  Is NOT a digit.");
            }
            
            // Identify a letter, and if so, if it's lower, upper, or title case - or other
            if(Character.isLetter(codepoint)) {
                System.out.print("  Is letter " + character);
                if(Character.isUpperCase(codepoint)) {
                    int lccp = Character.toLowerCase(codepoint);
                    char lc = Character.toChars(lccp)[0];
                    System.out.println("  (upper case - lower case is " +
                        lccp + " or " + lc + " )");
                } else if(Character.isLowerCase(codepoint)) {
                    int uccp = Character.toUpperCase(codepoint);
                    char uc = Character.toChars(uccp)[0];
                    System.out.println("  (lower case - upper case is " +
                        uccp + " or " + uc + " )");
                } else if(Character.isTitleCase(codepoint)) {
                    System.out.println("  (title case)");
                } else {
                    System.out.println("  (modifier or other )");
                }
            } else {
                System.out.println("  Is NOT a letter.");
            }
        }
    }
}
