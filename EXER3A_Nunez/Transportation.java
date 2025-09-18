public class Transportation {
    String name;
    int capacity;
    double speed;

    public Transportation(String name, int capacity, double speed) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Capacity: " + capacity + ", Speed: " + speed + " km/h");
    }
}


