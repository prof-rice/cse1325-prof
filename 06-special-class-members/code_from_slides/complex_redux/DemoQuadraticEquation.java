public class DemoQuadraticEquation {
    public static void main(String[] args) {
        Complex a = new Complex(1,0);
        Complex b = new Complex(2,1);
        Complex c = new Complex(1,1);
        QuadraticEquation qe = new QuadraticEquation(a, b, c);
        Complex[] roots = qe.solve();
        System.out.println("The solutions to (" + 
            a + ")x² + (" + b + ")x + (" + c + ") = 0 are\n(" +
            roots[0] + ") and (" + roots[1] + ")");
    }
}
