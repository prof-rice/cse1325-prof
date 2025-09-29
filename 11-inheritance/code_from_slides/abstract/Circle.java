public class Circle extends Shape {
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    @Override
    public String toString() {
        return "Circle";
    }
    private double radius;
}
