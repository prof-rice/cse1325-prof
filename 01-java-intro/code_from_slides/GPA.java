import java.util.Scanner;

public class GPA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first, last;
        double gpa;
        System.out.print("What is your name and GPA? ");
        first = in.next();
        last  = in.next();
        gpa   = in.nextDouble();
        System.out.println("Hello " + first + ' ' + last
                         + " (GPA " + gpa + ")!");
    }
}
