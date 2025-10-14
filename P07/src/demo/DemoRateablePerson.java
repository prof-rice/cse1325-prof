package demo;

import rating.Rateable;
import rating.Rating;
import rating.Comment;

import people.Person;
import people.Student;
import people.Tutor;

import session.Course;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DemoRateablePerson {
    private static Scanner in = new Scanner(System.in);
    private static List<Rateable> rateables = new ArrayList<>(); 
    public static void main(String[] args) {
        System.out.println("Enter your name and email on separate lines:");
        Person rater = new Person(in.nextLine(), in.nextLine());

            try {
                rateables.add(new Student("Suzy Q", "sq1234@uta.edu"));
                rateables.add(new Student("Newzy Who", "nw3456@uta.edu"));
                rateables.add(new Tutor("Tutor Due", "td5678@uta.edu", 123456789, 
                                        "Great tutor!", new Course("CSE", 1325)));
                for(Rateable r : rateables) {
                    while(true) {
                        System.out.print("\n\nRate " + r + " between 1 and 5 (-1 when done): ");
                        int stars = in.nextInt(); in.nextLine();
                        if(stars < 1 || stars > 5) break;
                        System.out.print("Enter a review or a blank line: ");
                        String line = in.nextLine();
                        Comment review = null;
                        if(!line.isEmpty()) review = new Comment(line, rater, null);
                        Rating rating = new Rating(stars, review);
                        r.addRating(rating);
                    }
                }
                
                for(Rateable r : rateables) {
                    System.out.println("\n\n" + r + " average rating is " + r.getAverageRating());
                    for(Rating rating : r.getRatings()) {
                        Comment review = rating.getReview();
                        System.out.println("    " + rating + "  " + 
                            ((review != null) ? review.toString().replace("\n", "\n           ") 
                                              : "(Anonymous)"));
                    }
                    System.out.println();
                }
            } catch(Exception e) {
                System.err.println("PANIC: Exception thrown\n");
                e.printStackTrace();
            }

    }
}
