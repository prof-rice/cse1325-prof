public class MaxTest {
    public static Integer max(Integer lhs, Integer rhs) {
        // if (lhs > rhs) return lhs; else return rhs;
        // return lhs > rhs ? lhs : rhs;
        // if (lhs.compareTo(rhs) > 0) return lhs; else return rhs;
        return lhs.compareTo(rhs) > 0 ? lhs : rhs;
    }
    public static void main(String[] args) {
        System.out.println("The larger of 3 and 42 is " + max(3,42));
    }
}
