public class MaxGeneric {
    // Generic for any non-primitive type T that implements ("extends") 
    //    interface Comparable (i.e., overrides its abstract compareTo method)
    public static <T extends Comparable<T>> T max(T lhs, T rhs) {
        if (lhs.compareTo(rhs) > 0) return lhs; else return rhs;
    }
    public static void main(String[] args) {
        System.out.println("The larger of 3 and 42 is " + max(3,42));
        System.out.println("The larger of 3.1415 and 2.718 is " + max(3.1415, 2.718));
        System.out.println("The larger of (1,2,3) and (2,1,-4) is " + 
    	    max(new Coordinate(1,2,3), new Coordinate(2,1,-4)));
    }
}
