public class Top3 {
    private Integer first = null;
    private Integer second = null;
    private Integer third = null;
    public void add(Integer x) {
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
    public Integer getFirst() {
        return this.first;
    }
    public Integer getSecond() {
        return this.second;
    }
    public Integer getThird() {
        return this.third;
    }
    public static void main(String[] args) {
        Top3 top3 = new Top3();
        java.util.Scanner in = new java.util.Scanner(System.in);
        while(true) {
            try {
                System.out.print("Enter any integer (Ctrl-C to exit): ");
                top3.add(in.nextInt());
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
