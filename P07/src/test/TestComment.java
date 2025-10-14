package test;

import rating.Comment;

import people.Person;

public class TestComment {
    private static int result = 0;
    private static int vector = 1;
    private static String expected = "";
    private static String actual = "";
    
    private static void checkResults(String description) {
        if(!actual.equals(expected)) {
            System.err.println("FAIL: " + description);
            System.err.println("  Expected: " + expected);
            System.err.println("  Actual:   " + actual);
            result |= vector;
        }
    }
    private static void nextVector() {
        vector <<= 1;
    }
    public static void main(String[] args) {
        try {
            Person p1 = new Person("Charlie Brown", "cb@aol.com");
            Person p2 = new Person("Lucy van Pelt", "curmudgen@gmail.com");
            Person p3 = new Person("PigPen", "iheartdirt@proton.me");
        
            // Nominal case
            Comment c1 = new Comment("Hello, World", p1, null);
            expected = "Comment by Charlie Brown (cb@aol.com)\nHello, World";
            actual = c1.toString();
            checkResults("Nominal Case");
            nextVector();
        
            // Data validation
            expected = "IllegalArgumentException";
            actual = "No exception";
            try {
                Comment c2 = new Comment("", p2, null);
                checkResults("Failed to detect empty text");
            } catch(IllegalArgumentException e) {
            }
            try {
                Comment c2 = new Comment(null, p2, null);
                checkResults("Failed to detect null text");
            } catch(IllegalArgumentException e) {
            }
            try {
                Comment c2 = new Comment("test", null, null);
                checkResults("Failed to detect null Person");
            } catch(IllegalArgumentException e) {
            }
            nextVector();
            
            // Replies
            c1.addReply("Hello, Blockhead", p2);
            Comment c1r0 = c1.getReply(0);
            c1.addReply("Hello, Charlie Brown", p3);
            Comment c1r1 = c1.getReply(1);
            
            expected = "2";
            actual = "" + c1.numReplies();
            checkResults("Incorrect number of replies");
            
            expected = "Comment by Lucy van Pelt (curmudgen@gmail.com) in reply to Charlie Brown (cb@aol.com)\nHello, Blockhead";
            actual = c1r0.toString();
            checkResults("Incorrectly created reply 0");
            
            expected = "c1 in reply to c0";
            actual = "invalid";
            if(c1r1.getInReplyTo() != c1) checkResults("Invalid inReplyTo");
            
            expected = "Comment by Charlie Brown (cb@aol.com)\nReplies: (0) Lucy van Pelt     (1) PigPen\nHello, World";
            actual = c1.toString();
            checkResults("Incorrect comment with 2 replies");
            
        } catch(Exception e) {
            System.err.println("PANIC: Unexpected exception at vector " + vector);
            e.printStackTrace();
        }
        
        if(result != 0) System.err.println("\nFAIL: Result code " + result);
        System.exit(result);
    }
}
