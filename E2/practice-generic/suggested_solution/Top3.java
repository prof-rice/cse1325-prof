public class Top3 <T extends Comparable<T>> {
    private T first = null;
    private T second = null;
    private T third = null;
    public void add(T x) {
        if(first == null || x.compareTo(first) > 0) {
            third = second;
            second = first;
            first = x;
        } else if(second == null || x.compareTo(second) > 0) {
            third = second;
            second = x;
        } else if(third == null || x.compareTo(third) > 0) {
            third = x;
        }
    }
    public T getFirst() {
        return this.first;
    }
    public T getSecond() {
        return this.second;
    }
    public T getThird() {
        return this.third;
    }
    public static void main(String[] args) {
        Top3<Triple> top3 = new Top3<>();
        java.util.Scanner in = new java.util.Scanner(System.in);
        while(true) {
            try {
                System.out.print("Enter any 3 integers (Ctrl-C to exit): ");
                Triple t = new Triple(in.nextInt(), in.nextInt(), in.nextInt());
                top3.add(t);
                System.out.print("Top 3 are: " + top3.getFirst());
                if(top3.getSecond() != null) System.out.print(" " + top3.getSecond());
                if(top3.getThird() != null) System.out.print(" " + top3.getThird());
                System.out.println();
            } catch(Exception e) {
                System.err.println("Invalid input!");
                e.printStackTrace();
            }
        }
    }
}
