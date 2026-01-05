// Square.java - Subclass of Rectangle
public class Square extends Rectangle {
    
    public Square(float side) {
        super(side, side);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Square - Side: " + length);
    }
    
    public float getSide() {
        return length;
    }
}
