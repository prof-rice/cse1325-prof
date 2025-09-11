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
 *  Eliza reassembly list.
 */
public class ReasembList extends ArrayList {

    /**
     *  Add an element to the reassembly list.
     */
    public void addReassembly(String reasmb) {
        add(reasmb);
    }

    /**
     *  Print the reassembly list.
     */
    public void print(int indent) {
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < indent; j++) System.out.print(" ");
            System.out.println("reasemb: " + get(i));
        }
    }
}

