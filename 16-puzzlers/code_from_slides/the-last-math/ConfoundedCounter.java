public class ConfoundedCounter {
    public static void main(String[] args) {
        int[] ints = {006, 012, 024, 036, 
                      072, 144, 288, 576};
        
        for(int i=0; i<ints.length; ++i) {
            if(i == 4) System.out.println();
            System.out.printf(", %03d", ints[i]);
        }
        System.out.println();
    }
}
