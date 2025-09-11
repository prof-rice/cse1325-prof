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
 *  Eliza key.
 *  A key has the key itself, a rank, and a list of decompositon rules.
 */
public class Key {
    /** The key itself */
    String key;
    /** The numerical rank */
    int rank;
    /** The list of decompositions */
    DecompList decomp;

    /**
     *  Initialize the key.
     */
    Key(String key, int rank, DecompList decomp) {
        this.key = key;
        this.rank = rank;
        this.decomp = decomp;
    }

    /**
     *  Another initialization for gotoKey.
     */
    Key() {
        key = null;
        rank = 0;
        decomp = null;
    }

    public void copy(Key k) {
        key = k.key();
        rank = k.rank();
        decomp = k.decomp();
    }

    /**
     *  Print the key and all under it.
     */
    public void print(int indent) {
        for (int i = 0; i < indent; i++) System.out.print(" ");
        System.out.println("key: " + key + " " + rank);
        decomp.print(indent+2);
    }

    /**
     *  Print the key and rank only, not the rest.
     */
    public void printKey(int indent) {
        for (int i = 0; i < indent; i++) System.out.print(" ");
        System.out.println("key: " + key + " " + rank);
    }

    /**
     *  Get the key value.
     */
    public String key() {
        return key;
    }

    /**
     *  Get the rank.
     */
    public int rank() {
        return rank;
    }

    /**
     *  Get the decomposition list.
     */
    public DecompList decomp() {
        return decomp;
    }
}

