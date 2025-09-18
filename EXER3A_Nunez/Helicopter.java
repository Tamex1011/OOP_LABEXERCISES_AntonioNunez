public class Helicopter extends AirTransportation {
    String rotorType;
    int numberOfBlades;

    public Helicopter(String name, int capacity, double speed,
                      double altitudeRange, String fuelType, double wingspan,
                      String rotorType, int numberOfBlades) {
        super(name, capacity, speed, altitudeRange, fuelType, wingspan);
        this.rotorType = rotorType;
        this.numberOfBlades = numberOfBlades;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  RotorType: " + rotorType + ", Blades: " + numberOfBlades);
    }
}


