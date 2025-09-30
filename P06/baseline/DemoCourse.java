import java.util.Set;
import java.util.HashSet;

import java.util.Scanner;

public class DemoCourse {
    private static Scanner in = new Scanner(System.in);
    private static Set<Course> courses = new HashSet<>();
    public static void main(String[] args) {
        Course c1 = new Course("CSE", 1310);
        Course c2 = new Course("CSE", 1325);
        Course c3 = new Course("CSE", 1325);
        if( c1.equals(c2)) System.err.println("ERROR: Reporting CSE1310.equals(CSE1325)");
        if(!c2.equals(c3)) System.err.println("ERROR: Reporting !CSE1325.equals(CSE1325)");
        
        System.out.println("Enter courses such as 'CSE 1325' (Ctrl-d or Ctrl-z to quit)");
        while(in.hasNext()) {
            try {
                Course c = new Course(in.next(), in.nextInt());
                System.out.println("You specified " + c);
                if(courses.contains(c))
                    System.err.println("You already defined that one!");
                courses.add(c);
            } catch(InvalidCourseException e) {
                System.err.println(e);
            } catch(Exception e) {
                System.err.println("\nPANIC: Unexpected exception");
                e.printStackTrace();
            }
        }
        
        System.out.println("\nYou defined these courses:");
        for(Course c : courses) System.out.println("  " + c);
        
        
    }

}
