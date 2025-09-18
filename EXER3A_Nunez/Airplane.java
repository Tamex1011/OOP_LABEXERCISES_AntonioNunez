public class Airplane extends AirTransportation {
    String airline;
    int numberOfEngines;

    public Airplane(String name, int capacity, double speed,
                    double altitudeRange, String fuelType, double wingspan,
                    String airline, int numberOfEngines) {
        super(name, capacity, speed, altitudeRange, fuelType, wingspan);
        this.airline = airline;
        this.numberOfEngines = numberOfEngines;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Airline: " + airline + ", Engines: " + numberOfEngines);
    }
}


