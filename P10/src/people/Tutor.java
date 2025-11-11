package people;

import session.Course;

import java.io.PrintStream;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;

public class Tutor extends Person {
    public static final int MIN_SSN = 001_01_0001;
    public static final int MAX_SSN = 999_99_9999;
    public Tutor(String name, String email, int ssn, String bio, Course course) {
        super(name, email);
        int firstField = ssn % 1_00_0000;
        int secondField = (ssn - firstField*1_00_0000) / 1000;
        int thirdField = ssn % 1000;
        if(ssn < MIN_SSN || ssn > MAX_SSN || 
            firstField == 0 || secondField == 0 || thirdField == 0)
            throw new IllegalArgumentException("Invalid SSN");
        this.ssn = ssn;
        this.bio = bio;
        this.course = course;
    }
    public Tutor(Scanner in) {
        super(in);
        this.ssn = in.nextInt(); in.nextLine();
        this.bio = in.nextLine();
        this.course = new Course(in);
    }
    public void save(PrintStream out) {
        super.save(out);
        out.println(ssn);
        out.println(bio);
        course.save(out);
    }
    public int getSSN() {
        return ssn;
    }
    public Course getCourse() {
        return course;
    }
    public String getBio() {
        return bio;
    }
    private String bio;
    private int ssn;
    private Course course;
}
