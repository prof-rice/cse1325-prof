package demo;

import people.Student;

import session.Course;

import java.util.Scanner;

public class DemoStudent {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Student oldStudent = null;
        while(true) {
            try {
                System.out.println("\nDefine Student by entering name and email on separate lines (blank name when done):");
                String name = in.nextLine();
                if(name.isEmpty()) break;
                Student student = new Student(name, in.nextLine());
                System.out.println("Define courses by entering dept and number on same line (blank line when done):");
                while(true) {
                    String line = in.nextLine();
                    if(line.isEmpty()) break;
                    String[] sa = line.split("\\s+"); // Split on whitespace
                    if(sa.length == 2) {
                        Course course = new Course(sa[0], Integer.parseInt(sa[1]));
                        student.addCourse(course);
                    } else {
                        System.err.println("Must have a space between dept and number! Try again.");
                    }
                }
                if(oldStudent != null && student.equals(oldStudent))
                    System.out.println("\n==> Same student as last time! <==\n");
                oldStudent = student;
                if(!student.getCourses().getClass().isArray())
                    throw new RuntimeException("#### ERROR: student.getCourses() MUST return an array!");
                System.out.println("Student " + student + " is seeking tutoring in:");
                for(Course c : student.getCourses()) System.out.println("  " + c);
            } catch(Exception e) {
                System.err.println("PANIC: Exception thrown\n");
                e.printStackTrace();
            }
        }
    }
}
