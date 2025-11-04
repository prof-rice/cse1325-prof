package people;

import session.Course;

import java.io.PrintStream;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Student extends Person {
    public Student(String name, String email) {
        super(name, email);
        this.studentID = nextStudentID++;
        this.courses = new ArrayList<>();
    }
    public Student(Scanner in) {
        super(in);
        this.nextStudentID = in.nextInt(); in.nextLine();
        this.studentID = in.nextInt(); in.nextLine();

        this.courses = new ArrayList<>();
        int size = in.nextInt(); in.nextLine();
        while(size-- > 0)
            courses.add(new Course(in));
    }
    public void save(PrintStream out) {
        super.save(out);
        out.println(nextStudentID);
        out.println(studentID);

        out.println(courses.size());
        for(var c : courses)
            c.save(out);
    }
    public void addCourse(Course course) {
        courses.add(course);
    }
    public Course[] getCourses() {
        return courses.toArray(new Course[courses.size()]);
    }
    @Override
    public String toString() {
        String s = super.toString();
        return s.substring(0, s.indexOf(')')) + ", #" + studentID + ")";
    //  return name + " ("+ email  + ", #" + studentID + ")";
    }
    private static int nextStudentID = 0;
    private int studentID;
    private List<Course> courses;
}
