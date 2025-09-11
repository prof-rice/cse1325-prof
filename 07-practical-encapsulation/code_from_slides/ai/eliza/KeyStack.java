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
 *  A stack of keys.
 *  The keys are kept in rank order.
 */
public class KeyStack {

    /** The stack size */
    final int stackSize = 20;
    /** The key stack */
    Key keyStack[] = new Key[stackSize];
    /** The top of the key stack */
    int keyTop = 0;

    /**
     *  Prints the key stack.
     */
    public void print() {
        System.out.println("Key stack " + keyTop);
        for (int i = 0; i < keyTop; i++) {
            keyStack[i].printKey(0);
        }
    }

    /**
     *  Get the stack size.
     */
    public int keyTop() {
        return keyTop;
    }

    /**
     *  Reset the key stack.
     */
    public void reset() {
        keyTop = 0;
    }

    /**
     *  Get a key from the stack.
     */
    public Key key(int n) {
        if (n < 0 || n >= keyTop) return null;
        return keyStack[n];
    }

    /**
     *  Push a key in the stack.
     *  Keep the highest rank keys at the bottom.
     */
    public void pushKey(Key key) {
        if (key == null) {
            System.out.println("push null key");
            return;
        }
        int i;
        for (i = keyTop; i > 0; i--) {
            if (key.rank > keyStack[i-1].rank) keyStack[i] = keyStack[i-1];
            else break;
        }
        keyStack[i] = key;
        keyTop++;
    }


}
