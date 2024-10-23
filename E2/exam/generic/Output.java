 public class Output {
    public static void $print(int value) {
        System.out.print(value + " ");
    }
    public static void main(String[] args) {
        for(int i=0; i<5; ++i) $print(i);
        System.out.println();
    }
 }

