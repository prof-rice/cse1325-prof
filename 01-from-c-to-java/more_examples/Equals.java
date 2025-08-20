public class Equals {
    public static void main(String[] args) {
        Integer i=500; // Capital I - these are NOT primitives!
        Integer j=500;
        if(i==j) System.out.println("==");
        if(i.equals(j)) System.out.println("equals");
    }
}
