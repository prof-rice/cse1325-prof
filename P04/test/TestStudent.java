package test;

import product.Media;

import customer.Student;
import customer.Account;

public class TestStudent {
    public static void main(String[] args) {
        int vector = 1;
        int result = 0;
        
        // Verify that the Student's ``toString()`` method returns the correct representation 
        //   for a ``Student`` object.
        Student s1 = new Student("Prof Rice", 1234567890, "george.rice@uta.edu", true);
        String actual = s1.toString();
        String expected = "Prof Rice (1234567890, george.rice@uta.edu, Account #1";
        if(!actual.equals(expected)) {
            System.err.println("FAIL: Expected student " + expected + '\n'
                                 + "  Actual   student " + actual);
                result |= vector;
        }
        vector <<= 1;
        
        // Verify that if a non-UTA email is used to instance a new Student, 
        //   an ``IllegalArgumentException`` is thrown and that the message is 
        //   "Non-UTA email address: " and the email address.
        String badEmail = "george.rice@example.com";
        try {
            Student s2 = new Student("Prof Rice", 1234567890, badEmail, true);
            System.err.println("FAIL: Expected IllegalArgumentException for " + badEmail);
            System.err.println("      NO exception thrown");
            result |= vector;
        } catch (IllegalArgumentException e) {
            expected = "Non-UTA email address: " + badEmail;
            actual = e.getMessage();
            if(!actual.equals(expected)) {
                System.err.println("FAIL: Expected message " + expected + '\n'
                                     + "  Actual   message " + actual);
                result |= vector;
            }
        } catch (Exception e) {
            System.err.println("FAIL: Expected IllegalArgumentException for " + badEmail);
            System.err.println("      Following exception thrown instead\n" + e);
            result |= vector;
        }
        
        // Verify that requesting media from Student returns "Playing " and the media
        String title = "The Little Shop of Horrors";
        String url = "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0";
        int points = 5;
        Media media = new Media(title, url, points);
        expected = "Playing " + title + " (" + url + ", " + points + " points)";
        actual = s1.requestMedia(media);
        if(!actual.equals(expected)) {
            System.err.println("FAIL: Expected media request result \n" + expected + '\n'
                                 + "  Actual   media request result \n" + actual);
                result |= vector;
        }
        vector <<= 1;
        
        if(result != 0) System.err.println("\nFAIL: Error code " + result);
        System.exit(result);
    }
}
