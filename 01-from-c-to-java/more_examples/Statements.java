public class Statements {
    public static void main(String[] args) {
        int i=5, j=10;
        
        // This is a ternary - an in-line "if / else" construct
        System.out.println(
            ((i<j) ? "i" : "j")
          + " is greater");
          
        // This is a switch expression - an in-line "switch" construct!
        System.out.println(
            switch(i) {
                case 5  -> "5";
                case 10 -> "10";
                default -> "something else";
            }
          + " is the value of i"
        );
    }
}
