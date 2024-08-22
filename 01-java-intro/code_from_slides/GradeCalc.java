import java.util.Scanner;

public class GradeCalc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double sumOfGrades = 0;
        int numGrades = 0;
        System.out.println("Enter grades. Press Control-d (Linux, Mac) or Control-z (Windows) when done.");
        while(in.hasNextDouble()) {
            sumOfGrades += in.nextDouble();
            ++numGrades;
        }
        System.out.println("The student's average grade is " + sumOfGrades / numGrades);
    }
}
