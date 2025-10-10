import java.util.Scanner;

public class DemoTutor {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Tutor oldTutor = null;
        while(true) {
            try {
                System.out.println("\nDefine Tutor by entering name, email, and SSN on separate lines (blank name when done):");
                String name = in.nextLine();
                if(name.isEmpty()) break;
                String email = in.nextLine();
                int ssn = Integer.parseInt(in.nextLine());
                System.out.println("Define course by entering dept and number on same line:");
                Course course = new Course(in.next(), Integer.parseInt(in.next())); in.nextLine();
                System.out.println("Enter bio (blank line when done):");
                String bio = "";
                while(true) {
                    String line = in.nextLine();
                    if(line.isEmpty()) break;
                    bio += "\n" + line;
                }
                Tutor tutor = new Tutor(name, email, ssn, bio, course);
                if(oldTutor != null && tutor.equals(oldTutor))
                    System.out.println("\n==> Same tutor as last time! <==\n");
                oldTutor = tutor;
                System.out.println(tutor);
            } catch(Exception e) {
                System.err.println("PANIC: Exception thrown\n");
                e.printStackTrace();
            }
        }
    }
}
