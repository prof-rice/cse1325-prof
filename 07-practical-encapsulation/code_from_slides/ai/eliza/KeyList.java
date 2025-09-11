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
 *  Eliza key list.
 *  This stores all the keys.
 */
public class KeyList extends ArrayList {

    /**
     *  Add a new key.
     */
    public void add(String key, int rank, DecompList decomp) {
        add(new Key(key, rank, decomp));
    }

    /**
     *  Print all the keys.
     */
    public void print(int indent) {
        for (int i = 0; i < size(); i++) {
            Key k = (Key) get(i);
            k.print(indent);
        }
    }

    /**
     *  Search the key list for a given key.
     *  Return the Key if found, else null.
     */
    Key getKey(String s) {
        for (int i = 0; i < size(); i++) {
            Key key = (Key) get(i);
            if (s.equals(key.key())) return key;
        }
        return null;
    }

    /**
     *  Break the string s into words.
     *  For each word, if isKey is true, then push the key
     *  into the stack.
     */
    public void buildKeyStack(KeyStack stack, String s) {
        stack.reset();
        s = EString.trim(s);
        String lines[] = new String[2];
        Key k;
        while (EString.match(s, "* *", lines)) {
            k = getKey(lines[0]);
            if (k != null) stack.pushKey(k);
            s = lines[1];
        }
        k = getKey(s);
        if (k != null) stack.pushKey(k);
        //stack.print();
    }
}
