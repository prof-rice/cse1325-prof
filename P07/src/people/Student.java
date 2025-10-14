package people;

import session.Course;

import java.util.List;
import java.util.ArrayList;

public class Student extends Person {
    public Student(String name, String email) {
        super(name, email);
        this.studentID = nextStudentID++;
        this.courses = new ArrayList<>();
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
