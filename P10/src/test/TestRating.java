package test;

import rating.Rating;
import rating.Comment;

import people.Person;

public class TestRating {
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
            // Check all 5 star ratings with no comment
            String[] ratings = {"★☆☆☆☆", "★★☆☆☆", "★★★☆☆", "★★★★☆", "★★★★★"};
            for(int r=1; r<=5; ++r) {
                Rating r1 = new Rating(r, null);
                expected = ratings[r-1];
                actual = r1.toString();
                checkResults("Invalid " + r + "-star rating");
                
                if(r1.getStars() != r) {
                    expected = "getStars() == " + r;
                    actual = "getStars() == " + r1.getStars();
                    checkResults("Unable to retrieve stars");
                }
            }
            nextVector();
            
            // Rating with comment
            Person p1 = new Person("Charlie Brown", "cb@aol.com");
            Comment c1 = new Comment("Hello, World", p1, null);
            Rating r1 = new Rating(3, c1);
            expected = "Retrieve review";
            actual = "Different review";
            if(r1.getReview() != c1)
                checkResults("Failed to retrieve review");
        } catch(Exception e) {
            System.err.println("PANIC: Unexpected exception at vector " + vector);
            e.printStackTrace();
        }
        
        if(result != 0) System.err.println("\nFAIL: Result code " + result);
        System.exit(result);
    }
}
