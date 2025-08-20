public class Parse {
    public static void main(String[] args) {
        String prompt = "Enter a double: ";
        String d1 = System.console().readLine(prompt);
        String d2 = System.console().readLine(prompt);
        
        String fmt = "Sum is %.2f\n";
        System.console().printf(fmt, Double.parseDouble(d1)
                                   + Double.parseDouble(d2));
    }
}   
