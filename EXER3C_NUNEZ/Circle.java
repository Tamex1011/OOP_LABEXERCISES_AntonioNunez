// Circle.java - Subclass of Shape
public class Circle extends Shape {
    private float radius;
    
    public Circle(float radius) {
        this.radius = radius;
        calculateArea();
    }
    
    @Override
    public void calculateArea() {
        area = (float) (Math.PI * radius * radius);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Circle - Radius: " + radius);
    }
    
    public float getRadius() {
        return radius;
    }
}