public class TestCard {
    public static void main(String[] args) {
        int result = 0;
        int vector = 1;
        
        // Test Vector 1: Normal case
        String term = "term";
        String definition = "definition";
        Card card = new Card(term, definition);
        if(!card.toString().equals(definition)) {
            result |= vector;
            System.err.println("FAIL: Definition doesn't match toString");
        }
        if(!card.attempt(term) || card.attempt(definition)) {
            result |= vector;
            System.err.println("FAIL: attempt(term) doesn't return true");
        }
        if(!card.getTerm().equals(term)) {
            result |= vector;
            System.err.println("FAIL: getTerm() doesn't match term");
        }
        vector <<= 1;
        
        // Test Vector 2: Case-insensitive attempt
        String termMixed = "TeRm";
        if(!card.attempt(termMixed)) {
            result |= vector;
            System.err.println("FAIL: attempt(term) isn't case-insensitive");
        }
        vector <<= 1;

        // Test Vector 3: Invalid constructor parameters
        try {
            Card c2 = new Card("", definition);
            result |= vector;
            System.err.println("FAIL: No exception on empty constructor string");
        } catch(Exception e) {
        }
        try {
            Card c2 = new Card(term, null);
            result |= vector;
            System.err.println("FAIL: No exception on null constructor parameter");
        } catch(Exception e) {
        }
        
        // If any failures, report result to STDERR and to the OS
        if(result != 0) {
            System.err.println("FAIL: Result code = " + result);
            System.exit(result);
        }
    }
}
