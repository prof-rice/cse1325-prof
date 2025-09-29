public class Rectangle extends Shape {
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public double area() {
        return width * height;
    }
    @Override
    public String toString() {
        return "Rectangle";
    }
    private double width;
    private double height;
}
