import java.util.Random;

public class Primitives {
    private static Random random = new Random();
    public static double getFinalGrade() {
        return 100.0 - Math.pow(4.0 * Math.random(), 3.0);
    }
    public static void main(String[] args) {
        for(int i=0; i<10; ++i) {
            System.out.println("For Student " + i + ", " +
                switch(getFinalGrade()) {
                    case double x when x > 89.9 -> " an A (" + x + ")";
                    case double x when x > 79.9 -> " a  B (" + x + ")";
                    case double x when x > 69.9 -> " a  C (" + x + ")";
                    case double x when x > 59.9 -> " a  D (" + x + ")";
                    case double x               -> " an F (" + x + ")";
                }
            );
        }
    }
}
