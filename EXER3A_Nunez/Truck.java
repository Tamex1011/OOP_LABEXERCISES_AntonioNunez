public class Truck extends LandTransportation {
    double loadCapacity; // tons
    String brand;
    int numberOfAxle;

    public Truck(String name, int capacity, double speed,
                 int numberOfWheels, String fuelType, String terrainType,
                 double loadCapacity, String brand, int numberOfAxle) {
        super(name, capacity, speed, numberOfWheels, fuelType, terrainType);
        this.loadCapacity = loadCapacity;
        this.brand = brand;
        this.numberOfAxle = numberOfAxle;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  LoadCapacity: " + loadCapacity + " t, Brand: " + brand + ", Axles: " + numberOfAxle);
    }
}


