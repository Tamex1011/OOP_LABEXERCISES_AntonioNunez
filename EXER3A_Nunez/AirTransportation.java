public class AirTransportation extends Transportation {
    double altitudeRange; // in meters
    String fuelType;
    double wingspan; // in meters

    public AirTransportation(String name, int capacity, double speed,
                             double altitudeRange, String fuelType, double wingspan) {
        super(name, capacity, speed);
        this.altitudeRange = altitudeRange;
        this.fuelType = fuelType;
        this.wingspan = wingspan;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Name: " + name +
            ", Capacity: " + capacity +
            ", Speed: " + speed + " km/h" +
            ", AltitudeRange: " + altitudeRange + " m" +
            ", Fuel: " + fuelType +
            ", Wingspan: " + wingspan
        );
    }
}


