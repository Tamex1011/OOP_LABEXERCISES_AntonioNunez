// Rectangle.java - Subclass of Shape
public class Rectangle extends Shape {
    protected float length;
    protected float width;
    
    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
        calculateArea();
    }
    
    @Override
    public void calculateArea() {
        area = length * width;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Rectangle - Length: " + length + ", Width: " + width);
    }
    
    public float getLength() {
        return length;
    }
    
    public float getWidth() {
        return width;
    }
}
