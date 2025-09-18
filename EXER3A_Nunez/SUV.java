public class SUV extends LandTransportation {
    String brand;
    String model;
    String driveTrain; // e.g., FWD, RWD, AWD, 4x4

    public SUV(String name, int capacity, double speed,
               int numberOfWheels, String fuelType, String terrainType,
               String brand, String model, String driveTrain) {
        super(name, capacity, speed, numberOfWheels, fuelType, terrainType);
        this.brand = brand;
        this.model = model;
        this.driveTrain = driveTrain;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Brand: " + brand + ", Model: " + model + ", DriveTrain: " + driveTrain);
    }
}


