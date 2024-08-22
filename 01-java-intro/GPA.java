import java.util.Scanner;

public class GPA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name;
        int hours;
        double gpa;
        System.out.print("What is your name, hours this semester, and GPA? ");
        name = in.nextLine();
        hours = in.nextInt();
        gpa   = in.nextDouble();
        System.out.println("Hello " + name
                         + " (taking " + hours + " with a " + gpa + " GPA!");
    }
}
