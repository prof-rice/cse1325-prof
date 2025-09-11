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
 *  Eliza word list.
 */
public class WordList extends ArrayList {

    /**
     *  Add another word to the list.
     */
    public void addWord(String word) {
        add(word);
    }

    /**
     *  Print a word list on one line.
     */
    public void print(int indent) {
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i).toString() + "  ");
        }
        System.out.println();
    }

    /**
     *  Find a string in a word list.
     *  Return true if the word is in the list, false otherwise.
     */
    boolean find(String s) {
        for (int i = 0; i < size(); i++) {
            if (s.equals(get(i).toString())) return true;
        }
        return false;
    }

}

