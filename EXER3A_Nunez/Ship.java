public class Ship extends WaterTransportation {
    String shipType;
    int crewSize;

    public Ship(String name, int capacity, double speed,
                double displacement, double maxRange, String hullMaterial,
                String shipType, int crewSize) {
        super(name, capacity, speed, displacement, maxRange, hullMaterial);
        this.shipType = shipType;
        this.crewSize = crewSize;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  ShipType: " + shipType + ", CrewSize: " + crewSize);
    }
}


