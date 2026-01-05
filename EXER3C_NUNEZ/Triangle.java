// Triangle.java - Subclass of Shape
public class Triangle extends Shape {
    private float base;
    private float height;
    
    public Triangle(float base, float height) {
        this.base = base;
        this.height = height;
        calculateArea();
    }
    
    @Override
    public void calculateArea() {
        area = 0.5f * base * height;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Triangle - Base: " + base + ", Height: " + height);
    }
    
    public float getBase() {
        return base;
    }
    
    public float getHeight() {
        return height;
    }
}