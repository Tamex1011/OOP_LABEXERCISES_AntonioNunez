// ShapeTester.java - Test class for the shape hierarchy
public class ShapeTester {
    public static void main(String[] args) {
        System.out.println("=== Individual Shape Information ===");
        
        Circle circle = new Circle(3.0f);
        circle.displayInfo();
        circle.displayArea();
        System.out.println();
        
        Square square = new Square(5.0f);
        square.displayInfo();
        square.displayArea();
        System.out.println();
        
        Rectangle rect = new Rectangle(5.0f, 4.0f);
        rect.displayInfo();
        rect.displayArea();
        System.out.println();
        
        Triangle triangle = new Triangle(6.0f, 8.0f);
        triangle.displayInfo();
        triangle.displayArea();
        System.out.println();
        
        System.out.println("=== Polymorphic Array Display ===");
        Shape[] shapes = {circle, square, rect, triangle};
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].displayInfo();
            shapes[i].displayArea();
            System.out.println();
        }
        
        System.out.println("=== Total Area Calculation ===");
        float totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.area;
        }
        System.out.println("Total area of all shapes: " + totalArea);
    }
}
