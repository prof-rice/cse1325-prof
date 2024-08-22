import java.util.Scanner;

public class JavaInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int num1, num2;
        num1 = in.nextInt();
        num2 = in.nextInt();
        System.out.println("The sum        is " + (num1 + num2));
        System.out.println("The difference is " + (num1 - num2));
        System.out.println("The product    is " + (num1 * num2));
    }
}
