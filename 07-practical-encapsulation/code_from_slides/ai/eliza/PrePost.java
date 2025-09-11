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
 *  Eliza pre-post entry (two words).
 *  This is used to store pre transforms or post transforms.
 */
public class PrePost {
    /** The words */
    String src;
    String dest;

    /**
     *  Initialize the pre-post entry.
     */
    PrePost(String src, String dest) {
        this.src = src;
        this.dest = dest;
    }

    /**
     *  Print the pre-post entry.
     */
    public void print(int indent) {
        for (int i = 0; i < indent; i++) System.out.print(" ");
        System.out.println("pre-post: " + src + "  " + dest);
    }

    /**
     *  Get src.
     */
    public String src() {
        return src;
    }

    /**
     *  Get dest.
     */
    public String dest() {
        return dest;
    }
}

