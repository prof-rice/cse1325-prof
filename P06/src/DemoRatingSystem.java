public class DemoRatingSystem {
    private static void printIndented(String multiline, int level) {
        String[] strings = multiline.split("\n");
        for(String s : strings) 
            System.out.println("  ".repeat(level) + s);
    }
    private static void printExpandedComments(Comment c, int level) {
        printIndented(c.toString(), level);
        System.out.println("\n");
        for(int i=0; i<c.numReplies(); ++i)
            printExpandedComments(c.getReply(i), level+1);
    }
    public static void main(String[] args) {
        try {
            // Demo all 5 star ratings with no comment
            System.out.println("\nRatings\n=======\n");
            for(int r=1; r<=5; ++r) {
                Rating rating = new Rating(r, null);
                System.out.println("For " + r + "-star: " + rating);
            }
            System.out.println("\n\nNested comments\n===============\n");
            
            // Those involved in the conversation
            Person charlie = new Person("Charlie Brown", "cb@aol.com");
            Person lucy    = new Person("Lucy van Pelt", "curmudgen@gmail.com");
            Person pigpen  = new Person("PigPen", "iheartdirt@proton.me");
            Person snoopy  = new Person("Snoopy", "doghouse@theyard.org");
            
            // The conversation
            Comment c0 = new Comment("Hello, Peanuts! I ❤️  U!", charlie, null);
            c0.addReply("You're a Blockhead, Charlie Brown", lucy);
            c0.addReply("Woof!", snoopy);
            c0.addReply("Thank you, Charlie Brown!", pigpen);
            
            Comment c1 = c0.getReply(0);
            c1.addReply("Be nice, Lucy!", pigpen);
            c1.addReply("Grrrr", snoopy);
            
            Comment c2 = c1.getReply(1);
            c2.addReply("Down, boy!", lucy);

            // Print the conversation
            printExpandedComments(c0, 0);
        } catch(Exception e) {
            System.err.println("PANIC: Aborted on the following exception");
            e.printStackTrace();
        }
    }
}
