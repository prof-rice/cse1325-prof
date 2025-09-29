import java.util.Scanner;
import java.util.ArrayList;

public class Shapes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Shape> shapes = new ArrayList<>();
        
        System.out.print("What's the circle radius? ");
        shapes.add(new Circle(scanner.nextDouble()));
        
        System.out.print("What's the size of the square? ");
        shapes.add(new Square(scanner.nextDouble()));
        
        System.out.print("What's the width and length of the rectangle? ");
        shapes.add(new Rectangle(scanner.nextDouble(), scanner.nextDouble()));
        
        for(var s : shapes) 
            System.out.println("Shape " + s + "'s area is " + s.area());
    }
}
