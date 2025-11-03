import java.util.ArrayList;

public class SimpleGenericMethod {
    public static <T> void printIt(T value) {
        System.out.println(value);
    }
    public static void main(String[] args) {
        printIt(42);
        printIt("Hello, World!");
        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(Math.PI); doubles.add(Math.E);
        printIt(doubles);
    }
}
