public class RightTriangle {
    private Double a;
    private Double b;
    public RightTriangle(Double a, Double b) {
        this.a = a;
        this.b = b;
    }
    public Double hypotenuse() {
        Double c = Math.sqrt(a*a + b*b);
        return c;
    }
    public static void main(String[] args) {
        Double a = 3.0;
        Double b = 4.0;
        RightTriangle rt = new RightTriangle(a, b);
        Double c = rt.hypotenuse();
        System.out.printf("The hypotenuse is: %f\n", c);
    }
}
