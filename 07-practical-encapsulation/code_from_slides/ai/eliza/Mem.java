package eliza;

// This work is in the public domain. 
// No copyright is claimed by the original author or by me.

// Based on ELIZA as described by Joseph Weizenbaum 
//   in Communications of the ACM, January 1966.

// Ported to a Java Applet by Charles Hayden. 
//   http://chayden.net/Index.shtml
//   "A complete and faithful implementation of the program 
//    described by Weizenbaum"
//   "You are welcome to make use of it however you want."

// Lightly modified for the command line by Professor George F. Rice. 
//   https://github.com/prof-rice/Eliza

/**
 *  Eliza memory class
 */

public class Mem {

    /** The memory size */
    final int memMax = 20;
    /** The memory */
    String memory[] = new String[memMax];
    /** The memory top */
    int memTop = 0;

    public void save(String str) {
        if (memTop < memMax) {
            memory[memTop++] = new String(str);
        }
    }

    public String get() {
        if (memTop == 0) return null;
        String m = memory[0];
        for (int i = 0; i < memTop-1; i++)
            memory[i] = memory[i+1];
        memTop--;
        return m;
    }
}


