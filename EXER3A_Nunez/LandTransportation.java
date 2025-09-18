public class LandTransportation extends Transportation {
    int numberOfWheels;
    String fuelType;
    String terrainType;

    public LandTransportation(String name, int capacity, double speed,
                              int numberOfWheels, String fuelType, String terrainType) {
        super(name, capacity, speed);
        this.numberOfWheels = numberOfWheels;
        this.fuelType = fuelType;
        this.terrainType = terrainType;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Name: " + name +
            ", Capacity: " + capacity +
            ", Speed: " + speed + " km/h" +
            ", Wheels: " + numberOfWheels +
            ", Fuel: " + fuelType +
            ", Terrain: " + terrainType
        );
    }
}


