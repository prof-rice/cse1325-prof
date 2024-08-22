public class Statements {
    public static void main(String[] args) {
        int i=5, j=10;
        System.out.println(
            ((i<j) ? "i" : "j")
          + " is greater");
        System.out.println("i is " +
          switch(i) {
            case 5  -> "5";
            case 10 -> "10";
            default -> "something else";
          });
    }
}
