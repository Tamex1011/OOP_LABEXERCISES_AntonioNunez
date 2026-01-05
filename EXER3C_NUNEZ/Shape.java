// Shape.java - Base class for all shapes
public abstract class Shape {
    protected float area;
    
    public abstract void calculateArea();
    public abstract void displayInfo();
    
    public void displayArea() {
        System.out.println("Area: " + area);
    }
}