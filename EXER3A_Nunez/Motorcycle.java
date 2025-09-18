public class Motorcycle extends LandTransportation {
    String engineTypeOrDisplacement; // per diagram: Engine/Displacement
    String type; // e.g., Sport, Cruiser
    String brand;

    public Motorcycle(String name, int capacity, double speed,
                      int numberOfWheels, String fuelType, String terrainType,
                      String engineTypeOrDisplacement, String type, String brand) {
        super(name, capacity, speed, numberOfWheels, fuelType, terrainType);
        this.engineTypeOrDisplacement = engineTypeOrDisplacement;
        this.type = type;
        this.brand = brand;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Engine/Displacement: " + engineTypeOrDisplacement + ", Type: " + type + ", Brand: " + brand);
    }
}


