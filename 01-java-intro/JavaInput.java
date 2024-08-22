public class JavaInput {
    public static void main(String[] args) {
        String s = System.console().readLine("Enter an int: ");
        int i  = Integer.parseInt(s);
        double d = Double.parseDouble(System.console().readLine("Enter a double: "));
        System.out.println("The sum is " + (i + d));
    }
}
