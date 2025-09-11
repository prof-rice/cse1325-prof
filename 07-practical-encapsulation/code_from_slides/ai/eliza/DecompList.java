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

import java.util.ArrayList;

/**
 *  Eliza decomp list.
 *  This stores all the decompositions of a single key.
 */
public class DecompList extends ArrayList {

    /**
     *  Add another decomp rule to the list.
     */
    public void add(String word, boolean mem, ReasembList reasmb) {
        add(new Decomp(word, mem, reasmb));
    }

    /**
     *  Print the whole decomp list.
     */
    public void print(int indent) {
        for (int i = 0; i < size(); i++) {
            Decomp d = (Decomp) get(i);
            d.print(indent);
        }
    }
}

