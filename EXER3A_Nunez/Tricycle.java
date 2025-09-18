public class Tricycle extends LandTransportation {
    boolean hasSidecar;
    String color;

    public Tricycle(String name, int capacity, double speed,
                    int numberOfWheels, String fuelType, String terrainType,
                    boolean hasSidecar, String color) {
        super(name, capacity, speed, numberOfWheels, fuelType, terrainType);
        this.hasSidecar = hasSidecar;
        this.color = color;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Sidecar: " + (hasSidecar ? "Yes" : "No") + ", Color: " + color);
    }
}


