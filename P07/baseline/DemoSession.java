package demo;

import session.Course;
import session.DateRange;
import session.Session;

import people.Student;
import people.Tutor;

import java.util.Arrays;

public class DemoSession {
    public static void main(String[] args) {
        try {
            // Create some DateRange objects
            System.out.println("\nCreating DateRange objects\n");
            DateRange dr1 = new DateRange("2025-10-03", "10:15", "11:00");
            DateRange dr2 = new DateRange("2026-01-31", "12:15", 120);

            System.out.println("  DateRange " + dr1 + " with duration " + dr1.duration());
            System.out.println("  Should be 2025-10-03 10:15 - 11:00 (45 minutes)");
            System.out.println("  DateRange " + dr2 + " with duration " + dr2.duration());
            System.out.println("  Should be 2026-01-31 12:15 - 14:15 (120 minutes)");
            System.out.println("  Exact formats are permitted to vary!");
        
            // Create some supporting objects
            System.out.println("\nCreating courses\n");
            Course c1 = new Course("CSE", 1310);
            Course c2 = new Course("CSE", 1320);
            Course c3 = new Course("CSE", 1325);

            System.out.println("          " + c1 + " " + c2 + " " + c3 +
                             "\nshould be CSE1310 CSE1320 CSE1325");
            
            System.out.println("\nCreating people");
            Tutor t1 = new Tutor("Charlie Bright", "cub6279@mavs.uta.edu", 729328190,
                "BSCE 2026 candidate, 2 yrs C experience", c1);
            Tutor t2 = new Tutor("Chandra Tutorful", "cat8831@mavs.uta.edu", 882357834,
                "PhD candidate in CS, 6 yrs C and 2 yrs Java experience", c2);
            Tutor t3 = new Tutor("Aisha GoodTutor", "alt1399@mavs.uta.edu", 382825938,
                "Master's candidate in CpE, 8 yrs Java experience!", c3);

            Student s1 = new Student("Isabella Studious", "ies9120@mavs.uta.edu");
            s1.addCourse(c1);
            Student s2 = new Student("Roger Wilcompete", "row5381@mavs.uta.edu");
            s2.addCourse(c2);
            s2.addCourse(c3);
            Student s3 = new Student("Hai Codesense", "ies9120@mavs.uta.edu");
            s3.addCourse(c3);

            System.out.println("\n  " + t1 + " (tutor for " + t1.getCourse() + ")" +
                               "\n  " + t2 + " (tutor for " + t2.getCourse() + ")" +
                               "\n  " + t3 + " (tutor for " + t3.getCourse() + ")" +
                               "\n  " + s1 + " (taking " + Arrays.toString(s1.getCourses()) + ")" +
                               "\n  " + s2 + " (taking " + Arrays.toString(s2.getCourses()) + ")" +
                               "\n  " + s3 + " (taking " + Arrays.toString(s3.getCourses()) + ")");
            
            // Finally, a couple of sessions!
            System.out.println("\nCreating sessions");

            Session ss1 = new Session(c1, t1);
            ss1.setSchedule("2025-11-05", "13:00", 180);
            ss1.addStudent(s1);

            Session ss2 = new Session(c2, t2);
            ss2.setSchedule("2025-11-07", "08:00", 90);
            ss2.addStudent(s2);

            Session ss3 = new Session(c3, t3);
            ss3.setSchedule("2025-11-12", "17:00", 120);
            ss3.addStudent(s2);
            ss3.addStudent(s3);

            System.out.println("\n  "   + ss1 +
                               "\n\n  " + ss2 +
                               "\n\n  " + ss3);
        } catch(Exception e) {
            System.err.println("PANIC: Unexpected exception:");
            e.printStackTrace();
        }
    }
}
