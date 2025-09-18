public class Kariton extends LandTransportation {
    String material;
    double weight; // kg
    String wheelsType; // replacing brakes per diagram emphasis on cart specifics

    public Kariton(String name, int capacity, double speed,
                   int numberOfWheels, String fuelType, String terrainType,
                   String material, double weight, String wheelsType) {
        super(name, capacity, speed, numberOfWheels, fuelType, terrainType);
        this.material = material;
        this.weight = weight;
        this.wheelsType = wheelsType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Material: " + material + ", Weight: " + weight + " kg, Wheels: " + wheelsType);
    }
}


