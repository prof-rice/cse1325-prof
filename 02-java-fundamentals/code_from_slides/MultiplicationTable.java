// Example #2: Multiplication Table
//
// Techniques Illustrated
//
// Different in Java:
//
// Similar to C:
//   Formatted output with printf
//   3-term for loops

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.printf("%30sTimes 12 Table\n\n", " ");
    
        System.out.print("     ");
        for(int x=0; x<=12; ++x) {
            System.out.printf("%4d ", x);
        }
        
        System.out.print("\n     ");
        for(int x=0; x<=12; ++x) {
            System.out.printf("---- ", x);
        }
        for(int y=0; y<=12; ++y) {
            System.out.printf("\n%2d | ", y);
            for(int x=0; x<=12; ++x) {
                System.out.printf("%4d ", x*y);
            }
        }
        System.out.println();
    }
}
